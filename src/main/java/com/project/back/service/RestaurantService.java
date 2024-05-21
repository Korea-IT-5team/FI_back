package com.project.back.service;

import org.springframework.http.ResponseEntity;

import com.project.back.dto.request.restaurant.PatchRestaurantInfoRequestDto;
import com.project.back.dto.request.restaurant.PostRestaurantInfoRequestDto;
import com.project.back.dto.request.restaurant.reservation.DeleteReservationRequestDto;
import com.project.back.dto.request.restaurant.reservation.PostReservationRequestDto;
import com.project.back.dto.request.restaurant.review.PatchReviewRequestDto;
import com.project.back.dto.request.restaurant.review.PostReviewRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.restaurant.GetRestaurantInfoResponseDto;
import com.project.back.dto.response.restaurant.GetRestaurantListResponseDto;
import com.project.back.dto.response.restaurant.reservation.GetReservationListResponseDto;

public interface RestaurantService {
    // 식당 정보
    ResponseEntity<ResponseDto> patchRestaurantInfo(PatchRestaurantInfoRequestDto dto);
    ResponseEntity<ResponseDto> postRestaurantInfo(PostRestaurantInfoRequestDto dto);

    ResponseEntity<? super GetRestaurantInfoResponseDto> getRestaurantInfo();
    ResponseEntity<? super GetRestaurantListResponseDto> getRestaurantList();

    // 식당 예약
    ResponseEntity<ResponseDto> deleteReservation(DeleteReservationRequestDto dto);
    ResponseEntity<ResponseDto> postReservation (PostReservationRequestDto dto);
    
    // 식당 리뷰
    ResponseEntity<ResponseDto> patchReview (PatchReviewRequestDto dto);
    ResponseEntity<ResponseDto> postReview (PostReviewRequestDto dto);


}
