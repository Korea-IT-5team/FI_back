package com.project.back.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.UserEntity;

import lombok.Getter;

@Getter 
public class FindEmailResponseDto extends ResponseDto{
    private String userEmailId;

    private FindEmailResponseDto(UserEntity userEntity) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        String writerId = userEntity.getUserEmailId();
        writerId = writerId.substring(0, 4) +
        "*".repeat(writerId.length() - 4); 
        this.userEmailId = writerId;
        
    }

    public static ResponseEntity<FindEmailResponseDto> success(UserEntity userEntity) {
        FindEmailResponseDto responseBody = new FindEmailResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
