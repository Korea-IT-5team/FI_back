package com.project.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.back.dto.request.board.noticeboard.PatchNoticeBoardRequestDto;
import com.project.back.dto.request.board.noticeboard.PostNoticeBoardRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.board.noticeboard.GetNoticeBoardListResponseDto;
import com.project.back.dto.response.board.noticeboard.GetNoticeBoardResponseDto;
import com.project.back.dto.response.board.noticeboard.GetSearchNoticeBoardResponseDto;
import com.project.back.service.NoticeBoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notice-board")
public class NoticeBoardController {
    private final NoticeBoardService noticeBoardService;

    // 공지 작성 (제목, 내용)
    @PostMapping("/")
    public ResponseEntity<ResponseDto> postNoticeBoard(
        @RequestBody @Valid PostNoticeBoardRequestDto requestBody,
        // 이메일 가져오기
        @AuthenticationPrincipal String userEmailId
    ) {
        ResponseEntity<ResponseDto> response = noticeBoardService.postNoticeBoard(requestBody, userEmailId);
        return response;
    }

    @GetMapping("list")
    public ResponseEntity<? super GetNoticeBoardListResponseDto> getnoticeBoardList() {
        ResponseEntity<? super GetNoticeBoardListResponseDto> response = noticeBoardService.getNoticeBoardList();
        return response;
    }

    // 검색 
    @GetMapping("/list/search")
  public ResponseEntity<? super GetSearchNoticeBoardResponseDto> getSearchNoticeBoardList(
    @RequestParam("searchWord") String searchWord
  ) {
    ResponseEntity<? super GetSearchNoticeBoardResponseDto> response = noticeBoardService.getSearchNoticeBoardList(searchWord);
    return response;
  } 

  @GetMapping("{noticeNumber}")
  public ResponseEntity<? super GetNoticeBoardResponseDto> getNoticeBoard(
    @PathVariable("noticeNumber") int noticeNumber
  ) {
    ResponseEntity<? super GetNoticeBoardResponseDto> response = noticeBoardService.getNoticeBoard(noticeNumber);
    return response;
  }

  @PatchMapping("/{noticeNumber}")
  public ResponseEntity<ResponseDto> patchNoticeBoard(
    @RequestBody @Valid PatchNoticeBoardRequestDto requestBody,
    @PathVariable("noticeNumber") int noticeNumber,
    @AuthenticationPrincipal String userEmailId
  ) {
    ResponseEntity<ResponseDto> response = noticeBoardService.patchNoticeBoard(requestBody, noticeNumber, userEmailId);
    return response;
  }

  
  @PatchMapping("/{receptionNumber}/view-count")
  public ResponseEntity<ResponseDto> increaseViewCount (
      @PathVariable("noticeNumber") int noticeNumber
  ) {
      ResponseEntity<ResponseDto> response = noticeBoardService.increaseViewCount(noticeNumber);
      return response;
  }

  @DeleteMapping("/{noticeNumber}")
  public ResponseEntity<ResponseDto> deleteNoticeBoard(
    @PathVariable("noticeNumber") int noticeNumber,
    @AuthenticationPrincipal String userEmailId
  ) {
    ResponseEntity<ResponseDto> response = noticeBoardService.deleteNoticeBoard(noticeNumber, userEmailId);
    return response;
  }
}
