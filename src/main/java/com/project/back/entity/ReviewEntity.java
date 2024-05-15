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
    @Column(name = "review_number")
    private Integer reviewNumber;

    @Column(name = "review_restaurant_id", nullable = false)
    private RestaurantEntity restaurant;

    @Column(name = "rating", nullable = false)
    private Double rating;

    @Column(name = "review_contents", columnDefinition = "TEXT")
    private String contents;

    @Column(name = "review_writer_id", nullable = false)
    private UserEntity writer;

    @Column(name = "review_date", nullable = false)
    private LocalDateTime date;
}
