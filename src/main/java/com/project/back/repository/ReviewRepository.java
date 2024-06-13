package com.project.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.back.entity.FavoriteRestaurantEntity;
import com.project.back.entity.ReviewEntity;
import com.project.back.repository.resultSet.GetRestaurantReviewListItemResultSet;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer> {
    @Query(
        value=
        "SELECT "
            + "r.review_number as reviewNumber, "
            + "r.review_restaurant_id as reviewRestaurantId, "
            + "r.review_image as reviewImage, "
            + "r.rating, "
            + "r.review_contents as reviewContents, "
            + "r.review_date as reviewDate, "
            + "r.review_writer_nickname as reviewWriterNickname "
        + "FROM review r LEFT JOIN user u ON r.review_writer_id = u.user_email_id "
        + "WHERE r.review_restaurant_id = :restaurantId",
        nativeQuery = true
    )
    List<GetRestaurantReviewListItemResultSet> findReviewsByRestaurantId(@Param("restaurantId") int restaurantId);
    ReviewEntity findByReviewNumber(int reviewNumber);
    List<FavoriteRestaurantEntity> findByOrderByReviewRestaurantIdDesc();
    
    @Query(
        value=
        "SELECT "
            + "r.review_number as reviewNumber, "
            + "r.review_restaurant_id as reviewRestaurantId, "
            + "r.review_image as reviewImage, "
            + "r.rating, "
            + "r.review_contents as reviewContents, "
            + "r.review_date as reviewDate, "
            + "r.review_writer_nickname as reviewWriterNickname "
            + "r.review_restaurant_name as reviewRestaurantName "
        + "FROM review r "
        + "WHERE review_writer_id = :userEmailId",
        nativeQuery=true
    )
    List<GetRestaurantReviewListItemResultSet> findByOrderByMyReviewListDesc(@Param("userEmailId") String reviewWriterId);

    boolean existsByReviewWriterIdAndReviewRestaurantId(String userEmailId, int restaurantId);
    void deleteByReviewWriterId(String userEmailId);
}