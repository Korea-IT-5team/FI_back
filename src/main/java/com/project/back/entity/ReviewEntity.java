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

// project 데이터베이스의 review 테이블과 매핑되는 Entity 클래스
@Entity(name="review")
@Table(name="review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewNumber;
    private Integer reviewRestaurantId;
    private Double rating;
    private String reviewContents;
    private String reviewWriterId;
    private String reviewDate;
    private String reviewImage;
}
