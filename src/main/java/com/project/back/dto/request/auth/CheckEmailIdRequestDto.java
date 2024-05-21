package com.project.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 이메일 중복 확인 Request Body Dto
@Getter
@Setter
@NoArgsConstructor
public class CheckEmailIdRequestDto {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
    private String userEmailId;
}
