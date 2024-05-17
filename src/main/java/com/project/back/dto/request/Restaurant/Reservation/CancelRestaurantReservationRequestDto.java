package com.project.back.dto.request.Restaurant.Reservation;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 식당 예약 취소 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class CancelRestaurantReservationRequestDto 
{
    @NotBlank
    private String cancellationReason; // 예약 취소 사유
}
