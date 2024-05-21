package com.project.back.service.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
import com.project.back.entity.RestaurantEntity;
import com.project.back.repository.FavoriteRestaurantRepository;
import com.project.back.repository.ReservationRepository;
import com.project.back.repository.RestaurantRepository;
import com.project.back.repository.ReviewRepository;
import com.project.back.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImplementation implements RestaurantService{
    private final RestaurantRepository restaurantRepository;
    private final ReservationRepository reservationRepository;
    private final FavoriteRestaurantRepository favoriteRestaurantRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public ResponseEntity<? super GetRestaurantInfoResponseDto> getRestaurantInfo(int restaurantId) {
        try {
            RestaurantEntity restaurantEntity = restaurantRepository.findByRestaurantId(restaurantId);
            if (restaurantEntity == null) return ResponseDto.noExistRestaurant();
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetRestaurantListResponseDto> getRestaurantList(String searchWord) {
        try {

            List<RestaurantEntity> restaurantEntities = restaurantRepository.findByOrderByRestaurantIdDesc();
            return GetRestaurantListResponseDto.success(restaurantEntities);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
    }

    @Override
    public ResponseEntity<ResponseDto> patchRestaurantInfo(PatchRestaurantInfoRequestDto dto, int restaurantId, String userEmailId) {
        try {

            RestaurantEntity restaurantEntity = restaurantRepository.findByRestaurantId(restaurantId);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postRestaurantInfo(PostRestaurantInfoRequestDto dto) {
        try {

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetReservationResponseDto> getReservation() {
        try {

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetReservationListResponseDto> getReservationList() {
        try {

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteReservation(DeleteReservationRequestDto dto, String restaurantId) {
        try {

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postReservation(PostReservationRequestDto dto) {
        try {

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> patchReview(PatchReviewRequestDto dto) {
        try {

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postReview(PostReviewRequestDto dto) {
        try {

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList() {
        try {

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

}
