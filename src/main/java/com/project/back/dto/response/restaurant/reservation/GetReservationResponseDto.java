package com.project.back.dto.response.restaurant.reservation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.object.restaurant.reservation.RestaurantReservationListItem;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.repository.resultSet.GetRestaurantReservationListItemResultSet;

import lombok.Getter;

@Getter
public class GetReservationResponseDto extends ResponseDto{

   
    private List<RestaurantReservationListItem> restaurantReservationList;
    
    private GetReservationResponseDto(List<GetRestaurantReservationListItemResultSet> reservationEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.restaurantReservationList = RestaurantReservationListItem.getList(reservationEntities);
    }

    public static ResponseEntity<GetReservationResponseDto> success(List<GetRestaurantReservationListItemResultSet> reservationEntities)
    throws Exception {
        GetReservationResponseDto responseBody = new GetReservationResponseDto(reservationEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
