package com.project.back.dto.response.Restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.dto.response.User.LoginUserInformationResponseDto;
import com.project.back.entity.RestaurantEntity;
import com.project.back.entity.UserEntity;

// 특정 식당 정보 조회 Response Body Dto

public class GetSearchForSpecificRestaurantInformation extends ResponseDto
{
    private Integer restaurantId; 
    private String restaurantImage;
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
    //private restaurantReviewListItem[] restaurantReviewList;
    
    
    private GetSearchForSpecificRestaurantInformation(RestaurantEntity restaurantEntity)
    {
        super(ResponseCode.SUCCESS,ResponseMessage.SUCCESS);
        this.restaurantId = restaurantEntity.getRestaurantId();
        this.restaurantImage= restaurantEntity.getRestaurantImage();
        this.restaurantName=restaurantEntity.getRestaurantName();
        this.restaurantFoodCategory=restaurantEntity.getRestaurantFoodCategory();
        this.restaurantPostalCode=restaurantEntity.getPostalCode();
        this.restaurantLocation=restaurantEntity.getRestaurantLocation();
        this.restaurantTelNumber=restaurantEntity.getRestaurantTelNumber();
        this.restaurantSnsAddress=restaurantEntity.getRestaurantSnsAddress();
        this.restaurantOperationHours=restaurantEntity.getRestaurantOperationHours();
        this.restaurantFeatures=restaurantEntity.getRestaurantFeatures();
        this.restaurantNotice=restaurantEntity.getRestaurantNotice();
        this.restaurantRepresentativeMenu=restaurantEntity.getRestaurantRepresentativeMenu();
        this.restaurantBusinessRegistrationNumber=restaurantEntity.getRestaurantBusinessRegistrationNumber();
        this.restaurantReviewList=
    }

    public static ResponseEntity<GetSearchForSpecificRestaurantInformation> success(RestaurantEntity restaurantEntity)
    {
        GetSearchForSpecificRestaurantInformation responseBody = new GetSearchForSpecificRestaurantInformation(restaurantEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
