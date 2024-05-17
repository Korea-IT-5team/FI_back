package com.project.back.dto.request.Auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;

// 로그인 Request Body Dto
@Getter
@Setter
@NoArgsConstructor
public class SignInRequestDto
{
    @NotBlank
    private String userEmailId; //사용자의 이메일
    @NotBlank
    private String password; //사용자의 비밀번호
}
