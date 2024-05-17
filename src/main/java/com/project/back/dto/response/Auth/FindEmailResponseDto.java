package com.project.back.dto.response.Auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.UserEntity;

import lombok.Getter;

// 이메일 찾기 Response Body Dto

@Getter 
public class FindEmailResponseDto extends ResponseDto
{
    private String userEmailId;

    private FindEmailResponseDto(UserEntity userEntity)
    {
        super(ResponseCode.SUCCESS,ResponseMessage.SUCCESS);
        this.userEmailId=userEntity.getUserEmailId();
    }

    public static ResponseEntity<FindEmailResponseDto> success(UserEntity userEntity)
    {
        FindEmailResponseDto responseBody = new FindEmailResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
