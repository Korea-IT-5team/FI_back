package com.project.back.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 비밀번호 재확인 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class PasswordRecheckRequestDto 
{
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,13}$")
    private String password; //사용자의 비밀번호
}
