package com.project.back.entity;

import com.project.back.dto.request.restaurant.reservation.PostReservationRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="reservation")
@Table(name="reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationNumber;
    private Boolean reservationStatus;
    private String reservationUserId;
    private String reservationUserName;
    private Integer reservationRestaurantId;
    private String reservationRestaurantName;
    private String  reservationDate;
    private String reservationTime;
    private Integer reservationPeople;
    private String reservationRestaurantLocation;
    private String reservationUserTelNumber;

    public ReservationEntity(PostReservationRequestDto dto, 
    String userEmailId, int restaurantId, UserEntity userEntity, RestaurantEntity restaurantEntity)
    {
        this.reservationStatus = true;
        this.reservationUserId = userEmailId;
        this.reservationUserName = userEntity.getUserName();
        this.reservationRestaurantId = restaurantId;
        this.reservationRestaurantName = restaurantEntity.getRestaurantName();
        this.reservationDate = dto.getReservationDate();
        this.reservationTime = dto.getReservationTime();
        this.reservationPeople = dto.getReservationPeople();
        this.reservationRestaurantLocation = restaurantEntity.getRestaurantLocation();
        this.reservationUserTelNumber = userEntity.getUserTelNumber();
    }
}