package com.project.back.repository.resultSet;

public interface GetRestaurantReviewListItemResultSet
{
    Integer getReviewNumber(); // 리뷰 접수 번호
    Integer getReviewRestaurantId(); // 식당 아이디
    String getReviewImage(); // 리뷰 사진
    Double getRating(); // 평점
    String getReviewContents(); // 리뷰 내용
    String getReviewWriterId(); // 리뷰 작성자 아이디
    String getReviewDate(); // 리뷰 작성 일시
    String getNickname(); // 리뷰 작성자 닉네임
}
