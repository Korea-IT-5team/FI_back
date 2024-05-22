package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.back.entity.ReservationEntity;
import com.project.back.repository.resultSet.GetRestaurantReservationListItemResultSet;
@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity,Integer> {
    // @Query(
    //     value=
    //     "SELECT "
    //         + "r.reservation_number as reservationNumber, "
    //         + "r.reservation_status as reservationStatus, "
    //         + "r.reservation_restaurant_id as reservationRestaurantId, "
    //         + "res.restaurant_name as reservationRestaurantName, "
    //         + "r.reservation_user_id as reservationUserId, "
    //         + "r.reservation_date as reservationDate, "
    //         + "r.reservation_time as reservationTime, "
    //         + "r.reservation_people as reservationPeople "
    //     + "FROM reservation r "
    //     + "LEFT JOIN restaurant res ON r.reservation_restaurant_id = res.restaurant_id "
    //     + "WHERE r.reservation_user_id = :userEmailId",
    //     nativeQuery = true
    // )
    // List<GetRestaurantReservationListItemResultSet[]> findReservationsByUserId(@Param("userEmailId") String userEmailId);
    List<ReservationEntity> findByOrderByReservationNumberDesc();
    ReservationEntity findByReservationNumber(Integer reservationNumber);
}


