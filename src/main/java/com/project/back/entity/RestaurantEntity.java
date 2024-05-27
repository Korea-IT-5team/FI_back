package com.project.back.entity;

import com.project.back.dto.request.restaurant.PatchRestaurantInfoRequestDto;
import com.project.back.dto.request.restaurant.PostRestaurantInfoRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="restaurant")
@Table(name="restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntity {
    @Id
    private Integer restaurantId; 
    private String restaurantName;
    private String restaurantFoodCategory;
    private String restaurantPostalCode;
    private String restaurantLocation;
    private String restaurantTelNumber;
    private String restaurantSnsAddress;
    private String restaurantOperationHours;
    private String restaurantFeatures;
    private String restaurantNotice;
    private String restaurantRepresentativeMenu;
    private String restaurantBusinessRegistrationNumber;
    private String restaurantImage;
    private String restaurantWriterId;

    public RestaurantEntity(PostRestaurantInfoRequestDto dto, String userEmailId) {
        this.restaurantName = dto.getRestaurantName();
        this.restaurantFoodCategory = dto.getRestaurantFoodCategory();
        this.restaurantPostalCode = dto.getRestaurantPostalCode();
        this.restaurantLocation = dto.getRestaurantLocation();
        this.restaurantTelNumber = dto.getRestaurantTelNumber();
        this.restaurantSnsAddress = dto.getRestaurantSnsAddress();
        this.restaurantOperationHours = dto.getRestaurantOperationHours();
        this.restaurantFeatures = dto.getRestaurantFeatures();
        this.restaurantNotice = dto.getRestaurantNotice();
        this.restaurantRepresentativeMenu = dto.getRestaurantRepresentativeMenu();
        this.restaurantBusinessRegistrationNumber = dto.getRestaurantBusinessRegistrationNumber();
        this.restaurantImage = dto.getRestaurantImage();
        this.restaurantWriterId = userEmailId;
    }

    public void updateRestaurantInfo(PatchRestaurantInfoRequestDto dto) {
        this.restaurantName = dto.getRestaurantName();
        this.restaurantFoodCategory = dto.getRestaurantFoodCategory();
        this.restaurantPostalCode = dto.getRestaurantPostalCode();
        this.restaurantLocation = dto.getRestaurantLocation();
        this.restaurantTelNumber = dto.getRestaurantTelNumber();
        this.restaurantSnsAddress = dto.getRestaurantSnsAddress();
        this.restaurantOperationHours = dto.getRestaurantOperationHours();
        this.restaurantFeatures = dto.getRestaurantFeatures();
        this.restaurantNotice = dto.getRestaurantNotice();
        this.restaurantRepresentativeMenu = dto.getRestaurantRepresentativeMenu();
        this.restaurantBusinessRegistrationNumber = dto.getRestaurantBusinessRegistrationNumber();
        this.restaurantImage = dto.getRestaurantImage();
    }


}
