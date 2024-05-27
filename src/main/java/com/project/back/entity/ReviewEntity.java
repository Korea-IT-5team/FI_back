package com.project.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.project.back.dto.request.restaurant.PostRestaurantInfoRequestDto;
import com.project.back.dto.request.restaurant.review.PatchReviewRequestDto;
import com.project.back.dto.request.restaurant.review.PostReviewRequestDto;

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
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewNumber;
    private Integer reviewRestaurantId;
    private Double rating;
    private String reviewContents;
    private String reviewWriterId;
    private String reviewWriterNickname;
    private String reviewDate;
    private String reviewImage;

    public ReviewEntity(PostReviewRequestDto dto, String userEmailId) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String reviewDate = simpleDateFormat.format(now);

        this.rating = dto.getRating();
        this.reviewContents = dto.getReviewContents();
        this.reviewWriterId = userEmailId;
        this.reviewDate = reviewDate;
        this.reviewImage = dto.getReviewImage();
        
    }

    public void updateReview(PatchReviewRequestDto dto){
        
        this.rating = dto.getRating();
        this.reviewContents = dto.getReviewContents();
        this.reviewImage = dto.getReviewImage();
    }
}


