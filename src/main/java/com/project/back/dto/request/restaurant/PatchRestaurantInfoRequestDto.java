package com.project.back.dto.request.restaurant;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//식당 정보 수정 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class PatchRestaurantInfoRequestDto
{
    @NotBlank
    private String restaurantName; //식당 이름
    @NotBlank
    private String restaurantFoodCategory; //식당 음식 카테고리
    @NotBlank
    private String postalCode;//식당 우편번호
    @NotBlank
    private String restaurantLocation;//식당 주소
    @NotBlank
    private String restaurantId; //식당 아이디
    @NotBlank
    private String restaurantImage; //식당 대표 사진
    private String restaurantTelNumber;// 식당 연락쳐
    private String restaurantSnsAddress;// 식당 sns 주소
    private String restaurantOperationHours;//식당 운영 시간
    private String restaurantFeatures;//식당 특징
    private String restaurantNotice;//식당 공지
    private String restaurantRepresentativeMenu;//식당 대표 메뉴
}
