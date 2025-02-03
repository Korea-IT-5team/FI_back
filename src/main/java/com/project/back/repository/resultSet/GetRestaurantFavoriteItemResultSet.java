package com.project.back.repository.resultSet;

public interface GetRestaurantFavoriteItemResultSet {
    Integer getRestaurantId();
    String getRestaurantImage();
    String getRestaurantName();
    String getRestaurantFoodCategory();
    String getRestaurantLocation();
}