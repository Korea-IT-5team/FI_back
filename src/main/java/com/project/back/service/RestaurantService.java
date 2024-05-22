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
import com.project.back.dto.response.restaurant.favorite.PostFavoriteListResponseDto;
import com.project.back.dto.response.restaurant.reservation.GetReservationListResponseDto;
import com.project.back.dto.response.restaurant.reservation.GetReservationResponseDto;

public interface RestaurantService {
    // 식당 정보
    ResponseEntity<? super GetRestaurantListResponseDto> getRestaurantList(String searchWord);
    ResponseEntity<? super GetRestaurantInfoResponseDto> getRestaurantInfo(int restaurantId);
    ResponseEntity<ResponseDto> postRestaurantInfo(PostRestaurantInfoRequestDto dto, String userEmailId);
    ResponseEntity<ResponseDto> patchRestaurantInfo(PatchRestaurantInfoRequestDto dto, int restaurantId, String userEmailId);
    

    // 식당 예약
    ResponseEntity<? super GetReservationResponseDto> getReservation(int reservationNumber);
    ResponseEntity<? super GetReservationListResponseDto> getReservationList();
    ResponseEntity<ResponseDto> postReservation (PostReservationRequestDto dto, String restaurantId);
    ResponseEntity<ResponseDto> deleteReservation(DeleteReservationRequestDto dto, String restaurantId,int reservationNumber);
    
    
    // 식당 리뷰
    ResponseEntity<ResponseDto> postReview (PostReviewRequestDto dto, String restaurantId ,String userEmailId);
    ResponseEntity<ResponseDto> patchReview (PatchReviewRequestDto dto, int reviewNumber, String userEmailId);
    ResponseEntity<ResponseDto> deleteReview (int reviewRestaurantId, String userEmailId);

    // 식당 찜
    ResponseEntity<? super PostFavoriteListResponseDto> postFavorite(String userEmailId, String restaurantId);
    ResponseEntity<? super PostFavoriteListResponseDto> postFavoriteList();
    ResponseEntity<ResponseDto> increaseFavoriteCount();

}
