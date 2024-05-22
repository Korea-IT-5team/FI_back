package com.project.back.common.object.board.noticeboard;

import java.util.ArrayList;
import java.util.List;

import com.project.back.common.util.ChangeDateFormatUtil;
import com.project.back.entity.NoticeBoardEntity;

import lombok.Getter;

@Getter
public class NoticeBoardListItem {
    private Integer noticeNumber;
    private String noticeTitle;
    private String noticeWriteId;
    private String noticeWriteDatetime;
    private Integer noticeViewCount;

    private NoticeBoardListItem(NoticeBoardEntity noticeBoardEntity) throws Exception {
        this.noticeNumber=noticeBoardEntity.getNoticeNumber();
        this.noticeTitle=noticeBoardEntity.getNoticeTitle();

        String writerId = noticeBoardEntity.getNoticeWriterId();
        writerId = writerId.substring(0, 1)+
        "*".repeat(writerId.length()-1); 
        this.noticeWriteId=writerId;

        String writeDate  = ChangeDateFormatUtil.changeYYMMDD(noticeBoardEntity.getNoticeWriteDatetime());
        this.noticeWriteDatetime = writeDate;

        this.noticeViewCount=noticeBoardEntity.getNoticeViewCount();
    }

    public static List<NoticeBoardListItem> getList(List<NoticeBoardEntity> noticeBoardEntities) throws Exception {
        List<NoticeBoardListItem> noticeBoardList = new ArrayList<>();

        for(NoticeBoardEntity noticeBoardEntity :noticeBoardEntities) {
            NoticeBoardListItem noticeBoardListItem = new NoticeBoardListItem(noticeBoardEntity);
            noticeBoardList.add(noticeBoardListItem);
        }
        return noticeBoardList;
    }
}
