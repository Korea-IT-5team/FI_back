package com.project.back.service.implementation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.back.dto.request.restaurant.PatchRestaurantInfoRequestDto;
import com.project.back.dto.request.restaurant.PostRestaurantInfoRequestDto;
import com.project.back.dto.request.restaurant.reservation.PostReservationRequestDto;
import com.project.back.dto.request.restaurant.review.PatchReviewRequestDto;
import com.project.back.dto.request.restaurant.review.PostReviewRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.restaurant.GetRestaurantInfoResponseDto;
import com.project.back.dto.response.restaurant.GetRestaurantListResponseDto;
import com.project.back.dto.response.restaurant.favorite.GetFavoriteRestaurantListResponseDto;
import com.project.back.dto.response.restaurant.reservation.GetReservationListResponseDto;
import com.project.back.dto.response.restaurant.review.GetReviewListResponseDto;
import com.project.back.dto.response.restaurant.review.GetReviewResponseDto;
import com.project.back.entity.FavoriteRestaurantEntity;
import com.project.back.entity.ReservationEntity;
import com.project.back.entity.RestaurantEntity;
import com.project.back.entity.ReviewEntity;
import com.project.back.entity.UserEntity;
import com.project.back.repository.FavoriteRestaurantRepository;
import com.project.back.repository.ReservationRepository;
import com.project.back.repository.RestaurantRepository;
import com.project.back.repository.ReviewRepository;
import com.project.back.repository.UserRepository;
import com.project.back.repository.resultSet.GetRestaurantFavoriteItemResultSet;
import com.project.back.repository.resultSet.GetRestaurantReviewListItemResultSet;
import com.project.back.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImplementation implements RestaurantService
{
    private final RestaurantRepository restaurantRepository;
    private final ReservationRepository reservationRepository;
    private final FavoriteRestaurantRepository favoriteRestaurantRepository;
    private final ReviewRepository reviewRepository;
    
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetRestaurantListResponseDto> getRestaurantList(String searchWord) {
        try {
            List<RestaurantEntity> restaurantEntities = restaurantRepository.findByRestaurantNameContainingOrderByRestaurantIdDesc(searchWord);
            return GetRestaurantListResponseDto.success(restaurantEntities);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
    }

    @Override
    public ResponseEntity<? super GetRestaurantInfoResponseDto> getRestaurantInfo(int restaurantId) {
        try {
            RestaurantEntity restaurantEntity = restaurantRepository.findByRestaurantId(restaurantId);
            List<GetRestaurantReviewListItemResultSet> reviewEntities = reviewRepository.findReviewsByRestaurantId(restaurantId);
            if (restaurantEntity == null) return ResponseDto.noExistRestaurant();

            return GetRestaurantInfoResponseDto.success(restaurantEntity, reviewEntities);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
    
    @Override
    public ResponseEntity<ResponseDto> postRestaurantInfo(PostRestaurantInfoRequestDto dto, String userEmailId) {
        try {
            boolean isExistUser = userRepository.existsByUserEmailId(userEmailId);
            if (!isExistUser) return ResponseDto.authenticationFailed();

            RestaurantEntity restaurantEntity = new RestaurantEntity(dto, userEmailId);
            restaurantRepository.save(restaurantEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> patchRestaurantInfo(PatchRestaurantInfoRequestDto dto, int restaurantId, String userEmailId) {
        try {
            RestaurantEntity restaurantEntity = restaurantRepository.findByRestaurantId(restaurantId);
            if (restaurantEntity == null) return ResponseDto.noExistRestaurant();

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
    public ResponseEntity<? super GetReservationListResponseDto> getUserReservationList(String userEmailId) {
        try {
            List<ReservationEntity> reservationEntities = reservationRepository.findByReservationUserIdOrderByReservationNumberDesc(userEmailId);
            return GetReservationListResponseDto.success(reservationEntities);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
    
    @Override
    public ResponseEntity<? super GetReservationListResponseDto> getCeoReservationList(String userEmailId) {
        try {

            Integer restaurantId = restaurantRepository.getRestaurantIdByRestaurantWriterId(userEmailId);
            if(restaurantId == null) return ResponseDto.authorizationFailed();
            List<ReservationEntity> reservationEntities = reservationRepository.findByReservationRestaurantIdOrderByReservationNumberDesc(restaurantId);
            return GetReservationListResponseDto.success(reservationEntities);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    
    
    @Override
    public ResponseEntity<ResponseDto> postReservation(PostReservationRequestDto dto, String userEmailId, int restaurantId) {
        try {
            boolean isExistUser = userRepository.existsByUserEmailId(userEmailId);
            if (!isExistUser) return ResponseDto.noExistUser();
            UserEntity userEntity = userRepository.findByUserEmailId(userEmailId);
            String userName = userEntity.getUserName();
            String userTelNumber = userEntity.getUserTelNumber();

            boolean isExistRestaurant = restaurantRepository.existsByRestaurantId(restaurantId);
            if (!isExistRestaurant) return ResponseDto.noExistReservation();
            RestaurantEntity restaurantEntity = restaurantRepository.findByRestaurantId(restaurantId);
            String restaurantName = restaurantEntity.getRestaurantName();
            String restaurantLocation = restaurantEntity.getRestaurantLocation();

            ReservationEntity reservationEntity = new ReservationEntity(
                dto,userEmailId,restaurantId,userName,restaurantName,restaurantLocation,userTelNumber);
            reservationRepository.save(reservationEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
    
    @Override
    public ResponseEntity<ResponseDto> getReservationCheck(String userEmailId, int restaurantId) {
        {
            try {
                boolean isReservationStatus = reservationRepository.existsByReservationUserIdAndReservationRestaurantId(userEmailId,restaurantId);
                if(!isReservationStatus) return ResponseDto.noExistUser();
                return ResponseDto.success();
            } catch (Exception exception) {
                exception.printStackTrace();
                return ResponseDto.databaseError();
            }
        }
    }
    

    @Override
    public ResponseEntity<ResponseDto> deleteReservation(String userEmailId, int restaurantId) {
        try {
            boolean isExistUser = userRepository.existsByUserEmailId(userEmailId);
            if (!isExistUser) return ResponseDto.noExistUser();

            boolean isExistRestaurant = restaurantRepository.existsByRestaurantId(restaurantId);
            if (!isExistRestaurant) return ResponseDto.noExistRestaurant();

            ReservationEntity reservationEntity = 
            reservationRepository.findByReservationUserIdAndReservationRestaurantId(userEmailId, restaurantId);
            if (reservationEntity == null) return ResponseDto.authorizationFailed();
            reservationRepository.delete(reservationEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

   
    @Override
    public ResponseEntity<? super GetReviewResponseDto> getReview(int reviewNumber) {
        try {
            ReviewEntity reviewEntity = reviewRepository.findByReviewNumber(reviewNumber);
            if (reviewEntity == null) return ResponseDto.noExistReview();

            return GetReviewResponseDto.success(reviewEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
   
    @Override
    public ResponseEntity<ResponseDto> postReview(PostReviewRequestDto dto, int restaurantId, String userEmailId) {
        try {
            boolean isExistUser = userRepository.existsByUserEmailId(userEmailId);
            if (!isExistUser) return ResponseDto.authorizationFailed();
            UserEntity user = userRepository.findByUserEmailId(userEmailId);
            String reviewWriterNickname = user.getNickname();

            ReviewEntity reviewEntity = new ReviewEntity(dto, userEmailId, restaurantId,reviewWriterNickname);
            reviewRepository.save(reviewEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
   
    @Override
    public ResponseEntity<ResponseDto> patchReview(PatchReviewRequestDto dto, int reviewNumber, String userEmailId) {
        try {
            ReviewEntity reviewEntity = reviewRepository.findByReviewNumber(reviewNumber);
            if (reviewEntity == null) return ResponseDto.noExistReview();

            String writerId = reviewEntity.getReviewWriterId();
            boolean isWriter = userEmailId.equals(writerId);
            if (!isWriter) return ResponseDto.authorizationFailed();

            reviewEntity.updateReview(dto);
            reviewRepository.save(reviewEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
    
    @Override
    public ResponseEntity<ResponseDto> deleteReview(int reviewNumber, String userEmailId) {
        try {
            ReviewEntity reviewEntity = reviewRepository.findByReviewNumber(reviewNumber);
            if (reviewEntity == null) return ResponseDto.noExistReview();

            String writerId = reviewEntity.getReviewWriterId();
            boolean isWriter = userEmailId.equals(writerId);
            if (!isWriter) return ResponseDto.authorizationFailed();

            reviewRepository.delete(reviewEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
   
    @Override
    public ResponseEntity<? super GetReviewListResponseDto> getMyReviewList(String userEmailId) {
        try {
            List<GetRestaurantReviewListItemResultSet> resultSets = reviewRepository.findByOrderByMyReviewListDesc(userEmailId);
            return GetReviewListResponseDto.success(resultSets);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
    

   
    @Override
    public ResponseEntity<ResponseDto> postFavorite(String userEmailId, int restaurantId) {
        try {
            System.out.println("User not found with email: " + userEmailId);
            boolean isExistUser = userRepository.existsByUserEmailId(userEmailId);
            if (!isExistUser) return ResponseDto.noExistUser();

            boolean isExistRestaurant = restaurantRepository.existsByRestaurantId(restaurantId);
            if (!isExistRestaurant) return ResponseDto.noExistReservation();

            FavoriteRestaurantEntity favoriteRestaurantEntity = new FavoriteRestaurantEntity(userEmailId,restaurantId);
            favoriteRestaurantRepository.save(favoriteRestaurantEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
    
    @Override
    public ResponseEntity<ResponseDto> deleteFavorite(String userEmailId, int restaurantId) {
        try {
            boolean isExistUser = userRepository.existsByUserEmailId(userEmailId);
            if (!isExistUser) return ResponseDto.noExistUser();

            boolean isExistRestaurant = restaurantRepository.existsByRestaurantId(restaurantId);
            if (!isExistRestaurant) return ResponseDto.noExistRestaurant();

            FavoriteRestaurantEntity favoriteRestaurantEntity = 
            favoriteRestaurantRepository.findByFavoriteUserIdAndFavoriteRestaurantId(userEmailId, restaurantId);
            if (favoriteRestaurantEntity == null) return ResponseDto.authorizationFailed();
            favoriteRestaurantRepository.delete(favoriteRestaurantEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }
    
    @Override
    public ResponseEntity<? super GetFavoriteRestaurantListResponseDto> getFavoriteList(String userEmailId) {
        try {
            List<GetRestaurantFavoriteItemResultSet> resultSets = restaurantRepository.getFavoriteList(userEmailId);
            return GetFavoriteRestaurantListResponseDto.success(resultSets);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
    
    @Override
    public ResponseEntity<ResponseDto> getFavoriteCheck(String userEmailId, int restaurantId) {
        try {
            boolean isFavoriteStatus = favoriteRestaurantRepository.existsByFavoriteUserIdAndFavoriteRestaurantId(userEmailId,restaurantId);
            if(!isFavoriteStatus) return ResponseDto.noExistUser();
            return ResponseDto.success();
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

}
