package com.project.back.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.FavoriteRestaurantEntity;


@Repository
public interface FavoriteRestaurantRepository extends JpaRepository<FavoriteRestaurantEntity,String> {
    boolean existsByFavoriteUserId(String favoriteUserId);
    FavoriteRestaurantEntity findByFavoriteRestaurantId(String favoriteRestaurantId);
    ;
}
