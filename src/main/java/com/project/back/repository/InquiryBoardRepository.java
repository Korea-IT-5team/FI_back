package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.back.entity.InquiryBoardEntity;

@Repository
public interface InquiryBoardRepository extends JpaRepository<InquiryBoardEntity,Integer> {
    InquiryBoardEntity findByInquiryNumber(Integer inquiryNumber);
    List<InquiryBoardEntity> findByOrderByInquiryNumberDesc();
    List<InquiryBoardEntity> findByInquiryTitleContainsOrderByInquiryNumberDesc(String inquiryTitle);

    @Query(value=
    "SELECT * " +
    "FROM inquiry_board " +
    "WHERE inquiry_writer_id = :userEmailId",
    nativeQuery=true
    )
    List<InquiryBoardEntity> getMyInquiryBoardList(@Param("userEmailId") String inquiryWriterId);
}
