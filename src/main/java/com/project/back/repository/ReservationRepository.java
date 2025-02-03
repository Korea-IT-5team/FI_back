package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.ReservationEntity;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity,Integer> {
    boolean existsByReservationUserIdAndReservationRestaurantId(String reservationUserId, Integer reservationRestaurantId);

    ReservationEntity findByReservationNumber(Integer reservationNumber);
    List<ReservationEntity> findByReservationUserIdOrderByReservationNumberDesc(String reservationUserId);
    List<ReservationEntity> findByReservationRestaurantIdOrderByReservationNumberDesc(Integer reservationRestaurantId);
    ReservationEntity findByReservationUserIdAndReservationRestaurantId(String reservationUserId, Integer reservationRestaurantId);
    
    void deleteByReservationUserId(String userEmailId);
}
