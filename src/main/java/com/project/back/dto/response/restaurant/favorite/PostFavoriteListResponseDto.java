package com.project.back.dto.response.restaurant.favorite;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.object.restaurant.RestaurantListItem;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.FavoriteRestaurantEntity;
import com.project.back.entity.RestaurantEntity;

import lombok.Getter;

@Getter
public class PostFavoriteListResponseDto extends ResponseDto{
    private String favoriteUserId;
    private Integer favoriteRestaurantId;
    private List<RestaurantListItem> restaurantList;
    
    private PostFavoriteListResponseDto(FavoriteRestaurantEntity favoriteRestaurantEntity, List<RestaurantEntity> restaurantEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        String writerId = favoriteRestaurantEntity.getFavoriteUserId();
        writerId = writerId.substring(0, 1) +
        "*".repeat(writerId.length() - 1); 
        this.favoriteUserId = writerId;
        this.favoriteRestaurantId = favoriteRestaurantEntity.getFavoriteRestaurantId();
        this.restaurantList = RestaurantListItem.getList(restaurantEntities);
    }

    public static ResponseEntity<PostFavoriteListResponseDto> success(FavoriteRestaurantEntity favoriteRestaurantEntity,List<RestaurantEntity> restaurantEntities)
    throws Exception {
        PostFavoriteListResponseDto responseBody = new PostFavoriteListResponseDto(favoriteRestaurantEntity,restaurantEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
