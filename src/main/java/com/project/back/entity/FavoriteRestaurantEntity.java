package com.project.back.entity;

import com.project.back.dto.response.restaurant.favorite.PostFavoriteListResponseDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="favoriteRestaurant")
@Table(name="Favorite_Restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteRestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String favoriteUserId; 
    private Integer favoriteRestaurantId; 
    private Integer favoriteCount;

    public FavoriteRestaurantEntity(PostFavoriteListResponseDto dto) {
        this.favoriteUserId = dto.getFavoriteUserId();
        this.favoriteRestaurantId = dto.getFavoriteRestaurantId();
        this.favoriteCount = 0;
    }

    public void increaseFavoriteCount() {
        this.favoriteCount++;
    }
    
}
