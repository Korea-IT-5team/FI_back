package com.project.back.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// project 데이터베이스의 notice_board 테이블과 매핑되는 Entity 클래스
@Entity(name="notice_board")
@Table(name="notice_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeBoardEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_number")
    private Integer noticeNumber;

    @Column(name = "notice_title", length = 100, nullable = false)
    private String title;

    @Column(name = "notice_contents", nullable = false)
    private String contents;

    @Column(name = "notice_writer_id", length = 50, nullable = false)
    private String writerId;

    @Column(name = "notice_write_datetime", nullable = false)
    private LocalDateTime writeDatetime;

    @Column(name = "notice_view_count", nullable = false)
    private Integer viewCount;
}
