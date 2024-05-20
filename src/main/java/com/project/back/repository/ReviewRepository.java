package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.back.entity.ReviewEntity;
import com.project.back.repository.resultSet.GetRestaurantReviewListItemResultSet;

// Estate 데이터베이스의 review 테이블의 작업을 위한 리포지토리

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer> 
{
    @Query(
        value=
        "SELECT "
            + "r.review_number as reviewNumber, "
            + "r.review_restaurant_id, "
            + "r.review_image, "
            + "r.rating, "
            + "r.review_contents, "
            + "r.review_writer_id, "
            + "r.review_date, "
            + "u.nickname "
        + "FROM review r LEFT JOIN user u ON r.review_writer_id = u.user_email_id "
        + "WHERE r.review_restaurant_id = :restaurantId",
        nativeQuery = true
    )
    List<GetRestaurantReviewListItemResultSet[]> findReviewsByRestaurantId(@Param("restaurantId") int restaurantId);
}
