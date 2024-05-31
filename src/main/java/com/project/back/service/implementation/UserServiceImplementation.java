package com.project.back.service.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.back.common.util.PasswordResetLinkCodeUtil;
import com.project.back.dto.request.auth.NewPasswordRequestDto;
import com.project.back.dto.request.auth.PasswordRecheckRequestDto;
import com.project.back.dto.request.auth.PasswordResetRequestDto;
import com.project.back.dto.request.user.DeleteUserRequestDto;
import com.project.back.dto.request.user.PatchUserInfoRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.user.GetMyInfoResponseDto;
import com.project.back.dto.response.user.GetUserInfoResponseDto;
import com.project.back.entity.UserEntity;
import com.project.back.provider.SmsProvider;
import com.project.back.repository.UserRepository;
import com.project.back.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
  private final UserRepository userRepository;
  private final SmsProvider smsProvider;
  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  
  @Override
  public ResponseEntity<? super GetUserInfoResponseDto> GetSignInUser(String userEmailId) {
    UserEntity userEntity = null;
   

    try {
      userEntity = userRepository.findByUserEmailId(userEmailId);
      if (userEntity == null) return ResponseDto.authenticationFailed();
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return GetUserInfoResponseDto.success(userEntity);
  }
  
  // @Override
  // public ResponseEntity<ResponseDto> passwordReCheck(PasswordRecheckRequestDto dto) {
  //   try {
  //     String password = dto.getPassword();

  //     boolean isMatched = userRepository.existsByPassword(password);
  //     if (!isMatched) return ResponseDto.authenticationFailed();
  //   } catch (Exception exception) {
  //     exception.printStackTrace();
  //     return ResponseDto.databaseError();
  //   }
  //   return ResponseDto.success();
  // }
  
  // @Override
  // public ResponseEntity<ResponseDto> passwordReset(PasswordResetRequestDto dto) {
  //   try {
  //     String userTelNumber = dto.getUserTelNumber();
      
  //     String resetLinkCode = PasswordResetLinkCodeUtil.createCode();

  //     smsProvider.sendPasswordResetLink(userTelNumber, resetLinkCode);
  //   } catch (Exception exception) {
  //     exception.printStackTrace();
  //     return ResponseDto.databaseError();
  //   }
  //   return ResponseDto.success();
  // }

  // @Override
  // public ResponseEntity<ResponseDto> newPassword(NewPasswordRequestDto dto, String userEmailId) {
  //   try {
  //     UserEntity userEntity = userRepository.findByUserEmailId(userEmailId);

  //     boolean isUser = userEmailId.equals(userEmailId);
  //     if (!isUser) return ResponseDto.noExistUser();

  //     String password = dto.getPassword();

  //     String encodedPassword = passwordEncoder.encode(password);
  //     dto.setPassword(encodedPassword);

  //     userEntity.setPassword(encodedPassword);
  //     userRepository.save(userEntity);
  //   } catch(Exception exception) {
  //     exception.printStackTrace();
  //     return ResponseDto.databaseError();
  //   }
  //   return ResponseDto.success();
  // }

  @Override
  public ResponseEntity<ResponseDto> patchUserInfo(PatchUserInfoRequestDto dto, String userEmailId) {
    try {
      UserEntity userEntity = userRepository.findByUserEmailId(userEmailId);
      if (userEntity == null) return ResponseDto.noExistUser();

      String updateId = userEntity.getUserEmailId();
      boolean isEquals = userEmailId.equals(updateId);
      if (!isEquals) return ResponseDto.authorizationFailed();

      userEntity.update(dto);
      userRepository.save(userEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

  @Override
  public ResponseEntity<ResponseDto> deleteUser(DeleteUserRequestDto dto, String userEmailId) {
    try {
      UserEntity userEntity = userRepository.findByUserEmailId(userEmailId);
      if (userEntity == null) return ResponseDto.noExistUser();

      String deleteId = userEntity.getUserEmailId();
      boolean isEquals = userEmailId.equals(deleteId);
      if (!isEquals) return ResponseDto.authorizationFailed();

      userRepository.delete(userEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

  @Override
  public ResponseEntity<? super GetMyInfoResponseDto> getMyInfo(String userEmailId) {
    UserEntity userEntity = null;

        try {

            userEntity = userRepository.findByUserEmailId(userEmailId);
            if(userEntity == null) return ResponseDto.authenticationFailed();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetMyInfoResponseDto.success(userEntity);
  }

  
}
