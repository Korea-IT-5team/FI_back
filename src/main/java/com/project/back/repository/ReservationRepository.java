package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.back.entity.ReservationEntity;

// Estate 데이터베이스의 reservation 테이블의 작업을 위한 리포지토리

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity,Integer> 
{
 
    @Query(
        value=
        "SELECT "
            + "r.reservation_number as reservationNumber, "
            + "r.reservation_status as reservationStatus, "
            + "r.reservation_restaurant_id as reservationRestaurantId, "
            + "res.restaurant_name as reservationRestaurantName, "
            + "r.reservation_user_id as reservationUserId, "
            + "r.reservation_date as reservationDate, "
            + "r.reservation_time as reservationTime, "
            + "r.reservation_people as reservationPeople "
        + "FROM reservation r "
        + "LEFT JOIN restaurant res ON r.reservation_restaurant_id = res.restaurant_id "
        + "WHERE r.reservation_user_id = :userEmailId",
        nativeQuery = true
    )
    List<Object[]> findReservationsByUserId(@Param("userEmailId") String userEmailId);
}


