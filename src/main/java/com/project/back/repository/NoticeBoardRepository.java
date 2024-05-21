package com.project.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.NoticeBoardEntity;

@Repository
public interface NoticeBoardRepository extends JpaRepository<NoticeBoardEntity,Integer> {
    
}
