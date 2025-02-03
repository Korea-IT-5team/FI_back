package com.project.back.dto.request.board.noticeboard;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
// 수정작업
public class PatchNoticeBoardRequestDto  {
    @NotBlank
    private String noticeTitle;
    @NotBlank
    private String noticeContents;
}
