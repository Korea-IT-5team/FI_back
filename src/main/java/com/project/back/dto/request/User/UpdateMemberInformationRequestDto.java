package com.project.back.dto.request.User;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 회원정보 수정 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class UpdateMemberInformationRequestDto 
{
    @NotBlank
    private String nickName; //사용자의 닉네임
    @NotBlank
    private String password; //사용자 비밀번호
    @NotBlank
    private String userAddress; //사용자의 주소
}
