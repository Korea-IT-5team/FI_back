package com.project.back.dto.request.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CheckBusinessRegistrationRequestDto {
  private String businessRegistrationNumber;
}
