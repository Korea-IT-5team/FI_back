package com.project.back.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;

// 비밀번호 재설정 요청 Response Body Dto

public class PasswordResetResponseDto extends ResponseDto
{
    private String passwordResetLink;

    private PasswordResetResponseDto(String passwordResetLink)
    {
        super(ResponseCode.SUCCESS,ResponseMessage.SUCCESS);
        this.passwordResetLink=passwordResetLink;
    }

    public static ResponseEntity<PasswordResetResponseDto> success(String passwordResetLink)
    {
        PasswordResetResponseDto responseBody = new PasswordResetResponseDto(passwordResetLink);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
