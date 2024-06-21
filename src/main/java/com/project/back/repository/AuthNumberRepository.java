package com.project.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.AuthNumberEntity;

@Repository
public interface AuthNumberRepository extends JpaRepository<AuthNumberEntity, String> {
    boolean existsByTelNumberAndAuthNumber(String telNumber, String authNumber);
}
