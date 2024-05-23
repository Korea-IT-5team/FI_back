package com.project.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.back.dto.request.user.DeleteUserRequestDto;
import com.project.back.dto.request.user.PasswordRecheckRequestDto;
import com.project.back.dto.request.user.PatchUserInfoRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.user.GetUserInfoResponseDto;
import com.project.back.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
  private final UserService userService;

  @GetMapping("/")
  public ResponseEntity<? super GetUserInfoResponseDto> GetSignInUser (
    @AuthenticationPrincipal String userEmailId
  ) {
    ResponseEntity<? super GetUserInfoResponseDto> response = userService.GetSignInUser(userEmailId);
    return response;
  }

  @PostMapping("/password-recheck")
  public ResponseEntity<ResponseDto> passwordReCheck (
    @RequestBody @Valid PasswordRecheckRequestDto requestBody
  ) {
    ResponseEntity<ResponseDto> response = userService.passwordReCheck(requestBody);
    return response;
  }

  @PatchMapping("/info-update")
  public ResponseEntity<ResponseDto> patchUserInfo (
    @RequestBody @Valid PatchUserInfoRequestDto requestBody,
    @PathVariable("userEmailId") String userEmailId
  ) {
    ResponseEntity<ResponseDto> response = userService.patchUserInfo(requestBody, userEmailId);
    return response;
  }

  @DeleteMapping("/info-delete")
  public ResponseEntity<ResponseDto> deleteUser (
    @RequestBody @Valid DeleteUserRequestDto requestBody,
    @PathVariable("userEmailId") String userEmailId
  ) {
    ResponseEntity<ResponseDto> response = userService.deleteUser(requestBody, userEmailId);
    return response;
  }
}