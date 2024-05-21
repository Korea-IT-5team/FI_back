package com.project.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 이메일 찾기 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class FindEmailRequestDto {
    @NotBlank
    private String userName;
    @NotBlank
    private String userTelNumber;
}
