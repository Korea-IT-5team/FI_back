package com.project.back.dto.request.board.noticeboard;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    // @NotNull
    // private Boolean isNoticePublic;
}
