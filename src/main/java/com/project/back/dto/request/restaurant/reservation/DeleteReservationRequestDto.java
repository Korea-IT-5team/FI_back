package com.project.back.dto.request.restaurant.reservation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteReservationRequestDto {
    private String cancellationReason;
}
