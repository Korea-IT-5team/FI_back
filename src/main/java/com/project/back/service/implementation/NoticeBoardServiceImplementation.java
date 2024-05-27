package com.project.back.service.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.back.dto.request.board.noticeboard.PatchNoticeBoardRequestDto;
import com.project.back.dto.request.board.noticeboard.PostNoticeBoardRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.board.noticeboard.GetNoticeBoardListResponseDto;
import com.project.back.dto.response.board.noticeboard.GetNoticeBoardResponseDto;
import com.project.back.dto.response.board.noticeboard.GetSearchNoticeBoardResponseDto;
import com.project.back.entity.NoticeBoardEntity;
import com.project.back.repository.NoticeBoardRepository;
import com.project.back.repository.UserRepository;
import com.project.back.service.NoticeBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeBoardServiceImplementation implements NoticeBoardService {
    private final NoticeBoardRepository noticeBoardRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseDto> postBoard(PostNoticeBoardRequestDto dto, String userEmailId) {
        try {
            boolean isExistUser = userRepository.existsByUserEmailId(userEmailId);
            if(!isExistUser) return ResponseDto.authenticationFailed();

            NoticeBoardEntity noticeBoardEntity = new NoticeBoardEntity(dto, userEmailId);
            noticeBoardRepository.save(noticeBoardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetNoticeBoardListResponseDto> getNoticeBoardList() {
        try {
            List<NoticeBoardEntity> noticeBoardEntities = noticeBoardRepository.findByOrderByNoticeNumberDesc();
            return GetNoticeBoardListResponseDto.success(noticeBoardEntities);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetSearchNoticeBoardResponseDto> getSearchNoticeBoardList(String searchWord) {
        try {
            List<NoticeBoardEntity> noticeBoardEntities = noticeBoardRepository.findByNoticeTitleContainsOrderByNoticeNumberDesc(searchWord);
            return GetSearchNoticeBoardResponseDto.success(noticeBoardEntities);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetNoticeBoardResponseDto> getNoticeBoard(int noticeNumber) {
          try {
            NoticeBoardEntity noticeBoardEntity = noticeBoardRepository.findByNoticeNumber(noticeNumber);
            if (noticeBoardEntity == null) return ResponseDto.noExistNoticeBoard();

            return GetNoticeBoardResponseDto.success(noticeBoardEntity);
          } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
          }     
    }

    @Override
    public ResponseEntity<ResponseDto> patchNoticeBoard(PatchNoticeBoardRequestDto dto, int noticeNumber,
            String userEmailId) {
        try {
            NoticeBoardEntity noticeBoardEntity = noticeBoardRepository.findByNoticeNumber(noticeNumber);
            if (noticeBoardEntity == null) return ResponseDto.noExistNoticeBoard();

            String writerId = noticeBoardEntity.getNoticeWriterId();
            boolean isWriter = userEmailId.equals(writerId);
            if (!isWriter) return ResponseDto.authorizationFailed();

            noticeBoardEntity.update(dto);
            noticeBoardRepository.save(noticeBoardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteNoticeBoard(int noticeNumber, String userEmailId) {
        try {
            NoticeBoardEntity noticeBoardEntity = noticeBoardRepository.findByNoticeNumber(noticeNumber);
            if (noticeBoardEntity == null) return ResponseDto.noExistNoticeBoard();

            String writerId = noticeBoardEntity.getNoticeWriterId();
            boolean isWriter = userEmailId.equals(writerId);
            if (!isWriter) return ResponseDto.authorizationFailed();

            noticeBoardRepository.delete(noticeBoardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> increaseViewCount(int noticeNumber) {
        try {
            NoticeBoardEntity noticeBoardEntity = noticeBoardRepository.findByNoticeNumber(noticeNumber);
            if (noticeBoardEntity == null) return ResponseDto.noExistNoticeBoard();

            noticeBoardEntity.increaseViewCount();
            noticeBoardRepository.save(noticeBoardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
    
}
