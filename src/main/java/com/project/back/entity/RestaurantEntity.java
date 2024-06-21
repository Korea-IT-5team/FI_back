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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer restaurantId; 
    private String restaurantName;
    private String restaurantFoodCategory;
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
    private String restaurantLat;
    private String restaurantLng;

    public RestaurantEntity(PostRestaurantInfoRequestDto dto, String userEmailId, UserEntity userEntity) {
        this.restaurantName = dto.getRestaurantName();
        this.restaurantFoodCategory = dto.getRestaurantFoodCategory();
        this.restaurantLocation = dto.getRestaurantLocation();
        this.restaurantTelNumber = dto.getRestaurantTelNumber();
        this.restaurantSnsAddress = dto.getRestaurantSnsAddress();
        this.restaurantOperationHours = dto.getRestaurantOperationHours();
        this.restaurantFeatures = dto.getRestaurantFeatures();
        this.restaurantNotice = dto.getRestaurantNotice();
        this.restaurantRepresentativeMenu = dto.getRestaurantRepresentativeMenu();
        this.restaurantBusinessRegistrationNumber = userEntity.getBusinessRegistrationNumber();
        this.restaurantImage = dto.getRestaurantImage();
        this.restaurantWriterId = userEmailId;
        this.restaurantLat = dto.getRestaurantLat();
        this.restaurantLng = dto.getRestaurantLng();
    }

    public void updateRestaurantInfo(PatchRestaurantInfoRequestDto dto) {
        this.restaurantName = dto.getRestaurantName();
        this.restaurantFoodCategory = dto.getRestaurantFoodCategory();
        this.restaurantLocation = dto.getRestaurantLocation();
        this.restaurantTelNumber = dto.getRestaurantTelNumber();
        this.restaurantSnsAddress = dto.getRestaurantSnsAddress();
        this.restaurantOperationHours = dto.getRestaurantOperationHours();
        this.restaurantFeatures = dto.getRestaurantFeatures();
        this.restaurantNotice = dto.getRestaurantNotice();
        this.restaurantRepresentativeMenu = dto.getRestaurantRepresentativeMenu();
        this.restaurantImage = dto.getRestaurantImage();
        this.restaurantLat = dto.getRestaurantLat();
        this.restaurantLng = dto.getRestaurantLng();
    }
}