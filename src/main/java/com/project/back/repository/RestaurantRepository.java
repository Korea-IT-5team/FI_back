package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.back.entity.RestaurantEntity;
import com.project.back.repository.resultSet.GetRestaurantFavoriteItemResultSet;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity,Integer> {
    Object restaurantEntity = null;
    RestaurantEntity getRestaurantIdByRestaurantWriterId(String restaurantWriterId);

    
    List<RestaurantEntity> findByRestaurantNameContainingOrderByRestaurantIdDesc(String searchWord);
 
    
    RestaurantEntity findByRestaurantId(Integer restaurantId);

    boolean existsByRestaurantWriterId(String restaurantWriterId);
    boolean existsByRestaurantId(Integer restaurantId);

    

    @Query(value=
        "SELECT "
            + "r.restaurant_id as restaurantId, "
            + "r.restaurant_image as restaurantImage, "
            + "r.restaurant_name as restaurantName, "
            + "r.restaurant_food_category as restaurantFoodCategory, "
            + "r.restaurant_location as restaurantLocation "
        + "FROM restaurant r "
        + "WHERE restaurant_id "
        + "IN "
        + "(SELECT favorite_restaurant_id FROM favorite_restaurant WHERE `favorite_user_id` = :userEmailId)",
        nativeQuery=true
    )
    List<GetRestaurantFavoriteItemResultSet> getFavoriteList(@Param("userEmailId") String favoriteUserId);
}