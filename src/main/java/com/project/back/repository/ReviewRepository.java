package com.project.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.back.entity.ReservationEntity;
import com.project.back.entity.ReviewEntity;

// Estate 데이터베이스의 review 테이블의 작업을 위한 리포지토리

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer> 
{
    @Query(
        value=
        SELECT 
            review_number as reviewNumber,
            review_restaurant_id,
            review_image,
            rating,
            review_contents,
            review_writer_id,
            review_date, 
            nickname 
        FROM review r LEFT JOIN user u ON r.review_writer_id = u.user_email_id
        WHERE r.review_restaurant_id = 1;
    )
}
