package com.project.back.entity;

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
    @Column(name = "user_email_id")
    private String emailId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_tel_number", nullable = false, unique = true)
    private String telNumber;

    @Column(name = "user_address", nullable = false)
    private String address;

    @Column(name = "user_role", nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'ROLE_USER'")
    private String role;

    @Column(name = "join_path", nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'HOME'")
    private String joinPath;
}
