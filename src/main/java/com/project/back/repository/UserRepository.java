package com.project.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.UserEntity;

// Estate 데이터베이스의 user 테이블의 작업을 위한 리포지토리

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> 
{
    
}