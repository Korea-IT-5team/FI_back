package com.project.back.repository;

import com.project.back.entity.UserEntity;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsByNickname(String nickname);
    boolean existsByPassword(String password);
    boolean existsByUserEmailId(String userId);
    boolean existsByBusinessRegistrationNumber(String businessRegistrationNumber);
    boolean existsByUserNameAndUserTelNumber(String userName,String userTelNumber);
    boolean existsByUserEmailIdAndUserTelNumber(String userEmailId, String userTelNumber);

    UserEntity findBySnsId(String snsId);
    UserEntity findByPassword(String Password);
    UserEntity findByUserEmailId(String userEmailId);
    UserEntity findByUserNameAndUserTelNumber(String userName, String userTelNumber);
    UserEntity findByUserEmailIdAndUserTelNumber(String userEmailId, String userTelNumber);
}
