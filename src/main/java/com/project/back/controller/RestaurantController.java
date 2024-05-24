package com.project.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.back.dto.request.restaurant.PatchRestaurantInfoRequestDto;
import com.project.back.dto.request.restaurant.PostRestaurantInfoRequestDto;
import com.project.back.dto.request.restaurant.favorite.PostFavoriteRestaurantRequestDto;
import com.project.back.dto.request.restaurant.reservation.DeleteReservationRequestDto;
import com.project.back.dto.request.restaurant.reservation.PostReservationRequestDto;
import com.project.back.dto.request.restaurant.review.PatchReviewRequestDto;
import com.project.back.dto.request.restaurant.review.PostReviewRequestDto;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.restaurant.GetRestaurantInfoResponseDto;
import com.project.back.dto.response.restaurant.GetRestaurantListResponseDto;
import com.project.back.dto.response.restaurant.favorite.GetFavoriteRestaurantListResponseDto;
import com.project.back.dto.response.restaurant.reservation.GetReservationListResponseDto;
import com.project.back.dto.response.restaurant.reservation.GetReservationResponseDto;
import com.project.back.dto.response.restaurant.review.GetReviewListResponseDto;
import com.project.back.dto.response.restaurant.review.GetReviewResponseDto;
import com.project.back.service.RestaurantService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;
    // 1
    @GetMapping("/search")
    public ResponseEntity<? super GetRestaurantListResponseDto> getRestaurantList ( 
        @PathParam("word") String word
    ){
        ResponseEntity<? super GetRestaurantListResponseDto> response = restaurantService.getRestaurantList(word);
        return response;
    };
    // 2
    @GetMapping("/{restaurantId}")
    public ResponseEntity<? super GetRestaurantInfoResponseDto> getRestaurantInfo (
        @PathVariable("restaurantId") int restaurantId
    ){
        ResponseEntity<? super GetRestaurantInfoResponseDto>  response = restaurantService.getRestaurantInfo(restaurantId);
        return response;
    };
    // 3
    @PostMapping("/info-upload")
    public ResponseEntity<ResponseDto> postRestaurantInfo (
        @RequestBody @Valid PostRestaurantInfoRequestDto requestBody,
        @AuthenticationPrincipal String userEmailId 
    ) {
        ResponseEntity<ResponseDto> response = restaurantService.postRestaurantInfo(requestBody, userEmailId);
        return response;
    };
    // 4
    @PatchMapping("/{restaurantId}")
    public ResponseEntity<ResponseDto> patchRestaurantInfo (
        @RequestBody @Valid PatchRestaurantInfoRequestDto requestBody,
        @PathVariable("restaurantId") 
        @AuthenticationPrincipal int restaurantId, String userEmailId
    ) {
        ResponseEntity<ResponseDto> response = restaurantService.patchRestaurantInfo(requestBody, restaurantId, userEmailId);
        return response;
    };
    // 5
    @GetMapping("/reservation/{reservationNumber}")
    public ResponseEntity<? super GetReservationResponseDto> getReservation (
        @PathVariable("reservationNumber") int reservationNumber
    ) {
        ResponseEntity<? super GetReservationResponseDto> response = restaurantService.getReservation(reservationNumber);
        return response;
    };
    // 6
    @GetMapping("/reservation/list")
    public ResponseEntity<? super GetReservationListResponseDto> getUserReservationList (String userEmailId) {
        ResponseEntity<? super GetReservationListResponseDto> response = restaurantService.getUserReservationList(userEmailId);
        return response;
    };
    @GetMapping("/reservation/ceo-list")
    public ResponseEntity<? super GetReservationListResponseDto> getCeoReservationList (int restaurantId) {
        ResponseEntity<? super GetReservationListResponseDto> response = restaurantService.getCeoReservationList(restaurantId);
        return response;
    }
    // 7
    @PostMapping("/reservation/{restaurantId}")
    public ResponseEntity<ResponseDto> postReservation(
        @RequestBody @Valid PostReservationRequestDto requestBody,
        @AuthenticationPrincipal String userEmailId,
        @PathVariable("restaurantId") int restaurantId
    ) {
        ResponseEntity<ResponseDto> response = restaurantService.postReservation(requestBody, userEmailId, restaurantId);
        return response;
    };
    // 8
    @DeleteMapping("/reservation/{restaurantId}")
    public ResponseEntity<ResponseDto> deleteReservation (
        @RequestBody @Valid DeleteReservationRequestDto requestBody,
        @PathVariable("restaurantId") int reservationNumber, 
        @AuthenticationPrincipal String userEmailId
    ){
        ResponseEntity<ResponseDto> response = restaurantService.deleteReservation(null, reservationNumber, userEmailId);
        return response;
    };
    @GetMapping("/review/{reviewNumber}")
    public ResponseEntity<? super GetReviewResponseDto> getReview (
        @PathVariable("reviewNumber") int reviewNumber
    ) {
        ResponseEntity<? super GetReviewResponseDto> response = restaurantService.getReview(reviewNumber);
        return response;
    }
    // 9
    @PostMapping("/review/{restaurantId}")
    public ResponseEntity<ResponseDto> postReview (
        @RequestBody @Valid PostReviewRequestDto requestBody, 
        @PathVariable("restaurantId") int restaurantId, String userEmailId
    ) {
        ResponseEntity<ResponseDto> response = restaurantService.postReview(requestBody, restaurantId, userEmailId);
        return response;
    }
    // 10
    @PatchMapping("/review/{restaurantId}")
    public ResponseEntity<ResponseDto> patchReview (
        @RequestBody @Valid PatchReviewRequestDto requestBody,
        @PathVariable("restaurantId") int restaurantId,
        @AuthenticationPrincipal String userEmailId
    ){
        ResponseEntity<ResponseDto> response = restaurantService.patchReview(requestBody, restaurantId, userEmailId);
        return response;
    }
    // 11
    @DeleteMapping("/review/{reviewNumber}")
    public ResponseEntity<ResponseDto> deleteReview (
        @PathVariable("reviewNumber") int reviewNumber,
        @AuthenticationPrincipal String userEmailId
    ){
        ResponseEntity<ResponseDto> response = restaurantService.deleteReview(reviewNumber, userEmailId);
        return response;
    }
    
    @GetMapping("/review/list")
    public ResponseEntity<? super GetReviewListResponseDto> getMyReviewList (String userEmailId) {
        ResponseEntity<? super GetReviewListResponseDto> response = restaurantService.getMyReviewList(userEmailId);
        return response;
    }
    // 12
    @PostMapping("favorite/restaurantId")
    public ResponseEntity<ResponseDto> postFavorite (
        @RequestBody @Valid PostFavoriteRestaurantRequestDto requestBody,
        @PathVariable("restaurantId") int restaurantId,
        @AuthenticationPrincipal String userEmailId
    ){
        ResponseEntity<ResponseDto> response = restaurantService.postFavorite(requestBody, userEmailId, restaurantId);
        return response;
    }
    // 13
    @GetMapping("favorite/list")
    public ResponseEntity<? super GetFavoriteRestaurantListResponseDto> getFavoriteList (String userEmailId)
    {
        ResponseEntity<? super GetFavoriteRestaurantListResponseDto> response = restaurantService.getFavoriteList(userEmailId);
        return response;
    }
}
