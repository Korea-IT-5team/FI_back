package com.project.back.dto.request.board.noticeboard;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 공지 게시물 수정 Request Body Dto
@Getter
@Setter
@NoArgsConstructor
public class PatchNoticeBoardRequestDto  {
    @NotBlank
    private String noticeTitle;
    @NotBlank
    private String noticeContents;
}
