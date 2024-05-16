package com.project.back.dto.request.Board.InquiryBoard;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//게시물 수정 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class EditPostRequestDto 
{
    @NotBlank
    private String inquiryTitle; //문의 제목
    @NotBlank
    private String inquiryContents; // 문의 내용
}
