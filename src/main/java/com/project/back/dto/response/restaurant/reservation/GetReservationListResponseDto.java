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
public class GetReservationListResponseDto extends ResponseDto{
    private List<RestaurantReservationListItem> restaurantReservationList;
    
    private GetReservationListResponseDto(List<GetRestaurantReservationListItemResultSet> getRestaurantReservationListItemResultSets) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.restaurantReservationList = RestaurantReservationListItem.getList(getRestaurantReservationListItemResultSets);
    }

    public static ResponseEntity<GetReservationListResponseDto> success(List<GetRestaurantReservationListItemResultSet> getRestaurantReservationListItemResultSets)
    throws Exception {
        GetReservationListResponseDto responseBody = new GetReservationListResponseDto(getRestaurantReservationListItemResultSets);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
