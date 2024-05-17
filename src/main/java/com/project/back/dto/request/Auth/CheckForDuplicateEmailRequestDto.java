package com.project.back.dto.request.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 이메일 중복 확인 Request Body Dto
@Getter
@Setter
@NoArgsConstructor
public class CheckForDuplicateEmailRequestDto 
{
    @NotBlank
    private String userEmailId; //사용자의 이메일
}
