package com.project.back.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.FavoriteRestaurantEntity;


// Estate 데이터베이스의 Favorite_Restaurant 테이블의 작업을 위한 리포지토리

@Repository
public interface FavoriteRestaurantRepository extends JpaRepository<FavoriteRestaurantEntity,String> 
{
    
}
