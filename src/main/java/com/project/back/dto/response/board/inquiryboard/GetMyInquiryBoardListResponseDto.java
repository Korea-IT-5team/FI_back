package com.project.back.dto.response.board.inquiryboard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.object.board.inquiryboard.InquiryBoardListItem;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.InquiryBoardEntity;

// 나의 문의 게시물 목록 확인 Reponse Body DTO

public class GetMyInquiryBoardListResponseDto extends ResponseDto
{
    private List<InquiryBoardListItem> inquiryBoardList;
    
    private GetMyInquiryBoardListResponseDto(List<InquiryBoardEntity> inquiryBoardEntities) throws Exception
    {
        super(ResponseCode.SUCCESS,ResponseMessage.SUCCESS);
        this.inquiryBoardList= InquiryBoardListItem.getList(inquiryBoardEntities);
    }

    public static ResponseEntity<GetMyInquiryBoardListResponseDto> success(List<InquiryBoardEntity> inquiryBoardEntities)
    throws Exception
    {
        GetMyInquiryBoardListResponseDto responseBody = new GetMyInquiryBoardListResponseDto(inquiryBoardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
