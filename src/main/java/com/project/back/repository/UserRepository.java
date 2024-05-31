package com.project.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
  boolean existsByUserEmailId(String userId);
  boolean existsByNickname(String nickname);
  boolean existsByUserNameAndUserTelNumber(String userName,String userTelNumber);
  boolean existsByPassword(String password);
  boolean existsByBusinessRegistrationNumber(String businessRegistrationNumber);

  UserEntity findByUserNameAndUserTelNumber(String userName, String userTelNumber);
  UserEntity findByUserEmailId(String userEmailId);
  UserEntity findBySnsId(String snsId);

  //
  String getUserNameByUserEmailId(String userEmailId);
  String getUserTelNumberByUserEmailId(String userEmailId);
  String getNicknameByUserEmailId(String userEmailId); //##수정
  //
}
