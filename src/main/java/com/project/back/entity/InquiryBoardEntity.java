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

    @Column(nullable = false)
    private Boolean inquiry_status = false;

    @Column(nullable = false)
    private Boolean inquiry_public = true;

    @Column(nullable = false, length = 100)
    private String inquiry_title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String inquiry_contents;

    @Column(nullable = false, length = 50)
    private String inquiry_writer_id;

    @Column(nullable = false)
    private LocalDateTime inquiry_write_datetime;

    @Column(columnDefinition = "TEXT")
    private String inquiry_comment;
}
