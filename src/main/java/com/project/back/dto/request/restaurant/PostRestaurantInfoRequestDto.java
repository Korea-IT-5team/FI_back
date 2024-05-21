package com.project.back.dto.request.restaurant;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 식당 정보 등록 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class PostRestaurantInfoRequestDto 
{
    @NotBlank
    private String restaurantImage; //식당 대표 사진
    @NotBlank
    private String restaurantName; // 식당 이름
    @NotBlank
    private String restaurantFoodCategory; // 식당 음식 카테고리
    @NotBlank
    private String postalCode; //식당 우편번호
    @NotBlank
    private String restaurantLocation; //식당 주소
    @NotBlank
    private String restaurantBusinessRegistrationNumber; //식당 사업자등록번호
    private String restaurantTelNumber; //식당 연락쳐
    private String restaurantSnsAddress; //식당 SNS주소
    private String restaurantOperationHours; //식당 운영 시간 
    private String restaurantFeatures; // 식당 특징
    private String restaurantNotice; // 식당 공지
    private String restaurantRepresentativeMenu; // 식당 대표 메뉴
}
