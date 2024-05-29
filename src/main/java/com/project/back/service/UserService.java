package com.project.back.service;

import org.springframework.http.ResponseEntity;

import com.project.back.dto.request.auth.FindEmailRequestDto;
import com.project.back.dto.request.auth.NewPasswordRequestDto;
import com.project.back.dto.request.auth.PasswordResetRequestDto;
import com.project.back.dto.request.user.DeleteUserRequestDto;
import com.project.back.dto.request.user.PasswordRecheckRequestDto;
import com.project.back.dto.request.user.PatchUserInfoRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.auth.FindEmailResponseDto;
import com.project.back.dto.response.user.GetUserInfoResponseDto;

public interface UserService {
  ResponseEntity<? super GetUserInfoResponseDto> GetSignInUser(String userEmailId);
  ResponseEntity<ResponseDto> passwordReCheck(PasswordRecheckRequestDto dto);

  ResponseEntity<? super FindEmailResponseDto> findEmail(FindEmailRequestDto dto);
  ResponseEntity<ResponseDto> passwordReset(PasswordResetRequestDto dto);
  ResponseEntity<ResponseDto> newPassword(NewPasswordRequestDto dto, String userEmailId);

  ResponseEntity<ResponseDto> patchUserInfo(PatchUserInfoRequestDto dto, String userEmailId);
  
  ResponseEntity<ResponseDto> deleteUser(DeleteUserRequestDto dto, String userEmailId);
}
