package com.project.back.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.FavoriteRestaurantEntity;

@Repository
public interface FavoriteRestaurantRepository extends JpaRepository<FavoriteRestaurantEntity, Integer> {
    boolean existsByFavoriteUserIdAndFavoriteRestaurantId(String favoriteUserId, Integer favoriteRestaurantId);

    FavoriteRestaurantEntity findByFavoriteUserIdAndFavoriteRestaurantId(String favoriteUserId, Integer favoriteRestaurantId);

    void deleteByFavoriteUserId(String userEmailId);
}