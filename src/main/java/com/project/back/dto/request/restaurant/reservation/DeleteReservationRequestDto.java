package com.project.back.dto.request.restaurant.reservation;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class DeleteReservationRequestDto {
    private String cancellationReason;
}
