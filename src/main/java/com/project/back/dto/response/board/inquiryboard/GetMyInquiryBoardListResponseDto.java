package com.project.back.dto.response.board.inquiryboard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.object.board.inquiryboard.InquiryBoardListItem;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.InquiryBoardEntity;
import com.project.back.repository.resultSet.GetInquriryBoardListResultSet;

import lombok.Getter;

@Getter
public class GetMyInquiryBoardListResponseDto extends ResponseDto{
    private List<InquiryBoardListItem> inquiryBoardList;
    
    private GetMyInquiryBoardListResponseDto(List<GetInquriryBoardListResultSet> resultSets) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.inquiryBoardList = InquiryBoardListItem.getList(resultSets);
    }

    public static ResponseEntity<GetMyInquiryBoardListResponseDto> success(List<GetInquriryBoardListResultSet> resultSets)
    throws Exception {
        GetMyInquiryBoardListResponseDto responseBody = new GetMyInquiryBoardListResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
