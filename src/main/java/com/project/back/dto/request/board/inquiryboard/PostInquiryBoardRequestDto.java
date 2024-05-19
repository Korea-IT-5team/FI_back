package com.project.back.dto.request.board.inquiryboard;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//게시물 문의 작성 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class PostInquiryBoardRequestDto 
{
    @NotBlank
    private String title; // 제목
    @NotBlank
    private String contents; // 내용
}
