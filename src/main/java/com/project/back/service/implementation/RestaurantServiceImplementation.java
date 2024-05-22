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
import com.project.back.entity.ReservationEntity;
import com.project.back.entity.RestaurantEntity;
import com.project.back.repository.FavoriteRestaurantRepository;
import com.project.back.repository.ReservationRepository;
import com.project.back.repository.RestaurantRepository;
import com.project.back.repository.ReviewRepository;
import com.project.back.repository.UserRepository;

import com.project.back.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImplementation implements RestaurantService{
    private final RestaurantRepository restaurantRepository;
    private final ReservationRepository reservationRepository;
    private final FavoriteRestaurantRepository favoriteRestaurantRepository;
    private final ReviewRepository reviewRepository;
    
    private final UserRepository userRepository;

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
            if ( restaurantEntity == null ) return ResponseDto.noExistRestaurant();

            String writerId = restaurantEntity.getRestaurantWriterId();
            boolean isWriter = userEmailId.equals(writerId);
            if (!isWriter) return ResponseDto.authorizationFailed();

            restaurantEntity.updateRestaurantInfo(dto);
            restaurantRepository.save(restaurantEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postRestaurantInfo(PostRestaurantInfoRequestDto dto, String restaurantWriterId ) {
        try {
            boolean isExistUser = restaurantRepository.existsByRestaurantWriterId(restaurantWriterId);
            if (!isExistUser) return ResponseDto.authenticationFailed();

            RestaurantEntity restaurantEntity = new RestaurantEntity(dto);
            restaurantRepository.save(restaurantEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetReservationResponseDto> getReservation(int reservationNumber) {
        try {
            ReservationEntity reservationEntity = reservationRepository.findByReservationNumber(reservationNumber);
            if (reservationEntity == null) return ResponseDto.noExistReservation();

            return GetReservationResponseDto.success();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    @Override
    public ResponseEntity<? super GetReservationListResponseDto> getReservationList() {
        try {
            List<ReservationEntity> reservationEntities = restaurantRepository.findByOrderByReservationNumberDesc();
            return GetReservationListResponseDto.success();
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
    }

    @Override
    public ResponseEntity<ResponseDto> deleteReservation(DeleteReservationRequestDto dto, String restaurantId, int reservationNumber) {
        try {
            ReservationEntity reservationEntity = reservationRepository.findByReservationNumber(reservationNumber);
            if (reservationEntity == null) return ResponseDto.noExistReservation();

            String writerId = reservationEntity.getReservationUserId();
            boolean isWriter = restaurantId.equals(writerId);
            if (!isWriter) return ResponseDto.authorizationFailed();
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postReservation(PostReservationRequestDto dto, String restaurantId) {
        try {
            boolean isExistUser = userRepository.existsByUserEmailId(restaurantId);
            if (!isExistUser) return ResponseDto.authenticationFailed();

            ReservationEntity reservationEntity = new ReservationEntity();
            reservationRepository.save(reservationEntity);

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
