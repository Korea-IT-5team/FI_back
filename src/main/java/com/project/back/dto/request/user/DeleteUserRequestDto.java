package com.project.back.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 회원탈퇴 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class DeleteUserRequestDto 
{
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,13}$")
    private String password; //사용자 비밀번호
}
