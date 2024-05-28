package com.project.back.service;

import org.springframework.http.ResponseEntity;

import com.project.back.dto.request.auth.CheckEmailIdRequestDto;
import com.project.back.dto.request.auth.CheckNicknameRequestDto;
import com.project.back.dto.request.auth.CheckTelNumberAuthRequestDto;
import com.project.back.dto.request.auth.BusinessRegistrationNumberRequestDto;
import com.project.back.dto.request.auth.SignInRequestDto;
import com.project.back.dto.request.auth.SignUpRequestDto;
import com.project.back.dto.request.auth.TelNumberAuthRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.auth.SignInResponseDto;

public interface AuthService {
  ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
  ResponseEntity<ResponseDto> emailIdCheck(CheckEmailIdRequestDto dto);
  ResponseEntity<ResponseDto> nicknameCheck(CheckNicknameRequestDto dto);
  ResponseEntity<ResponseDto> telNumberAuth(TelNumberAuthRequestDto dto);
  ResponseEntity<ResponseDto> telNumberAuthCheck(CheckTelNumberAuthRequestDto dto);
  ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);
  ResponseEntity<ResponseDto> postCeoBusiness(BusinessRegistrationNumberRequestDto dto);
}
