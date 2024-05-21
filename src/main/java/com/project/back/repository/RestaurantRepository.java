package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.ReservationEntity;
import com.project.back.entity.RestaurantEntity;

// Estate 데이터베이스의 restaurant 테이블의 작업을 위한 리포지토리

@Repository
public interface RestaurantRepository extends JpaRepository<ReservationEntity,Integer> 
{
    List<RestaurantEntity> findByOrderByRestaurantIdDesc();
    List<RestaurantEntity> findByRestaurantNameContainsOrderByRestaurantIdDesc(String restaurantName);
}
