package com.project.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.back.dto.request.auth.CheckEmailIdRequestDto;
import com.project.back.dto.request.auth.CheckNicknameRequestDto;
import com.project.back.dto.request.auth.CheckTelNumberAuthRequestDto;
import com.project.back.dto.request.auth.SignInRequestDto;
import com.project.back.dto.request.auth.SignUpRequestDto;
import com.project.back.dto.request.auth.TelNumberAuthRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.auth.SignInResponseDto;
import com.project.back.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
  private final AuthService authService;

  @PostMapping("/sign-in")
  public ResponseEntity<? super SignInResponseDto> signIn (
    @RequestBody @Valid SignInRequestDto requestBody
  ) {
    ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
    return response;
  }

  @PostMapping("/email-check")
  public ResponseEntity<ResponseDto> emailIdCheck (
    @RequestBody @Valid CheckEmailIdRequestDto requestBody
  ) {
    ResponseEntity<ResponseDto> response = authService.emailIdCheck(requestBody);
    return response;
  }

  @PostMapping("/nickname-check")
  public ResponseEntity<ResponseDto> nicknameCheck (
    @RequestBody @Valid CheckNicknameRequestDto requestBody
  ) {
    ResponseEntity<ResponseDto> response = authService.nicknameCheck(requestBody);
    return response;
  }

  @PostMapping("/tel-number-auth")
  public ResponseEntity<ResponseDto> telNumberAuth (
    @RequestBody @Valid TelNumberAuthRequestDto requestBody
  ) {
    ResponseEntity<ResponseDto> response = authService.telNumberAuth(requestBody);
    return response;
  }

  @PostMapping("/tel-number-check")
  public ResponseEntity<ResponseDto> telNumberAuthCheck (
    @RequestBody @Valid CheckTelNumberAuthRequestDto requestBody
  ) {
    ResponseEntity<ResponseDto> response = authService.telNumberAuthCheck(requestBody);
    return response;
  }

  @PostMapping("/sign-up")
  public ResponseEntity<ResponseDto> signUp (
    @RequestBody @Valid SignUpRequestDto requestBody
  ) {
    ResponseEntity<ResponseDto> response = authService.signUp(requestBody);
    return response;
  }
}
