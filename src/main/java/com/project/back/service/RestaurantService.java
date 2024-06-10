package com.project.back.service;

import org.springframework.http.ResponseEntity;

import com.project.back.dto.request.restaurant.PatchRestaurantInfoRequestDto;
import com.project.back.dto.request.restaurant.PostRestaurantInfoRequestDto;
import com.project.back.dto.request.restaurant.reservation.PostReservationRequestDto;
import com.project.back.dto.request.restaurant.review.PatchReviewRequestDto;
import com.project.back.dto.request.restaurant.review.PostReviewRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.restaurant.GetRestaurantInfoResponseDto;
import com.project.back.dto.response.restaurant.GetRestaurantListResponseDto;
import com.project.back.dto.response.restaurant.favorite.GetFavoriteCheckResponseDto;
import com.project.back.dto.response.restaurant.favorite.GetFavoriteRestaurantListResponseDto;
import com.project.back.dto.response.restaurant.reservation.GetReservationCheckResponseDto;
import com.project.back.dto.response.restaurant.reservation.GetReservationListResponseDto;
import com.project.back.dto.response.restaurant.review.GetReviewListResponseDto;
import com.project.back.dto.response.restaurant.review.GetReviewResponseDto;

public interface RestaurantService {
    // 식당 정보
    ResponseEntity<? super GetRestaurantListResponseDto> getRestaurantList(String searchWord);
    ResponseEntity<? super GetRestaurantInfoResponseDto> getRestaurantInfo(int restaurantId);

    // ##수정
    ResponseEntity<ResponseDto> postRestaurantInfo(PostRestaurantInfoRequestDto dto, String userEmailId);
    // ##수정

    ResponseEntity<ResponseDto> patchRestaurantInfo(PatchRestaurantInfoRequestDto dto, int restaurantId, String userEmailId);

    // 식당 예약
    ResponseEntity<? super GetReservationListResponseDto> getUserReservationList(String userEmailId);
    ResponseEntity<? super GetReservationListResponseDto> getCeoReservationList(String userEmailId);
    ResponseEntity<ResponseDto> postReservation (PostReservationRequestDto dto, String userEmailId, int restaurantId);
    ResponseEntity<ResponseDto> deleteReservation(String userEmailId, int restaurantId);
    ResponseEntity<? super GetReservationCheckResponseDto> getReservationCheck(String userEmailId, int restaurantId);

    // 식당 리뷰
    ResponseEntity<? super GetReviewResponseDto> getReview (int reviewNumber);
    ResponseEntity<ResponseDto> postReview (PostReviewRequestDto dto, int restaurantId, String userEmailId);
    ResponseEntity<ResponseDto> patchReview (PatchReviewRequestDto dto, int reviewNumber, String userEmailId);
    ResponseEntity<ResponseDto> deleteReview (int reviewNumber, String userEmailId);
    ResponseEntity<? super GetReviewListResponseDto> getMyReviewList (String userEmailId);

    // 식당 찜
    ResponseEntity<ResponseDto> postFavorite(String userEmailId, int restaurantId);
    ResponseEntity<ResponseDto> deleteFavorite(String userEmailId,int restaurantId);
    ResponseEntity<? super GetFavoriteCheckResponseDto> getFavoriteCheck(String userEmailId, int restaurantId);
    ResponseEntity<? super GetFavoriteRestaurantListResponseDto> getFavoriteList(String userEmailId);
}
//수정#