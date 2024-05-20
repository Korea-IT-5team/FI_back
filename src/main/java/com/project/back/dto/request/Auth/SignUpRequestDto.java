package com.project.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 회원가입 Request Body Dto
@Getter
@Setter
@NoArgsConstructor
public class SignUpRequestDto 
{
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
    private String userEmailId; //사용자의 이메일
    @NotBlank
    private String userPassword; // 사용자의 비밀번호
    @NotBlank
    private String authNumber; // 인증번호
    @NotBlank
    private String nickname; // 사용자의 닉네임
    @NotBlank
    private String userName; // 사용자의 이름
    @NotBlank
    private String userTelNumber; //전화번호
    @NotBlank
    private String userAddress; //주소
}
