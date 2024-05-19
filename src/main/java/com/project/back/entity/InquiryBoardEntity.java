package com.project.back.entity;

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
    private Integer inquiryNumber;
    private Boolean inquiryStatus;
    private Boolean inquiryPublic;
    private String inquiryTitle;
    private String inquiryContents;
    private String inquiryWriterId;
    private String inquiryWriteDatetime;
    private String inquiryComment;
}

    