package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.ReservationEntity;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity,Integer> {
    ReservationEntity findByReservationNumber(Integer reservationNumber);
<<<<<<< HEAD
    //###수정
    List<ReservationEntity> findByReservationUserIdOrderByReservationNumberDesc(String reservationUserId);
    List<ReservationEntity> findByReservationRestaurantIdOrderByReservationNumberDesc(Integer reservationRestaurantId);
    //###수정
=======
    List<ReservationEntity> findByReservationUserIdOrderByReservationNumberDesc(String userEmailId);
    List<ReservationEntity> findByReservationRestaurantIdOrderByReservationNumberDesc(Integer restaurantId);
>>>>>>> 7806f2bfa418ed089439eaef1488763037f73200

    //
    boolean existsByReservationUserIdAndReservationRestaurantId(String reservationUserId, Integer reservationRestaurantId);
    ReservationEntity findByReservationUserIdAndReservationRestaurantId(String reservationUserId, Integer reservationRestaurantId);
    //
}

//수정###
