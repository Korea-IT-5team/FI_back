package com.project.back.common.object;

import com.project.back.entity.RestaurantEntity;

import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

@Getter
public class RestaurantReviewListItem 
{
    private Integer restaurantId; 
    private String restaurantImage;
    private String restaurantName;
    private String restaurantFoodCategory;
    private String restaurantLocation;

    private RestaurantReviewListItem(RestaurantEntity restaurantEntity) throws Exception
    {
        this.restaurantId=restaurantEntity.getRestaurantId();
        this.restaurantImage=restaurantEntity.getRestaurantImage();
        this.restaurantName=restaurantEntity.getRestaurantName();
        this.restaurantFoodCategory=restaurantEntity.getRestaurantFoodCategory();
        this.restaurantLocation=restaurantEntity.getRestaurantLocation();
    }

    public static List<RestaurantReviewListItem> getList(List<RestaurantEntity> restaurantEntities) throws Exception
    {
        List<RestaurantReviewListItem> restaurantList = new ArrayList<>();

        for(RestaurantEntity restaurantEntity:restaurantEntities)
        {
            RestaurantListItem restaurantListItem = new RestaurantListItem(restaurantEntity);
            restaurantList.add(restaurantListItem);
        }

        return restaurantList;
    }
}
