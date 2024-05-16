package com.project.back.dto.request.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 이메일 찾기 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class FindEmailRequestDto 
{
    @NotBlank
    private String userName; //사용자의 이름
    @NotBlank
    private String userTelNumber; //전화번호
}
