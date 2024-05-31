package com.project.back.entity;



import com.project.back.dto.request.restaurant.reservation.PostReservationRequestDto;

import jakarta.persistence.Entity;
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
    String userEmailId, int restaurantId, String userName, String restaurantName
    ,String restaurantLocation, String userTelNumber)
    {
        this.reservationStatus = true;
        this.reservationUserId = userEmailId;
        this.reservationUserName = userName;
        this.reservationRestaurantId = restaurantId;
        this.reservationRestaurantName = restaurantName;
        this.reservationDate = dto.getReservationDate();
        this.reservationTime = dto.getReservationTime();
        this.reservationPeople = dto.getReservationPeople();
        this.reservationRestaurantLocation = restaurantLocation;
        this.reservationUserTelNumber = userTelNumber;
    }
}
//수정