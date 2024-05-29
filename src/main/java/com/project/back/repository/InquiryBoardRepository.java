package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.back.entity.InquiryBoardEntity;
import com.project.back.repository.resultSet.GetInquriryBoardListResultSet;

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

    @Query(value=
    "SELECT ib.inquiry_number inquiryNumber, ib.inquiry_status inquiryStatus, ib.inquiry_title inquiryTitle, u.nickname inquiryWriterNickname, ib.inquiry_write_datetime inquiryWriteDatetime " +
    "FROM inquiry_board ib LEFT JOIN user u ON ib.inquiry_writer_id = u.user_email_id " +
    "ORDER BY ib.inquiry_number DESC",
    nativeQuery=true
    )
    List<GetInquriryBoardListResultSet> getInquiryBoardList();

    @Query(value=
    "SELECT ib.inquiry_number inquiryNumber, ib.inquiry_status inquiryStatus, ib.inquiry_title inquiryTitle, u.nickname inquiryWriterNickname, ib.inquiry_write_datetime inquiryWriteDatetime " +
    "FROM inquiry_board ib LEFT JOIN user u ON ib.inquiry_writer_id = u.user_email_id " +
    "WHERE ib.inquiry_title LIKE '%:title%' " +
    "ORDER BY ib.inquiry_number DESC",
    nativeQuery=true
    )
    List<GetInquriryBoardListResultSet> getInquirySearchBoardList(@Param("title") String title);
    @Query(value=
    "SELECT ib.inquiry_number inquiryNumber, ib.inquiry_status inquiryStatus, ib.inquiry_title inquiryTitle, u.nickname inquiryWriterNickname, ib.inquiry_write_datetime inquiryWriteDatetime " +
    "FROM inquiry_board ib LEFT JOIN user u ON ib.inquiry_writer_id = u.user_email_id " +
    "WHERE ib.inquiry_writer_id = ':userEmailId' " +
    "ORDER BY ib.inquiry_number DESC",
    nativeQuery=true
    )
    List<GetInquriryBoardListResultSet> getInquiryUserBoardList(@Param("userEmailId") String userEmailId);
} 
