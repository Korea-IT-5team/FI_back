package com.project.back.dto.request.restaurant;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostRestaurantInfoRequestDto {
    @NotBlank
    private String restaurantImage;
    @NotBlank
    private String restaurantName;
    @NotBlank
    private String restaurantFoodCategory;
    @NotBlank
    private String restaurantPostalCode;
    @NotBlank
    private String restaurantLocation;
    @NotBlank
    private String restaurantBusinessRegistrationNumber;
    private String restaurantTelNumber;
    private String restaurantSnsAddress;
    private String restaurantOperationHours;
    private String restaurantFeatures;
    private String restaurantNotice;
    private String restaurantRepresentativeMenu;
    private String restaurantWriterId;
    private Double rating;
    private String ReviewContents;
    private String reviewImage;
    
}
//수정