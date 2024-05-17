package com.project.back.dto.request.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 닉네임 중복 확인 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class CheckForDuplicateNicknameRequestDto 
{
    @NotBlank
    private String nickname; //사용자의 닉네임
}
