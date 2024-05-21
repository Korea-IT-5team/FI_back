package com.project.back.common.object.restaurant.reservation;

import java.util.ArrayList;
import java.util.List;

import com.project.back.common.util.ChangeDateFormatUtil;
import com.project.back.repository.resultSet.GetRestaurantReservationListItemResultSet;

public class RestaurantReservationListItem {
    private Integer reservationNumber;
    private boolean reservationStatus;
    private Integer reservationRestaurantId;
    private String reservatoinRestaurantName; 
    private String reservationUserId;
    private String reservationDate;
    private String reservationTime;
    private Integer reservationPeople;

    private RestaurantReservationListItem(GetRestaurantReservationListItemResultSet getRestaurantReviewListItemResultSet) throws Exception {
        this.reservationNumber = getRestaurantReviewListItemResultSet.getReservationNumber();
        this.reservationStatus = getRestaurantReviewListItemResultSet.getReservationStatus();
        this.reservationRestaurantId = getRestaurantReviewListItemResultSet.getReservationRestaurantId();
        this.reservatoinRestaurantName=getRestaurantReviewListItemResultSet.getReservationRestaurantName();

        String writerId = getRestaurantReviewListItemResultSet.getReservationUserId();
        writerId = writerId.substring(0, 1)+
        "*".repeat(writerId.length()-1); 
        this.reservationUserId=writerId;

        String writeDate  = ChangeDateFormatUtil.changeYYMMDD(getRestaurantReviewListItemResultSet.getReservationDate());
        this.reservationDate = writeDate;

        writeDate = ChangeDateFormatUtil.changeHHmm(getRestaurantReviewListItemResultSet.getReservationTime());
        this.reservationTime = writeDate;

        this.reservationPeople=getRestaurantReviewListItemResultSet.getReservationPeople();
    }

    public static List<RestaurantReservationListItem> getList(List<GetRestaurantReservationListItemResultSet> getRestaurantReservationListItemResultSets) throws Exception {
        List<RestaurantReservationListItem> restaurantReservationList = new ArrayList<>();

        for(GetRestaurantReservationListItemResultSet getRestaurantReservationListItemResultSet:getRestaurantReservationListItemResultSets) {
            RestaurantReservationListItem restaurantReservationListItem = new RestaurantReservationListItem(getRestaurantReservationListItemResultSet);
            restaurantReservationList.add(restaurantReservationListItem);
        }
        return restaurantReservationList;
    }
}
