package com.project.back.dto.request.restaurant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchRestaurantInfoRequestDto {
    @NotBlank
    private String restaurantName;
    @NotBlank
    private String restaurantFoodCategory;
    @NotBlank
    private String restaurantLocation;
    @NotBlank
    private String restaurantImage;
    @NotNull
    private String restaurantLat;
    @NotNull
    private String restaurantLng;
    private String restaurantTelNumber;
    private String restaurantSnsAddress;
    private String restaurantOperationHours;
    private String restaurantFeatures;
    private String restaurantNotice;
    private String restaurantRepresentativeMenu;
}