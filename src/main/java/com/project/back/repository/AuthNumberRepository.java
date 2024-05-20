package com.project.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.back.entity.AuthNumberEntity;

public interface AuthNumberRepository extends JpaRepository<AuthNumberEntity, String> {
  boolean existsByTelNumberAndAuthNumber(String telNumber, String authNumber);
}
