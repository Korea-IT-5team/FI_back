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
    ResponseEntity<? super GetRestaurantInfoResponseDto> getRestaurantInfo(int restaurantId);
    ResponseEntity<? super GetRestaurantListResponseDto> getRestaurantList(String searchWord);
    ResponseEntity<ResponseDto> patchRestaurantInfo(PatchRestaurantInfoRequestDto dto, int restaurantId, String userEmailId);
    ResponseEntity<ResponseDto> postRestaurantInfo(PostRestaurantInfoRequestDto dto);

    // 식당 예약
    ResponseEntity<? super GetReservationResponseDto> getReservation();
    ResponseEntity<? super GetReservationListResponseDto> getReservationList();
    ResponseEntity<ResponseDto> deleteReservation(DeleteReservationRequestDto dto, String restaurantId);
    ResponseEntity<ResponseDto> postReservation (PostReservationRequestDto dto);
    
    // 식당 리뷰
    ResponseEntity<ResponseDto> patchReview (PatchReviewRequestDto dto);
    ResponseEntity<ResponseDto> postReview (PostReviewRequestDto dto);

    // 식당 찜
    ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList();

}
