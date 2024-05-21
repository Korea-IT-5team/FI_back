package com.project.back.repository.resultSet;

public interface GetRestaurantReservationListItemResultSet {
    Integer getReservationNumber();
    Boolean getReservationStatus();
    Integer getReservationRestaurantId();
    String getReservationRestaurantName();
    String getReservationUserId();
    String getReservationDate();
    String getReservationTime();
    Integer getReservationPeople();
}
