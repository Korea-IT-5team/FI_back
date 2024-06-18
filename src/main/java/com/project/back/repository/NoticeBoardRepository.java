package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.back.entity.NoticeBoardEntity;
import com.project.back.repository.resultSet.GetNoticeBoardListResultSet;

@Repository
public interface NoticeBoardRepository extends JpaRepository<NoticeBoardEntity,Integer> {
    
    NoticeBoardEntity findByNoticeNumber(Integer noticeNumber);

    @Query(value=
    "SELECT nb.notice_number noticeNumber, nb.notice_title noticeTitle, u.nickname noticeWriterNickname, nb.notice_write_datetime noticeWriteDatetime " +
    "FROM notice_board nb LEFT JOIN user u ON nb.notice_writer_id = u.user_email_id " +
    "ORDER BY nb.notice_number DESC",
    nativeQuery=true
    )
    List<GetNoticeBoardListResultSet> getNoticeBoardList();

    @Query(value=
    "SELECT nb.notice_number noticeNumber, nb.notice_title noticeTitle, u.nickname noticeWriterNickname, nb.notice_write_datetime noticeWriteDatetime " +
    "FROM notice_board nb LEFT JOIN user u ON nb.notice_writer_id = u.user_email_id " +
    "ORDER BY nb.notice_number DESC", 
    nativeQuery=true
    )
    List<GetNoticeBoardListResultSet> getNoticeSearchBoardList(@Param("title") String title);
}
