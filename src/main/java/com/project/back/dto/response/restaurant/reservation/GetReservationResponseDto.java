package com.project.back.dto.response.restaurant.reservation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.object.restaurant.reservation.RestaurantReservationListItem;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.repository.resultSet.GetRestaurantReservationListItemResultSet;

// 특정 예약 내역 확인 Response Body DTO
public class GetReservationResponseDto extends ResponseDto{

    private Integer reservationNumber;
    private Integer reservationPeople;
    private Boolean reservationStatus;
    private String reservationRestaurantId;
    private String reservationUserId;
    private String reservationDate;
    private String reservationTime;



    private List<RestaurantReservationListItem> restaurantReservationList;
    
    private GetReservationResponseDto(List<GetRestaurantReservationListItemResultSet> getRestaurantReservationListItemResultSets) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.restaurantReservationList = RestaurantReservationListItem.getList(getRestaurantReservationListItemResultSets);
    }

    public static ResponseEntity<GetReservationResponseDto> success(List<GetRestaurantReservationListItemResultSet> getRestaurantReservationListItemResultSets)
    throws Exception {
        GetReservationResponseDto responseBody = new GetReservationResponseDto(getRestaurantReservationListItemResultSets);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
