package com.project.back.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 회원정보 수정 Request Body Dto
@Getter
@Setter
@NoArgsConstructor
public class PatchUserInfoRequestDto {
    @NotBlank
    private String nickName;
    @NotBlank
    private String userAddress;
}
