package com.project.back.dto.request.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class CheckBusinessRegistrationRequestDto {
    private String businessRegistrationNumber;
}
