package com.project.back.dto.request.User;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 회원탈퇴 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class MembershipCancellationRequestDto 
{
    @NotBlank
    private String userPassword; //사용자 비밀번호
}
