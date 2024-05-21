package com.project.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.ReservationEntity;

@Repository
public interface RestaurantRepository extends JpaRepository<ReservationEntity,Integer> {
    
}
