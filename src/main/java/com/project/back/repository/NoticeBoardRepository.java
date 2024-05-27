package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.NoticeBoardEntity;

@Repository
public interface NoticeBoardRepository extends JpaRepository<NoticeBoardEntity,Integer> {
    NoticeBoardEntity findByNoticeNumber(Integer noticeNumber);
    List<NoticeBoardEntity> findByOrderByNoticeNumberDesc();
    List<NoticeBoardEntity> findByNoticeTitleContainsOrderByNoticeNumberDesc(String noticeTitle);
}
