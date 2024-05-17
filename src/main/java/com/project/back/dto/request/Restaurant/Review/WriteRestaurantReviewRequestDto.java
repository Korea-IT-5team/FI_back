package com.project.back.dto.request.Restaurant.Review;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 식당 리뷰 작성 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class WriteRestaurantReviewRequestDto 
{
    private String reviewImage; //리뷰 사진
    @NotBlank
    private double rating; //평점
    private String reviewContents; //리뷰 내용
}
