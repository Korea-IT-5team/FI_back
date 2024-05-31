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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.project.back.service.RestaurantService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;
    
    @GetMapping("/search")
    public ResponseEntity<? super GetRestaurantListResponseDto> getRestaurantList ( 
        @RequestParam("word") String word
    ){
        ResponseEntity<? super GetRestaurantListResponseDto> response = restaurantService.getRestaurantList(word);
        return response;
    };
   
    @GetMapping("/{restaurantId}")
    public ResponseEntity<? super GetRestaurantInfoResponseDto> getRestaurantInfo (
        @PathVariable("restaurantId") int restaurantId
    ){
        ResponseEntity<? super GetRestaurantInfoResponseDto>  response = restaurantService.getRestaurantInfo(restaurantId);
        return response;
    };
    
    
    @PostMapping("/info-upload")
    public ResponseEntity<ResponseDto> postRestaurantInfo (
        @RequestBody @Valid PostRestaurantInfoRequestDto requestBody,
        @AuthenticationPrincipal String userEmailId 
    ) {
        ResponseEntity<ResponseDto> response = restaurantService.postRestaurantInfo(requestBody, userEmailId);
        return response;
    };
    
    //###수정
    @PatchMapping("/{restaurantId}/info-update")
    public ResponseEntity<ResponseDto> patchRestaurantInfo (
        @RequestBody @Valid PatchRestaurantInfoRequestDto requestBody,
        @PathVariable("restaurantId") int restaurantId,
        @AuthenticationPrincipal String userEmailId
    ) {
        ResponseEntity<ResponseDto> response = restaurantService.patchRestaurantInfo(requestBody, restaurantId, userEmailId);
        return response;
    };
    //###수정
    
    //###수정
    @GetMapping("/reservation/list")
    public ResponseEntity<? super GetReservationListResponseDto> getUserReservationList  (
        @AuthenticationPrincipal String userEmailId
    )
    {
        ResponseEntity<? super GetReservationListResponseDto> response = restaurantService.getUserReservationList(userEmailId);
        return response;
    };
    //###수정

    //###수정
    @GetMapping("/reservation/ceo-list")
    public ResponseEntity<? super GetReservationListResponseDto> getCeoReservationList (
        @AuthenticationPrincipal String userEmailId
    )
    {
        ResponseEntity<? super GetReservationListResponseDto> response = restaurantService.getCeoReservationList(userEmailId);
        return response;
    }
    //###수정
    
    @PostMapping("/reservation/{restaurantId}")
    public ResponseEntity<ResponseDto> postReservation(
        @RequestBody @Valid PostReservationRequestDto requestBody,
        @AuthenticationPrincipal String userEmailId,
        @PathVariable("restaurantId") int restaurantId
    ) {
        ResponseEntity<ResponseDto> response = restaurantService.postReservation(requestBody, userEmailId, restaurantId);
        return response;
    };


    @GetMapping("/reservation/{restaurantId}")
    public ResponseEntity<ResponseDto> getReservationCheck(
        @AuthenticationPrincipal String userEmailId,
        @PathVariable("restaurantId") int restaurantId
    ) {
        ResponseEntity<ResponseDto> response = restaurantService.getReservationCheck(userEmailId, restaurantId);
        return response;
    };
    
    @DeleteMapping("/reservation/{restaurantId}")
    public ResponseEntity<ResponseDto> deleteReservation (
        @PathVariable("restaurantId") int restaurantId, 
        @AuthenticationPrincipal String userEmailId
    ){
        ResponseEntity<ResponseDto> response = restaurantService.deleteReservation(userEmailId, restaurantId);
        return response;
    };

    //###수정
    @GetMapping("/review/{reviewNumber}")
    public ResponseEntity<? super GetReviewResponseDto> getReview (
        @PathVariable("reviewNumber") int reviewNumber
    ) {
        ResponseEntity<? super GetReviewResponseDto> response = restaurantService.getReview(reviewNumber);
        return response;
    }
    //###수정
    
    //###수정
    @PostMapping("/review/write/{restaurantId}")
    public ResponseEntity<ResponseDto> postReview (
        @RequestBody @Valid PostReviewRequestDto requestBody, 
        @PathVariable("restaurantId") int restaurantId,
        @AuthenticationPrincipal String userEmailId
    ) {
        ResponseEntity<ResponseDto> response = restaurantService.postReview(requestBody, restaurantId, userEmailId);
        return response;
    }
    //###수정
    
    //###수정
    @PatchMapping("/review/update/{reviewNumber}")
    public ResponseEntity<ResponseDto> patchReview (
        @RequestBody @Valid PatchReviewRequestDto requestBody,
        @PathVariable("reviewNumber") int reviewNumber,
        @AuthenticationPrincipal String userEmailId
    ){
        ResponseEntity<ResponseDto> response = restaurantService.patchReview(requestBody, reviewNumber, userEmailId);
        return response;
    }
    //###수정
    
    //###수정
    @DeleteMapping("/review/delete/{reviewNumber}")
    public ResponseEntity<ResponseDto> deleteReview (
        @PathVariable("reviewNumber") int reviewNumber,
        @AuthenticationPrincipal String userEmailId
    ){
        ResponseEntity<ResponseDto> response = restaurantService.deleteReview(reviewNumber, userEmailId);
        return response;
    }
    //###수정
    
    //###수정
    @GetMapping("/review/list")
    public ResponseEntity<? super GetReviewListResponseDto> getMyReviewList (String userEmailId) {
        ResponseEntity<? super GetReviewListResponseDto> response = restaurantService.getMyReviewList(userEmailId);
        return response;
    }
    //###수정
    
   
    @PostMapping("favorite/restaurantId")
    public ResponseEntity<ResponseDto> postFavorite (
        @PathVariable("restaurantId") int restaurantId,
        @AuthenticationPrincipal String userEmailId
    ){
        ResponseEntity<ResponseDto> response = restaurantService.postFavorite(userEmailId, restaurantId);
        return response;
    }
   

    
    @DeleteMapping("favorite/restaurantId")
    public ResponseEntity<ResponseDto> deleteFavorite (
         @PathVariable("restaurantId") int restaurantId,
         @AuthenticationPrincipal String userEmailId
    ){
         ResponseEntity<ResponseDto> response = restaurantService.deleteFavorite(userEmailId, restaurantId);
         return response;
    }
   
 

    
    @GetMapping("favorite/restaurantId")
    public ResponseEntity<ResponseDto> getFavoriteCheck (
        @PathVariable("restaurantId") int restaurantId,
        @AuthenticationPrincipal String userEmailId
    ){
        ResponseEntity<ResponseDto> response = restaurantService.getFavoriteCheck(userEmailId, restaurantId);
        return response;
    }
  
    //수정###
    @GetMapping("favorite/list")
    public ResponseEntity<? super GetFavoriteRestaurantListResponseDto> getFavoriteList (
        @AuthenticationPrincipal String userEmailId
    )
    {
        ResponseEntity<? super GetFavoriteRestaurantListResponseDto> response = restaurantService.getFavoriteList(userEmailId);
        return response;
    }
    //수정###
}
//수정###
