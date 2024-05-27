package com.project.back.common.object.restaurant;

import java.util.ArrayList;
import java.util.List;

import com.project.back.common.util.ChangeDateFormatUtil;
import com.project.back.entity.ReservationEntity;

import lombok.Getter;

@Getter
public class RestaurantReservationListItem {
    private Integer reservationNumber;
    private boolean reservationStatus;
    private Integer reservationRestaurantId;
    private String reservationRestaurantName;
    private String reservationUserEmailId;
    private String reservationUserName;
    private String reservationDate;
    private String reservationTime;
    private Integer reservationPeople;

    private RestaurantReservationListItem(ReservationEntity reservationEntity) throws Exception {
        this.reservationNumber = reservationEntity.getReservationNumber();
        this.reservationStatus = false;
        this.reservationRestaurantId = reservationEntity.getReservationRestaurantId();
        this.reservationRestaurantName = reservationEntity.getReservationRestaurantName();

        String writerId = reservationEntity.getReservationUserEmailId();
        writerId = writerId.substring(0, 1) +
        "*".repeat(writerId.length() - 1); 
        this.reservationUserEmailId = writerId;

        this.reservationUserName = reservationEntity.getReservationUserName();

        String writeDate = ChangeDateFormatUtil.changeYYMMDD(reservationEntity.getReservationDate());
        this.reservationDate = writeDate;

        writeDate = ChangeDateFormatUtil.changeHHmm(reservationEntity.getReservationTime());
        this.reservationTime = writeDate;

        this.reservationPeople = reservationEntity.getReservationPeople();
    }

    public static List<RestaurantReservationListItem> getList(List<ReservationEntity> reservationEntities) throws Exception {
        List<RestaurantReservationListItem> restaurantReservationList = new ArrayList<>();

        for(ReservationEntity reservationEntity:reservationEntities) {
            RestaurantReservationListItem restaurantReservationListItem = new RestaurantReservationListItem(reservationEntity);
            restaurantReservationList.add(restaurantReservationListItem);
        }
        return restaurantReservationList;
    }
}