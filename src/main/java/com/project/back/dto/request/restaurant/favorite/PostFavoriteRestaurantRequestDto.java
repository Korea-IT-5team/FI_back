package com.project.back.dto.request.restaurant.favorite;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostFavoriteRestaurantRequestDto {
    @NotBlank
    private String favoriteUserEmailId;
    @NotBlank
    private Integer favoriteRestaurantId;
}
