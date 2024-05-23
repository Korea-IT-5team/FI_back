package com.project.back.service.implementation;

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
import com.project.back.service.InquiryBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InquiryBoardServiceImplementation implements InquiryBoardService {@Override
  public ResponseEntity<ResponseDto> postBoard(PostInquiryBoardRequestDto dto, String userEmailId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'postBoard'");
  }

  @Override
  public ResponseEntity<ResponseDto> postComment(PostCommentRequestDto dto, int inquiryNumber) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'postComment'");
  }

  @Override
  public ResponseEntity<? super GetInquiryBoardListResponseDto> getInquiryBoardList() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getInquiryBoardList'");
  }

  @Override
  public ResponseEntity<? super GetSearchInquiryBoardListResponseDto> getSearchInquiryBoardList(String searchWord) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSearchInquiryBoardList'");
  }

  @Override
  public ResponseEntity<? super GetMyInquiryBoardListResponseDto> getMyInquiryBoardList(String userEmailId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getMyInquiryBoardList'");
  }

  @Override
  public ResponseEntity<? super GetInquiryBoardResponseDto> getInquiryBoard(int inquiryNumber) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getInquiryBoard'");
  }

  @Override
  public ResponseEntity<ResponseDto> patchInquiryBoard(PatchInquiryBoardRequestDto dto, int inquiryNumber,
      String userEmailId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'patchInquiryBoard'");
  }

  @Override
  public ResponseEntity<ResponseDto> deleteInquiryBoard(int inquiryNumber, String userEmailId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteInquiryBoard'");
  }
  
}
