package com.project.back.common.object.board.inquiryboard;

import java.util.ArrayList;
import java.util.List;

import com.project.back.common.util.ChangeDateFormatUtil;
import com.project.back.entity.InquiryBoardEntity;

public class InquiryBoardListItem 
{
    private Integer inquiryNumber;
    private boolean inquiryStatus;
    private String inquiryTitle;
    private String inquiryWriterId;
    private String inquiryWriteDatetime;

    private InquiryBoardListItem(InquiryBoardEntity inquiryBoardEntity) throws Exception
    {
        this.inquiryNumber=inquiryBoardEntity.getInquiryNumber();
        this.inquiryStatus=inquiryBoardEntity.getInquiryStatus();
        this.inquiryTitle=inquiryBoardEntity.getInquiryTitle();

        String writerId = inquiryBoardEntity.getInquiryWriterId();
        writerId = writerId.substring(0, 1)+
        "*".repeat(writerId.length()-1); 
        this.inquiryWriterId=writerId;

        String writeDate  = ChangeDateFormatUtil.changeYYMMDD(inquiryBoardEntity.getInquiryWriteDatetime());
        this.inquiryWriteDatetime = writeDate;
    }

    public static List<InquiryBoardListItem> getList(List<InquiryBoardEntity> inquiryBoardEntities) throws Exception
    {
        List<InquiryBoardListItem> inquiryBoardList = new ArrayList<>();

        for(InquiryBoardEntity inquiryBoardEntity :inquiryBoardEntities)
        {
            InquiryBoardListItem inquiryBoardListItem = new InquiryBoardListItem(inquiryBoardEntity);
            inquiryBoardList.add(inquiryBoardListItem);
        }

        return inquiryBoardList;
    }
}
