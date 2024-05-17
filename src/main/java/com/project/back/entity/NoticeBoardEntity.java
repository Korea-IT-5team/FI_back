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
    private Integer noticeNumber;
    private String noticeTitle;
    private String noticeContents;
    private String noticeWriterId;
    private LocalDateTime noticeWriteDatetime;
    private Integer noticeViewCount;
}
