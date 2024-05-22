package com.project.back.dto.request.board.inquiryboard;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchInquiryBoardRequestDto {
    @NotBlank
    private String inquiryTitle;
    @NotBlank
    private String inquiryContents;
}
