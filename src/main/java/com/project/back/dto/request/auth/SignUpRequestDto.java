package com.project.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequestDto {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
    private String userEmailId;
    @NotNull
    @Pattern(regexp="^(?=.*[a-zA-Z])(?=.*[0-9]).{8,13}$")
    private String password;
    @NotBlank
    private String nickname;
    @NotBlank
    private String userName;
    @NotBlank
    private String userTelNumber;
    @NotBlank
    private String authNumber;
    @NotBlank
    private String userAddress;
    @NotBlank
    private String joinPath;
    private String snsId;
    private String businessRegistrationNumber;
}