package com.project.back.common.object.restaurant;

import java.util.ArrayList;
import java.util.List;

import com.project.back.common.util.ChangeDateFormatUtil;
import com.project.back.repository.resultSet.GetRestaurantReviewListItemResultSet;

import lombok.Getter;

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

    private RestaurantReviewListItem(GetRestaurantReviewListItemResultSet getRestaurantReviewListItemResultSet) throws Exception
    {
       this.reviewNumber=getRestaurantReviewListItemResultSet.getReviewNumber();
       this.reviewRestaurantId=getRestaurantReviewListItemResultSet.getReviewRestaurantId();
       this.reviewImage=getRestaurantReviewListItemResultSet.getReviewImage();
       this.rating=getRestaurantReviewListItemResultSet.getRating();
       this.reviewContents=getRestaurantReviewListItemResultSet.getReviewContents();

       String writerId = getRestaurantReviewListItemResultSet.getReviewWriterId();
        writerId = writerId.substring(0, 1)+
        "*".repeat(writerId.length()-1); 

       this.reviewWriterId=writerId;
       this.reviewWriterNickname=getRestaurantReviewListItemResultSet.getNickname(); 
       
       String writeDatetime  = ChangeDateFormatUtil.changeYYMMDD(getRestaurantReviewListItemResultSet.getReviewDate());
       this.reviewDate = writeDatetime;
    }

    public static List<RestaurantReviewListItem> getList(List<GetRestaurantReviewListItemResultSet> getRestaurantReviewListItemResultSetList) throws Exception
    {
        List<RestaurantReviewListItem> restaurantReviewList = new ArrayList<>();

        for(GetRestaurantReviewListItemResultSet getRestaurantReviewListItemResultSet:getRestaurantReviewListItemResultSetList)
        {
            RestaurantReviewListItem restaurantReviewListItem = new RestaurantReviewListItem(getRestaurantReviewListItemResultSet);
            restaurantReviewList.add(restaurantReviewListItem);
        }

        return restaurantReviewList;
    }
}