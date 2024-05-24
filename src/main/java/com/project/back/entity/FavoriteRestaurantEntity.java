package com.project.back.entity;

import com.project.back.dto.request.restaurant.favorite.PostFavoriteRestaurantRequestDto;

import jakarta.persistence.Entity;
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
    private String favoriteUserEmailId; 
    private Integer favoriteRestaurantId; 
    private Integer favoriteCount;

    public FavoriteRestaurantEntity(PostFavoriteRestaurantRequestDto dto) {
        this.favoriteUserEmailId = dto.getFavoriteUserEmailId();
        this.favoriteRestaurantId = dto.getFavoriteRestaurantId();
        this.favoriteCount = 0;
    }

    public void increaseFavoriteCount() {
        this.favoriteCount++;
    }
    
}
