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

    List<RestaurantEntity> findByOrderByRestaurantIdDesc();
    RestaurantEntity findByRestaurantId(Integer restaurantId);

    boolean existsByRestaurantWriterId(String restaurantWriterId);
    boolean existsByRestaurantId(Integer restaurantId);

    @Query(value=
        "SELECT * " +
        "FROM restaurant " +
        "WHERE restaurant_id " +
        "IN " + 
        "(SELECT favorite_restaurant_id FROM favorite_restaurant WHERE favorite_user_id = :user_email_id)"
    )
    List<GetRestaurantFavoriteItemResultSet> getFavoriteList(@Param("favorite_user_id") String favoriteUserId);
}
