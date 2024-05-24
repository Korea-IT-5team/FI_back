package com.project.back.common.object.restaurant.reservation;

import java.util.ArrayList;
import java.util.List;

import com.project.back.common.util.ChangeDateFormatUtil;
import com.project.back.repository.resultSet.GetRestaurantReservationListItemResultSet;

import lombok.Getter;

@Getter
public class RestaurantReservationListItem {
    private Integer reservationNumber;
    private boolean reservationStatus;
    private Integer reservationRestaurantId;
    private String reservatoinRestaurantName; 
    private String reservationUserId;
    private String reservationDate;
    private String reservationTime;
    private Integer reservationPeople;

    private RestaurantReservationListItem(GetRestaurantReservationListItemResultSet reservationEntitiy) throws Exception {
        this.reservationNumber = reservationEntitiy.getReservationNumber();
        this.reservationStatus = reservationEntitiy.getReservationStatus();
        this.reservationRestaurantId = reservationEntitiy.getReservationRestaurantId();
        this.reservatoinRestaurantName=reservationEntitiy.getReservationRestaurantName();

        String writerId = reservationEntitiy.getReservationUserId();
        writerId = writerId.substring(0, 1)+
        "*".repeat(writerId.length()-1); 
        this.reservationUserId=writerId;

        String writeDate  = ChangeDateFormatUtil.changeYYMMDD(reservationEntitiy.getReservationDate());
        this.reservationDate = writeDate;

        writeDate = ChangeDateFormatUtil.changeHHmm(reservationEntitiy.getReservationTime());
        this.reservationTime = writeDate;

        this.reservationPeople=reservationEntitiy.getReservationPeople();
    }

    public static List<RestaurantReservationListItem> getList(List<GetRestaurantReservationListItemResultSet> reservationEntities) throws Exception {
        List<RestaurantReservationListItem> restaurantReservationList = new ArrayList<>();

        for(GetRestaurantReservationListItemResultSet reservationEntitiy:reservationEntities) {
            RestaurantReservationListItem restaurantReservationListItem = new RestaurantReservationListItem(reservationEntitiy);
            restaurantReservationList.add(restaurantReservationListItem);
        }
        return restaurantReservationList;
    }
}
