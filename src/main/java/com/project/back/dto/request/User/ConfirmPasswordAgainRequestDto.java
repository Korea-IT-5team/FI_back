package com.project.back.dto.request.User;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 비밀번호 재확인 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class ConfirmPasswordAgainRequestDto 
{
    @NotBlank
    private String userPassword; //사용자의 비밀번호
}
