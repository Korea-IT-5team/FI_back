package com.project.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.InquiryBoardEntity;

@Repository
public interface InquiryBoardRepository  extends JpaRepository<InquiryBoardEntity,Integer> {
    
}
