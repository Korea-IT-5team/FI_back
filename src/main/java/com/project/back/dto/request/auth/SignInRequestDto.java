package com.project.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignInRequestDto {
    @NotBlank
    @Pattern(regexp="^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
    private String userEmailId;
    @NotBlank
    @Pattern(regexp="^(?=.*[a-zA-Z])(?=.*[0-9]).{8,13}$")
    private String password;
}
