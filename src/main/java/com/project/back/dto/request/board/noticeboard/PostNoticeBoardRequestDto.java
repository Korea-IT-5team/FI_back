package com.project.back.dto.request.board.noticeboard;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostNoticeBoardRequestDto {
    @NotBlank
    private String noticeTitle;
    @NotBlank
    private String noticeContents;
}