package com.project.back.common.object.restaurant;

import java.util.ArrayList;
import java.util.List;

import com.project.back.entity.RestaurantEntity;
import com.project.back.repository.resultSet.GetRestaurantFavoriteItemResultSet;

import lombok.Getter;

@Getter
public class RestaurantListItem {
    private String restaurantImage;
    private String restaurantName;
    private String restaurantFoodCategory;
    private String restaurantLocation;

    private RestaurantListItem(RestaurantEntity restaurantEntity) throws Exception {
        this.restaurantImage=restaurantEntity.getRestaurantImage();
        this.restaurantName=restaurantEntity.getRestaurantName();
        this.restaurantFoodCategory=restaurantEntity.getRestaurantFoodCategory();
        this.restaurantLocation=restaurantEntity.getRestaurantLocation();
    }

    private RestaurantListItem(GetRestaurantFavoriteItemResultSet getRestaurantFavoriteItemResultSet) throws Exception {
        this.restaurantImage=getRestaurantFavoriteItemResultSet.getRestaurantImage();
        this.restaurantName=getRestaurantFavoriteItemResultSet.getRestaurantName();
        this.restaurantFoodCategory=getRestaurantFavoriteItemResultSet.getRestaurantFoodCategory();
        this.restaurantLocation=getRestaurantFavoriteItemResultSet.getRestaurantLocation();
    }

    public static List<RestaurantListItem> getRestaurantList(List<RestaurantEntity> restaurantEntities) throws Exception {
        List<RestaurantListItem> restaurantList = new ArrayList<>();

        for (RestaurantEntity restaurantEntity:restaurantEntities) {
            RestaurantListItem restaurantListItem = new RestaurantListItem(restaurantEntity);
            restaurantList.add(restaurantListItem);
        }
        return restaurantList;
    }

    public static List<RestaurantListItem> getFavoriteRestaurantList(List<GetRestaurantFavoriteItemResultSet> getRestaurantFavoriteItemResultSetList) throws Exception {
        List<RestaurantListItem> restaurantList = new ArrayList<>();

        for(GetRestaurantFavoriteItemResultSet getRestaurantFavoriteItemResultSet:getRestaurantFavoriteItemResultSetList) {
            RestaurantListItem restaurantFavoriteListItem = new RestaurantListItem(getRestaurantFavoriteItemResultSet);
            restaurantList.add(restaurantFavoriteListItem);
        }
        return restaurantList;
    }
}
