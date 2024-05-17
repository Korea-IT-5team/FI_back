package com.project.back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// project 데이터베이스의 Favorite_Restaurant테이블과 매핑되는 Entity 클래스
@Entity(name="Favorite_Restaurant")
@Table(name="Favorite_Restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteRestaurantEntity 
{
    private String favoriteUserId; 
    private Integer favoriteRestaurantId; 
    private Integer favoriteCount;
}
