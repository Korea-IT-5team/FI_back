package com.project.back.entity;

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
    private String favoriteUserId; 
    private Integer favoriteRestaurantId;

    public FavoriteRestaurantEntity(String userEmailId, int restaurantId) {
        this.favoriteUserId = userEmailId;
        this.favoriteRestaurantId = restaurantId;
    }
}
//수정