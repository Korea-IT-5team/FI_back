package com.project.back.entity;

import jakarta.persistence.Column;
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
    @Column(name = "restaurant_id")
    private Integer id;

    @Column(name = "restaurant_name", nullable = false)
    private String name;

    @Column(name = "restaurant_food_category", nullable = false)
    private String foodCategory;

    @Column(name = "postal_code", length = 5)
    private String postalCode;

    @Column(name = "restaurant_location", nullable = false)
    private String location;

    @Column(name = "restaurant_tel_number")
    private String telNumber;

    @Column(name = "restaurant_sns_address", length = 255)
    private String snsAddress;

    @Column(name = "restaurant_operation_hours", length = 255)
    private String operationHours;

    @Column(name = "restaurant_features", length = 255)
    private String features;

    @Column(name = "restaurant_notice", length = 255)
    private String notice;

    @Column(name = "restaurant_representative_menu", length = 255)
    private String representativeMenu;

    @Column(name = "restaurant_business_registration_number", nullable = false, length = 15)
    private String businessRegistrationNumber;
}
