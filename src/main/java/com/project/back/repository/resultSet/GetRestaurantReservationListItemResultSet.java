package com.project.back.repository.resultSet;

public interface GetRestaurantReservationListItemResultSet 
{
    Integer getReservationNumber(); // 예약 번호
    Boolean getReservationStatus(); // 예약 상태
    Integer getReservationRestaurantId(); // 식당 아이디
    String getReservationRestaurantName(); // 식당 이름
    String getReservationUserId(); // 사용자 아이디
    String getReservationDate(); // 예약 일자
    String getReservationTime(); // 예약 시간
    Integer getReservationPeople(); // 예약 인원 수
}
