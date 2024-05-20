package com.project.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 새로운 비밀번호 설정 RequestBody Dto

@Getter
@Setter
@NoArgsConstructor
public class NewPasswordRequestDto 
{
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,13}$")
    private String password; //사용자의 비밀번호
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
    private String userEmailId; //사용자의 이메일 아이디
    @NotBlank
    private String linkCode; // 재설정 링크에 포함된 코드
}
