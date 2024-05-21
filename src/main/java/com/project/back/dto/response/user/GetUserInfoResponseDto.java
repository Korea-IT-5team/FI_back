package com.project.back.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.UserEntity;

// 로그인 유저 정보 반환 Response Body Dto
public class GetUserInfoResponseDto extends ResponseDto {
    private String userEmailId;
    private String nickname;
    private String userName;
    private String userTelNumber;
    private String userAddress;
    private String userRole;
    
    private GetUserInfoResponseDto(UserEntity userEntity) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        String writerId = userEntity.getUserEmailId();
        writerId = writerId.substring(0, 4) +
        "*".repeat(writerId.length() - 4); 
        this.userEmailId = writerId;
        this.nickname = userEntity.getNickname();
        this.userName = userEntity.getUserName();
        this.userTelNumber = userEntity.getUserTelNumber();
        this.userAddress = userEntity.getUserAddress();
        this.userRole = userEntity.getUserRole();
    }

    public static ResponseEntity<GetUserInfoResponseDto> success(UserEntity userEntity) {
        GetUserInfoResponseDto responseBody = new GetUserInfoResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
