package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.back.entity.InquiryBoardEntity;

@Repository
public interface InquiryBoardRepository  extends JpaRepository<InquiryBoardEntity,Integer> {
    InquiryBoardEntity findByInquiryNumber(Integer inquiryNumber);
    List<InquiryBoardEntity> findByOrderByInquiryNumberDesc();
    List<InquiryBoardEntity> findByTitleContainsOrderByInquiryNumberDesc(String searchWord);

    @Query(value=
    "SELECT * " +
    "FROM inquiry_board " +
    "WHERE `inquiry_writer_id` = :user_email_id",
    nativeQuery=true
    )
    List<InquiryBoardEntity> getMyInquiryBoardList(@Param("inquiry_writer_id") String inquiryWriterId);
}
