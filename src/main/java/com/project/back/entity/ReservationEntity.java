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
    @Column(name = "reservation_number")
    private Integer reservationNumber;

    @Column(name = "reservation_status", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean status;

    @Column(name = "reservation_user_id")
    private String user;

    @Column(name = "reservation_restaurant_id", nullable = false)
    private Integer restaurant;

    @Column(name = "reservation_date", nullable = false)
    private LocalDateTime date;

    @Column(name = "reservation_time", nullable = false)
    private LocalDateTime time;

    @Column(name = "reservation_people", nullable = false)
    private Integer people;

    @Column(name = "cancellation_reason", columnDefinition = "TEXT")
    private String cancellationReason;
}
