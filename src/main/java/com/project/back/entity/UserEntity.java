package com.project.back.entity;

import com.project.back.dto.request.auth.SignUpRequestDto;
import com.project.back.dto.request.user.PatchUserInfoRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="user")
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    private String userEmailId;
    private String password;
    private String nickname;
    private String userName;
    private String userTelNumber;
    private String userAddress;
    private String userRole;
    private String joinPath;
    private String snsId;
    private String businessRegistrationNumber;

    public UserEntity(SignUpRequestDto dto) {
        this.userEmailId = dto.getUserEmailId();
        this.password = dto.getPassword();
        this.nickname = dto.getNickname();
        this.userName = dto.getUserName();
        this.userTelNumber = dto.getUserTelNumber();
        this.userAddress = dto.getUserAddress();
        this.userRole = "ROLE_USER";
        this.joinPath = "HOME";
        this.snsId = dto.getSnsId();
        this.businessRegistrationNumber = dto.getBusinessRegistrationNumber();
    }

    public void update(PatchUserInfoRequestDto dto) {
        this.nickname = dto.getNickname();
        this.userAddress = dto.getUserAddress();
    }
<<<<<<< HEAD
=======
    
>>>>>>> d00a29d377a4fde81046c42bac3f57c64fc6de17
}