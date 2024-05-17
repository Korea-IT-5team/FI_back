package com.project.back.common.object;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.DoubleArraySerializer;
import com.project.back.common.util.ChangeDateFormatUtil;
import com.project.back.entity.RestaurantEntity;
import com.project.back.entity.ReviewEntity;
import com.project.back.entity.UserEntity;

import java.time.LocalDateTime;

import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

@Getter
public class RestaurantReviewListItem 
{
    private Integer reviewNumber;
    private Integer reviewRestaurantId;
    private String reviewImage;
    private double rating; 
    private String reviewContents;
    private String reviewWriterId;
    private String reviewWriterNickname;
    private String reviewDate;

    private RestaurantReviewListItem(ReviewEntity reviewEntity) throws Exception
    {
       this.reviewNumber=reviewEntity.getReviewNumber();
       this.reviewRestaurantId=reviewEntity.getReviewRestaurantId();
       this.reviewImage=reviewEntity.getReviewImage();
       this.rating=reviewEntity.getRating();
       this.reviewContents=reviewEntity.getReviewContents();

       String writerId = reviewEntity.getReviewWriterId();
        writerId = writerId.substring(0, 1)+
        "*".repeat(writerId.length()-1); 

       this.reviewWriterId=writerId;
       this.reviewWriterNickname=reviewEntity.; //??
       
       String writeDatetime  = ChangeDateFormatUtil.changeYYYYMMDD(reviewEntity.getReviewDate());
       String reviewDate = writeDatetime;
    }

    public static List<RestaurantReviewListItem> getList(List<ReviewEntity> reviewEntities) throws Exception
    {
        List<ReviewEntity> restaurantReviewList = new ArrayList<>();

        for(ReviewEntity reviewEntity:reviewEntities)
        {
            RestaurantReviewListItem restaurantListItem = new RestaurantReviewListItem(reviewEntity);
            restaurantReviewList.add(restaurantListItem);
        }

        return restaurantReviewList;
    }
}
