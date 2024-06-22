package com.project.back.dto.response.board.noticeboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.util.ChangeDateFormatUtil;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.NoticeBoardEntity;

import lombok.Getter;

@Getter
public class GetNoticeBoardResponseDto extends ResponseDto {
    private Integer noticeNumber;
    private String noticeTitle;
    private String noticeWriterId;
    private String noticeWriterNickname;
    private String noticeWriteDatetime;
    private String noticeContents;
    private Integer viewCount;
    
    private GetNoticeBoardResponseDto(NoticeBoardEntity noticeBoardEntity, String noticeWriterNickname) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.noticeNumber = noticeBoardEntity.getNoticeNumber();
        this.noticeTitle = noticeBoardEntity.getNoticeTitle();
        this.noticeWriterId = noticeBoardEntity.getNoticeWriterId();
        this.noticeWriterNickname = noticeWriterNickname;
        this.viewCount = noticeBoardEntity.getViewCount();

        String writeDate  = ChangeDateFormatUtil.changeYYYYMMDD(noticeBoardEntity.getNoticeWriteDatetime());
        this.noticeWriteDatetime = writeDate;

        this.noticeContents = noticeBoardEntity.getNoticeContents();
    }

    public static ResponseEntity<GetNoticeBoardResponseDto> success(NoticeBoardEntity noticeBoardEntity, String nickname) throws Exception {
        GetNoticeBoardResponseDto responseBody = new GetNoticeBoardResponseDto(noticeBoardEntity, nickname);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
