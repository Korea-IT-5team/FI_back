package com.project.back.dto.request.board.inquiryboard;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//게시물 답글 작성 Request Body Dto
@Getter
@Setter
@NoArgsConstructor
public class PostCommentRequestDto {
    @NotBlank
    private String inquiryComment;
}
