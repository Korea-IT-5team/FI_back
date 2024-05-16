package com.project.back.dto.request.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 새로운 비밀번호 설정 RequestBody Dto

@Getter
@Setter
@NoArgsConstructor
public class PasswordResetRequestDto 
{
    @NotBlank
    private String userPassword; //사용자의 비밀번호
}
