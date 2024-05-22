package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.ReservationEntity;
import com.project.back.entity.RestaurantEntity;

@Repository
public interface RestaurantRepository extends JpaRepository<ReservationEntity,Integer> {
    List<RestaurantEntity> findByOrderByRestaurantIdDesc();
    RestaurantEntity findByRestaurantId(Integer restaurantId);

    boolean existsByRestaurantWriterId(String restaurantWriterId);
    void save(RestaurantEntity restaurantEntity);
    List<ReservationEntity> findByOrderByReservationNumberDesc();
}
