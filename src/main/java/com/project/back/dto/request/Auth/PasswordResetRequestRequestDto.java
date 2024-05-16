package com.project.back.dto.request.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 비밀번호 재설정 요청 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class PasswordResetRequestRequestDto 
{
    @NotBlank
    private String userEmailId; //사용자의 이메일
    @NotBlank
    private String userTelNumber; //사용자의 전화번호
}
