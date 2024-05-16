package com.project.back.dto.request.Board.NoticeBoard;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//공지 게시물 작성 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class WriteNoticePostRequestDto 
{
    @NotBlank
    private String noticeTitle; //공지 제목
    @NotBlank
    private String noticeContents; //공지 내용
}
