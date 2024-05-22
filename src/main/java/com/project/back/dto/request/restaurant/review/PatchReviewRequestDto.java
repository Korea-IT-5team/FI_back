package com.project.back.dto.request.restaurant.review;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchReviewRequestDto {
    @NotBlank
    private double rating;
    private String reviewImage;
    private String reviewContents;
}
