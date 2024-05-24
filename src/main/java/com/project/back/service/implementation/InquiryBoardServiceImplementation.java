package com.project.back.service.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.back.dto.request.board.inquiryboard.PatchInquiryBoardRequestDto;
import com.project.back.dto.request.board.inquiryboard.PostCommentRequestDto;
import com.project.back.dto.request.board.inquiryboard.PostInquiryBoardRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.board.inquiryboard.GetInquiryBoardListResponseDto;
import com.project.back.dto.response.board.inquiryboard.GetInquiryBoardResponseDto;
import com.project.back.dto.response.board.inquiryboard.GetMyInquiryBoardListResponseDto;
import com.project.back.dto.response.board.inquiryboard.GetSearchInquiryBoardListResponseDto;
import com.project.back.entity.InquiryBoardEntity;
import com.project.back.repository.InquiryBoardRepository;
import com.project.back.repository.UserRepository;
import com.project.back.service.InquiryBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InquiryBoardServiceImplementation implements InquiryBoardService {
  private final InquiryBoardRepository inquiryBoardRepository;
  private final UserRepository userRepository;

  @Override
  public ResponseEntity<ResponseDto> postBoard(PostInquiryBoardRequestDto dto, String userEmailId) {
    try {
      boolean isExistUser = userRepository.existsByUserEmailId(userEmailId);
      if (!isExistUser) return ResponseDto.authenticationFailed();

      InquiryBoardEntity inquiryBoardEntity = new InquiryBoardEntity(dto, userEmailId);
      inquiryBoardRepository.save(inquiryBoardEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

  @Override
  public ResponseEntity<ResponseDto> postComment(PostCommentRequestDto dto, int inquiryNumber) {
    try {
      InquiryBoardEntity inquiryBoardEntity = inquiryBoardRepository.findByInquiryNumber(inquiryNumber);
      if (inquiryBoardEntity == null) return ResponseDto.noExistInquiryBoard();

      boolean status = inquiryBoardEntity.getInquiryStatus();
      if (status) return ResponseDto.writtenComment();

      String comment = dto.getInquiryComment();
      inquiryBoardEntity.setInquiryStatus(true);
      inquiryBoardEntity.setInquiryComment(comment);

      inquiryBoardRepository.save(inquiryBoardEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

  @Override
  public ResponseEntity<? super GetInquiryBoardListResponseDto> getInquiryBoardList() {
    try {
      List<InquiryBoardEntity> inquiryBoardEntities = inquiryBoardRepository.findByOrderByInquiryNumberDesc();
      return GetInquiryBoardListResponseDto.success(inquiryBoardEntities);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
  }

  @Override
  public ResponseEntity<? super GetSearchInquiryBoardListResponseDto> getSearchInquiryBoardList(String searchWord) {
    try {
      List<InquiryBoardEntity> inquiryBoardEntities = inquiryBoardRepository.findByInquiryTitleContainsOrderByInquiryNumberDesc(searchWord);
      return GetSearchInquiryBoardListResponseDto.success(inquiryBoardEntities);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
  }

  @Override
  public ResponseEntity<? super GetMyInquiryBoardListResponseDto> getMyInquiryBoardList(String userEmailId) {
    try {
      List<InquiryBoardEntity> inquiryBoardEntities = inquiryBoardRepository.getMyInquiryBoardList(userEmailId);
      return GetMyInquiryBoardListResponseDto.success(inquiryBoardEntities);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
  }

  @Override
  public ResponseEntity<? super GetInquiryBoardResponseDto> getInquiryBoard(int inquiryNumber) {
    try {
      InquiryBoardEntity inquiryBoardEntity = inquiryBoardRepository.findByInquiryNumber(inquiryNumber);
      if (inquiryBoardEntity == null) return ResponseDto.noExistInquiryBoard();

      return GetInquiryBoardResponseDto.success(inquiryBoardEntity);
    } catch (Exception exception){
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
  }

  @Override
  public ResponseEntity<ResponseDto> patchInquiryBoard(PatchInquiryBoardRequestDto dto, int inquiryNumber, String userEmailId) {
    try {
      InquiryBoardEntity inquiryBoardEntity = inquiryBoardRepository.findByInquiryNumber(inquiryNumber);
      if (inquiryBoardEntity == null) return ResponseDto.noExistInquiryBoard();

      String writerId = inquiryBoardEntity.getInquiryWriterId();
      boolean isWriter = userEmailId.equals(writerId);
      if (!isWriter) return ResponseDto.authorizationFailed();

      boolean status = inquiryBoardEntity.getInquiryStatus();
      if (status) return ResponseDto.writtenComment();

      inquiryBoardEntity.update(dto);
      inquiryBoardRepository.save(inquiryBoardEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

  @Override
  public ResponseEntity<ResponseDto> deleteInquiryBoard(int inquiryNumber, String userEmailId) {
    try {
      InquiryBoardEntity inquiryBoardEntity = inquiryBoardRepository.findByInquiryNumber(inquiryNumber);
      if (inquiryBoardEntity == null) return ResponseDto.noExistInquiryBoard();
  
      String writerId = inquiryBoardEntity.getInquiryWriterId();
      boolean isWriter = userEmailId.equals(writerId);
      if (!isWriter) return ResponseDto.authorizationFailed();

      inquiryBoardRepository.delete(inquiryBoardEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }
}
