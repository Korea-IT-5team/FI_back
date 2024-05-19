package com.project.back.dto.request.restaurant.reservation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 식당 예약 취소 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class DeleteReservationRequestDto 
{
    private String cancellationReason; // 예약 취소 사유
}
