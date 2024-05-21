package com.project.back.dto.request.restaurant.review;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 식당 리뷰 수정 Request Body Dto
@Getter
@Setter
@NoArgsConstructor
public class PatchReviewRequestDto {
    @NotBlank
    private double rating;
    private String reviewImage;
    private String reviewContents;
}
