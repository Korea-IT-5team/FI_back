package com.project.back.dto.response.restaurant;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.object.restaurant.RestaurantReviewListItem;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.RestaurantEntity;
import com.project.back.repository.resultSet.GetRestaurantReviewListItemResultSet;

import lombok.Getter;

@Getter
public class  GetRestaurantInfoResponseDto extends ResponseDto {
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
    private String restaurantWriterId;
    private List<RestaurantReviewListItem> restaurantReviewList;
    
    private GetRestaurantInfoResponseDto(RestaurantEntity restaurantEntity, List<GetRestaurantReviewListItemResultSet> reviewEntities)
    throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.restaurantId = restaurantEntity.getRestaurantId();
        this.restaurantImage = restaurantEntity.getRestaurantImage();
        this.restaurantName = restaurantEntity.getRestaurantName();
        this.restaurantFoodCategory = restaurantEntity.getRestaurantFoodCategory();
        this.restaurantPostalCode = restaurantEntity.getRestaurantPostalCode();
        this.restaurantLocation = restaurantEntity.getRestaurantLocation();
        this.restaurantTelNumber = restaurantEntity.getRestaurantTelNumber();
        this.restaurantSnsAddress = restaurantEntity.getRestaurantSnsAddress();
        this.restaurantOperationHours = restaurantEntity.getRestaurantOperationHours();
        this.restaurantFeatures = restaurantEntity.getRestaurantFeatures();
        this.restaurantNotice = restaurantEntity.getRestaurantNotice();
        this.restaurantRepresentativeMenu = restaurantEntity.getRestaurantRepresentativeMenu();
        this.restaurantBusinessRegistrationNumber = restaurantEntity.getRestaurantBusinessRegistrationNumber();
        this.restaurantWriterId = restaurantEntity.getRestaurantWriterId();
        this.restaurantReviewList = RestaurantReviewListItem.getList(reviewEntities);
    }

    public static ResponseEntity<GetRestaurantInfoResponseDto> success(RestaurantEntity restaurantEntity, List<GetRestaurantReviewListItemResultSet> getRestaurantReviewListItemResultSets)
    throws Exception {
        GetRestaurantInfoResponseDto responseBody = new GetRestaurantInfoResponseDto(restaurantEntity,getRestaurantReviewListItemResultSets);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
