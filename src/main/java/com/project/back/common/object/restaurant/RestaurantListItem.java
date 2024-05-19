package com.project.back.common.object.restaurant;

import java.util.ArrayList;
import java.util.List;

import com.project.back.entity.RestaurantEntity;

import lombok.Getter;

@Getter
public class RestaurantListItem 
{
    private Integer restaurantId; 
    private String restaurantImage;
    private String restaurantName;
    private String restaurantFoodCategory;
    private String restaurantLocation;

    private RestaurantListItem(RestaurantEntity restaurantEntity) throws Exception
    {
        this.restaurantId=restaurantEntity.getRestaurantId();
        this.restaurantImage=restaurantEntity.getRestaurantImage();
        this.restaurantName=restaurantEntity.getRestaurantName();
        this.restaurantFoodCategory=restaurantEntity.getRestaurantFoodCategory();
        this.restaurantLocation=restaurantEntity.getRestaurantLocation();
    }

    public static List<RestaurantListItem> getList(List<RestaurantEntity> restaurantEntities) throws Exception
    {
        List<RestaurantListItem> restaurantList = new ArrayList<>();

        for(RestaurantEntity restaurantEntity:restaurantEntities)
        {
            RestaurantListItem restaurantListItem = new RestaurantListItem(restaurantEntity);
            restaurantList.add(restaurantListItem);
        }

        return restaurantList;
    }
}
