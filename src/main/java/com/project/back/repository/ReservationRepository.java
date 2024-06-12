package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.ReservationEntity;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity,Integer> {
    ReservationEntity findByReservationNumber(Integer reservationNumber);
    List<ReservationEntity> findByReservationUserIdOrderByReservationNumberDesc(String reservationUserId);
    List<ReservationEntity> findByReservationRestaurantIdOrderByReservationNumberDesc(Integer reservationRestaurantId);
    boolean existsByReservationUserIdAndReservationRestaurantId(String reservationUserId, Integer reservationRestaurantId);
    ReservationEntity findByReservationUserIdAndReservationRestaurantId(String reservationUserId, Integer reservationRestaurantId);
    //수정
    void deleteByReservationUserId(String userEmailId);
    //수정
}
