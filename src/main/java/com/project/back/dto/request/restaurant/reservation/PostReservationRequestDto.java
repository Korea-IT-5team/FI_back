package com.project.back.dto.request.restaurant.reservation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostReservationRequestDto {
    @NotBlank
    private String reservationDate;
    @NotBlank
    private String reservationTime;
    @NotNull
    private Integer reservationPeople;
}