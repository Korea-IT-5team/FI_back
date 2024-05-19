package com.project.back.dto.request.restaurant.reservation;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//식당 예약 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class PostReservationRequestDto 
{
    @NotBlank
    private String reservationDate; //예약 일자
    @NotBlank
    private String reservationTime; //예약 시간
    @NotBlank
    private Integer reservationPeople; // 예약 인원 수
}
