package com.project.back.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// project 데이터베이스의 reservation 테이블과 매핑되는 Entity 클래스
@Entity(name="reservation")
@Table(name="reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationNumber;
    private boolean reservationStatus;
    private String reservationUserId;
    private Integer reservationRestaurantId;
    private LocalDateTime reservationDate;
    private LocalDateTime reservationTime;
    private Integer reservationPeople;
    private String cancellationReason;
}
