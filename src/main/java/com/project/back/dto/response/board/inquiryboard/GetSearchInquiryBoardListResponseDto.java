package com.project.back.dto.response.board.inquiryboard;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.object.board.inquiryboard.InquiryBoardListItem;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.InquiryBoardEntity;

import lombok.Getter;

@Getter
public class GetSearchInquiryBoardListResponseDto extends ResponseDto{
    private List<InquiryBoardListItem> inquiryBoardList;
    
    private GetSearchInquiryBoardListResponseDto(List<InquiryBoardEntity> inquiryBoardEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.inquiryBoardList= InquiryBoardListItem.getList(inquiryBoardEntities);
    }

    public static ResponseEntity<GetSearchInquiryBoardListResponseDto> success(List<InquiryBoardEntity> inquiryBoardEntities)
    throws Exception {
        GetSearchInquiryBoardListResponseDto responseBody = new GetSearchInquiryBoardListResponseDto(inquiryBoardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
