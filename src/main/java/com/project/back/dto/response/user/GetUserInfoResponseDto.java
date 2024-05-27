package com.project.back.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.UserEntity;

import lombok.Getter;

@Getter
public class GetUserInfoResponseDto extends ResponseDto {
    private String userEmailId;
    private String userRole;
    
    private GetUserInfoResponseDto(UserEntity userEntity) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userEmailId = userEntity.getUserEmailId();
        this.userRole = userEntity.getUserRole();
    }

    public static ResponseEntity<GetUserInfoResponseDto> success(UserEntity userEntity) {
        GetUserInfoResponseDto responseBody = new GetUserInfoResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
