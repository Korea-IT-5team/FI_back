package com.project.back.dto.response.board.noticeboard;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.object.board.noticeboard.NoticeBoardListItem;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.NoticeBoardEntity;

public class GetNoticeBoardListResponseDto extends ResponseDto {
    private List<NoticeBoardListItem> noticeBoardList;
    
    private GetNoticeBoardListResponseDto(List<NoticeBoardEntity> noticeBoardEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.noticeBoardList = NoticeBoardListItem.getList(noticeBoardEntities);
    }

    public static ResponseEntity<GetNoticeBoardListResponseDto> success(List<NoticeBoardEntity> noticeBoardEntities)
    throws Exception {
        GetNoticeBoardListResponseDto responseBody = new GetNoticeBoardListResponseDto(noticeBoardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
