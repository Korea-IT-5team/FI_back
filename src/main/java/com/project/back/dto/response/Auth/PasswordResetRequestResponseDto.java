package com.project.back.dto.response.Auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;

// 비밀번호 재설정 요청 Response Body Dto

public class PasswordResetRequestResponseDto extends ResponseDto
{
    private String passwordResetLink;

    private PasswordResetRequestResponseDto(String passwordResetLink)
    {
        super(ResponseCode.SUCCESS,ResponseMessage.SUCCESS);
        this.passwordResetLink=passwordResetLink;
    }

    public static ResponseEntity<PasswordResetRequestResponseDto> success(String passwordResetLink)
    {
        PasswordResetRequestResponseDto responseBody = new PasswordResetRequestResponseDto(passwordResetLink);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
