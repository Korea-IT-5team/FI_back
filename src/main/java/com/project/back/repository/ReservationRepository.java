package com.project.back.repository;

import java.util.List;

import com.project.back.entity.ReservationEntity;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity,Integer> {
    ReservationEntity findByReservationNumber(Integer reservationNumber);
    boolean existsByReservationUserIdAndReservationRestaurantId(String reservationUserId, Integer reservationRestaurantId);
    ReservationEntity findByReservationUserIdAndReservationRestaurantId(String reservationUserId, Integer reservationRestaurantId);
    
    List<ReservationEntity> findByReservationUserIdOrderByReservationNumberDesc(String reservationUserId);
    List<ReservationEntity> findByReservationRestaurantIdOrderByReservationNumberDesc(Integer reservationRestaurantId);
    
    void deleteByReservationUserId(String userEmailId);
}
