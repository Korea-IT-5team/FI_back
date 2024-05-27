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
    private String noticeWriteId;
    private String noticeWriterNickname;
    private String noticeWriteDatetime;
    private String noticeContents;
    
    private GetNoticeBoardResponseDto(NoticeBoardEntity noticeBoardEntity) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.noticeNumber = noticeBoardEntity.getNoticeNumber();
        this.noticeTitle = noticeBoardEntity.getNoticeTitle();

        String writerId = noticeBoardEntity.getNoticeWriterId();
        writerId = writerId.substring(0, 1) +
        "*".repeat(writerId.length() - 1); 
        this.noticeWriteId = writerId;

        this.noticeWriterNickname = noticeBoardEntity.getNoticeWriterNickname();

        String writeDate  = ChangeDateFormatUtil.changeYYYYMMDD(noticeBoardEntity.getNoticeWriteDatetime());
        this.noticeWriteDatetime = writeDate;

        this.noticeContents = noticeBoardEntity.getNoticeContents();
    }

    public static ResponseEntity<GetNoticeBoardResponseDto> success(NoticeBoardEntity noticeBoardEntity)
    throws Exception {
        GetNoticeBoardResponseDto responseBody = new GetNoticeBoardResponseDto(noticeBoardEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
