package com.project.back.dto.response.board.inquiryboard;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.object.board.inquiryboard.InquiryBoardListItem;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.repository.resultSet.GetInquriryBoardListResultSet;

import lombok.Getter;

@Getter
public class GetSearchInquiryBoardListResponseDto extends ResponseDto{
    private List<InquiryBoardListItem> inquiryBoardList;
    
    private GetSearchInquiryBoardListResponseDto(List<GetInquriryBoardListResultSet> resultSets) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.inquiryBoardList= InquiryBoardListItem.getList(resultSets);
    }

    public static ResponseEntity<GetSearchInquiryBoardListResponseDto> success(List<GetInquriryBoardListResultSet> resultSets)
    throws Exception {
        GetSearchInquiryBoardListResponseDto responseBody = new GetSearchInquiryBoardListResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
