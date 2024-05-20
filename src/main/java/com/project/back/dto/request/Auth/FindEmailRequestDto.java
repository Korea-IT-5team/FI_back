package com.project.back.dto.request.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindEmailRequestDto {
    @NotBlank
    private String userName;
    @NotBlank
    private String userTelNumber;
}