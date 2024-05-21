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
import com.project.back.dto.response.restaurant.favorite.GetFavoriteListResponseDto;
import com.project.back.dto.response.restaurant.reservation.GetReservationListResponseDto;
import com.project.back.dto.response.restaurant.reservation.GetReservationResponseDto;

public interface RestaurantService {
    // 식당 정보
    ResponseEntity<ResponseDto> patchRestaurantInfo(PatchRestaurantInfoRequestDto dto, String userEmailId);
    ResponseEntity<ResponseDto> postRestaurantInfo(PostRestaurantInfoRequestDto dto);

    ResponseEntity<? super GetRestaurantInfoResponseDto> getRestaurantInfo();
    ResponseEntity<? super GetRestaurantListResponseDto> getRestaurantList(String searchWord);

    // 식당 예약
    ResponseEntity<ResponseDto> deleteReservation(DeleteReservationRequestDto dto, String restaurantId);
    ResponseEntity<ResponseDto> postReservation (PostReservationRequestDto dto);

    ResponseEntity<? super GetReservationResponseDto> getReservation();
    ResponseEntity<? super GetReservationListResponseDto> getReservationList();
    
    // 식당 리뷰
    ResponseEntity<ResponseDto> patchReview (PatchReviewRequestDto dto);
    ResponseEntity<ResponseDto> postReview (PostReviewRequestDto dto);

    // 식당 찜
    ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList();

}
