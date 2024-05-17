package com.project.back.dto.response.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.dto.response.Auth.FindEmailResponseDto;
import com.project.back.entity.UserEntity;

// 로그인 유저 정보 반환 Response Body Dto

public class LoginUserInformationResponseDto extends ResponseDto
{
    private String userEmailId;
    private String userRole;
    private String nickname;
    private String userAddress;
    
    private LoginUserInformationResponseDto(UserEntity userEntity)
    {
        super(ResponseCode.SUCCESS,ResponseMessage.SUCCESS);
        this.userEmailId=userEntity.getUserEmailId();
        this.userRole=userEntity.getUserRole();
        this.nickname=userEntity.getNickname();
        this.userAddress=userEntity.getUserAddress();
    }

    public static ResponseEntity<LoginUserInformationResponseDto> success(UserEntity userEntity)
    {
        LoginUserInformationResponseDto responseBody = new LoginUserInformationResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
