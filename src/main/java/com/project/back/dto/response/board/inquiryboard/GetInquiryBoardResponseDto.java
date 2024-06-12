package com.project.back.dto.response.board.inquiryboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.util.ChangeDateFormatUtil;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.InquiryBoardEntity;

import lombok.Getter;

@Getter
public class GetInquiryBoardResponseDto extends ResponseDto{
    private Integer inquiryNumber;
    private String inquiryTitle;
    private String inquiryWriterId;
    private String inquiryWriterNickname;
    private String inquiryWriteDatetime;
    private String inquiryContents;
    private String inquiryComment;
    private Boolean status;

    private GetInquiryBoardResponseDto(InquiryBoardEntity inquiryBoardEntity, String inquiryWriterNickname) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.status = inquiryBoardEntity.getStatus();
        this.inquiryNumber = inquiryBoardEntity.getInquiryNumber();
        this.inquiryTitle = inquiryBoardEntity.getInquiryTitle();
        this.inquiryWriterNickname = inquiryWriterNickname;
        this.inquiryWriterId = inquiryBoardEntity.getInquiryWriterId();

        String writeDate = ChangeDateFormatUtil.changeYYYYMMDD(inquiryBoardEntity.getInquiryWriteDatetime());
        this.inquiryWriteDatetime = writeDate;

        this.inquiryContents = inquiryBoardEntity.getInquiryContents();
        this.inquiryComment = inquiryBoardEntity.getInquiryComment();
    }

    public static ResponseEntity<GetInquiryBoardResponseDto> success(InquiryBoardEntity inquiryBoardEntity, String nickname)
    throws Exception {
        GetInquiryBoardResponseDto responseBody = new GetInquiryBoardResponseDto(inquiryBoardEntity, nickname);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
