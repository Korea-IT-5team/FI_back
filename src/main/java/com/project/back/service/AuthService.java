package com.project.back.service;

import org.springframework.http.ResponseEntity;

import com.project.back.dto.request.auth.CheckBusinessRegistrationRequestDto;
import com.project.back.dto.request.auth.CheckEmailIdRequestDto;
import com.project.back.dto.request.auth.CheckNicknameRequestDto;
import com.project.back.dto.request.auth.CheckTelNumberAuthRequestDto;
import com.project.back.dto.request.auth.FindEmailRequestDto;
import com.project.back.dto.request.auth.NewPasswordRequestDto;
import com.project.back.dto.request.auth.PasswordResetRequestDto;
import com.project.back.dto.request.auth.SignInRequestDto;
import com.project.back.dto.request.auth.SignUpRequestDto;
import com.project.back.dto.request.auth.TelNumberAuthRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.auth.FindEmailResponseDto;
import com.project.back.dto.response.auth.SignInResponseDto;

public interface AuthService {
  ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
  ResponseEntity<ResponseDto> emailIdCheck(CheckEmailIdRequestDto dto);
  ResponseEntity<ResponseDto> nicknameCheck(CheckNicknameRequestDto dto);
  ResponseEntity<ResponseDto> telNumberAuth(TelNumberAuthRequestDto dto);
  ResponseEntity<ResponseDto> telNumberAuthCheck(CheckTelNumberAuthRequestDto dto);
  ResponseEntity<ResponseDto> businessRegistrationCheck(CheckBusinessRegistrationRequestDto dto);
  ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);

  ResponseEntity<? super FindEmailResponseDto> findEmail(FindEmailRequestDto dto);
  ResponseEntity<ResponseDto> passwordReset(PasswordResetRequestDto dto);
  ResponseEntity<ResponseDto> newPassword(NewPasswordRequestDto dto, String userEmailId);
}
