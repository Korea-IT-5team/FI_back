package com.project.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 전화번호 인증번호 전송 Request Body Dto
@Getter
@Setter
@NoArgsConstructor
public class TelNumberAuthRequestDto {
    @NotBlank
    private String userTelNumber;
}
