package com.project.back.dto.request.Board.InquiryBoard;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//게시물 답글 작성 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class WriteReplyToThePostRequestDto 
{
    @NotBlank
    private String comment; //답글 내용
}
