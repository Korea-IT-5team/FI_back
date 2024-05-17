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

// project 데이터베이스의 inquiry_board 테이블과 매핑되는 Entity 클래스
@Entity(name="inquiry_board")
@Table(name="inquiry_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryBoardEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inquiry_number;
    private Boolean inquiry_status;
    private Boolean inquiry_public;
    private String inquiry_title;
    private String inquiry_contents;
    private String inquiry_writer_id;
    private LocalDateTime inquiry_write_datetime;
    private String inquiry_comment;
}

    