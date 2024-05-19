package com.project.back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// project 데이터베이스의 restaurant 테이블과 매핑되는 Entity 클래스
@Entity(name="restaurant")
@Table(name="restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurantId; 
    private String restaurantName;
    private String restaurantFoodCategory;
    private String postalCode;
    private String restaurantLocation;
    private String restaurantTelNumber;
    private String restaurantSnsAddress;
    private String restaurantOperationHours;
    private String restaurantFeatures;
    private String restaurantNotice;
    private String restaurantRepresentativeMenu;
    private String restaurantBusinessRegistrationNumber;
    private String restaurantImage;
}
