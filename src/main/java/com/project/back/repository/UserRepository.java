package com.project.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
  boolean existsByUserEmailId(String userId);
  boolean existsByNickname(String nickname);
  boolean existsByUserNameAndUserTelNumber(String userName,String userTelNumber);
  boolean existsByPassword(String password);
  boolean existsByBusinessRegistrationNumber(String businessRegistrationNumber);
  boolean existsByUserEmailIdAndUserTelNumber(String userEmailId, String userTelNumber);

  UserEntity findByUserNameAndUserTelNumber(String userName, String userTelNumber);
  UserEntity findByUserEmailIdAndUserTelNumber(String userEmailId, String userTelNumber);
  UserEntity findBySnsId(String snsId);
  UserEntity findByPassword(String Password);
  UserEntity findByUserEmailId(String userEmailId);   //UserName  //UserTelNumber //Nickname
}
