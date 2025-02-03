package com.project.back.dto.request.board.inquiryboard;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostInquiryBoardRequestDto {
    @NotBlank
    private String inquiryTitle;
    @NotBlank
    private String inquiryContents;
    @NotNull
    private Boolean inquiryPublic;
}
