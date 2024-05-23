package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.back.entity.ReservationEntity;
@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity,Integer> {
    List<ReservationEntity> findByUserEmailIdOrderByReservationNumberDesc(String userEmailId);
    ReservationEntity findByReservationNumber(Integer reservationNumber);
}


