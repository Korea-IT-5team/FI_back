package com.project.back.dto.response.Restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.object.RestaurantListItem;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.dto.response.User.LoginUserInformationResponseDto;
import com.project.back.entity.RestaurantEntity;
import com.project.back.entity.UserEntity;
import java.util.List;
import java.util.ArrayList;

// 식당 목록 검색 정보 반환 Response Body Dto

public class GetSearchRestaurantlistResponseDto extends ResponseDto
{
    private List<RestaurantListItem> restaurantList;
    
    private GetSearchRestaurantlistResponseDto(List<RestaurantEntity> restaurantEntities) throws Exception
    {
        super(ResponseCode.SUCCESS,ResponseMessage.SUCCESS);
        this.restaurantList= RestaurantListItem.getList(restaurantEntities);
    }

    public static ResponseEntity<GetSearchRestaurantlistResponseDto> success(List<RestaurantEntity> restaurantEntities)
    throws Exception
    {
        GetSearchRestaurantlistResponseDto responseBody = new GetSearchRestaurantlistResponseDto(restaurantEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}



