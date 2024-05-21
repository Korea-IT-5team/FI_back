package com.project.back.dto.request.restaurant.reservation;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//식당 예약 Request Body Dto
@Getter
@Setter
@NoArgsConstructor
public class PostReservationRequestDto {
    @NotBlank
    private String reservationDate;
    @NotBlank
    private String reservationTime;
    @NotBlank
    private Integer reservationPeople;
}
