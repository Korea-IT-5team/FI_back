package com.project.back.service;

import org.springframework.http.ResponseEntity;

import com.project.back.dto.request.user.DeleteUserRequestDto;
import com.project.back.dto.request.user.PasswordRecheckRequestDto;
import com.project.back.dto.request.user.PatchUserInfoRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.user.GetUserInfoResponseDto;

public interface UserService {
  ResponseEntity<? super GetUserInfoResponseDto> GetSignInUser(String userEmailId);

  ResponseEntity<ResponseDto> passwordReCheck(PasswordRecheckRequestDto dto);

  ResponseEntity<ResponseDto> patchUserInfo(PatchUserInfoRequestDto dto, String userEmailId);
  
  ResponseEntity<ResponseDto> deleteUser(DeleteUserRequestDto dto, String userEmailId);
}