package com.project.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CheckTelNumberAuthRequestDto {
    @NotBlank
    private String userTelNumber;
    @NotBlank
    private String authNumber;
}
