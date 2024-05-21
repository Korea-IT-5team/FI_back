package com.project.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 비밀번호 재설정 요청 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class PasswordResetRequestDto {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
    private String userEmailId;
    @NotBlank
    private String userTelNumber;
}
