package com.project.back.dto.response.restaurant.reservation;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.util.ChangeDateFormatUtil;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.ReservationEntity;

import lombok.Getter;

@Getter
public class GetReservationResponseDto extends ResponseDto{
    private Integer reservationNumber;
    private Boolean reservationStatus;
    private Integer reservationRestaurantId;
    private String reservationRestaurantName;
    private String reservationUserEmailId;
    private String reservationDate;
    private String reservationTime;
    private Integer reservationPeople;
    
    private GetReservationResponseDto(ReservationEntity reservationEntity) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

        String reservationDate = ChangeDateFormatUtil.changeYYMMDD(reservationEntity.getReservationDate());
        String reservationTime = ChangeDateFormatUtil.changeHHmm(reservationEntity.getReservationTime());
        
        this.reservationNumber = reservationEntity.getReservationNumber();
        this.reservationStatus = reservationEntity.getReservationStatus();
        this.reservationRestaurantId = reservationEntity.getReservationRestaurantId();
        this.reservationRestaurantName = reservationEntity.getReservationRestaurantName();
        this.reservationUserEmailId = reservationEntity.getReservationUserEmailId();
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.reservationPeople = reservationEntity.getReservationPeople();
    }

    public static ResponseEntity<GetReservationResponseDto> success(ReservationEntity reservationEntity)
    throws Exception {
        GetReservationResponseDto responseBody = new GetReservationResponseDto(reservationEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
