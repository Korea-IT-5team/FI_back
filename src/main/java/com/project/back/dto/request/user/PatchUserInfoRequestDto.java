package com.project.back.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchUserInfoRequestDto {
    @NotBlank
    private String nickname;
    @NotBlank
    private String userAddress;
}
