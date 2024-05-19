package com.project.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.InquiryBoardEntity;
import com.project.back.entity.NoticeBoardEntity;

// Estate 데이터베이스의 notice_board 테이블의 작업을 위한 리포지토리

@Repository
public interface NoticeBoardRepository extends JpaRepository<NoticeBoardEntity,Integer> 
{
    
}
