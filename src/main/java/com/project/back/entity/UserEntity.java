package com.project.back.entity;

import com.project.back.dto.request.auth.SignUpRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// project 데이터베이스의 user 테이블과 매핑되는 Entity 클래스
@Entity(name="user")
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userEmailId;
    private String password;
    private String nickname;
    private String userName;
    private String userTelNumber;
    private String userAddress;
    private String authNumber;
    private String userRole;
    private String joinPath;

    public UserEntity(SignUpRequestDto dto) {
        this.userEmailId = dto.getUserEmailId();
        this.password = dto.getPassword();
        this.userTelNumber = dto.getUserTelNumber();
        this.userRole = "ROLE_USER";
        this.joinPath = "HOME";
    }
}
