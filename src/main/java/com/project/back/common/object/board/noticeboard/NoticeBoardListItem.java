package com.project.back.common.object.board.noticeboard;

import java.util.ArrayList;
import java.util.List;

import com.project.back.common.util.ChangeDateFormatUtil;
import com.project.back.repository.resultSet.GetNoticeBoardListResultSet;

import lombok.Getter;

@Getter
public class NoticeBoardListItem {
    private Integer noticeNumber;
    private String noticeTitle;
    private String noticeWriterNickname;
    private String noticeWriteDatetime;
    private Integer viewCount;

    private NoticeBoardListItem(GetNoticeBoardListResultSet resultSets) throws Exception {
        this.noticeNumber = resultSets.getNoticeNumber();
        this.noticeTitle = resultSets.getNoticeTitle();
        this.noticeWriterNickname = resultSets.getNoticeWriterNickname();

        String writeDate = ChangeDateFormatUtil.changeYYMMDD(resultSets.getNoticeWriteDatetime());
        this.noticeWriteDatetime = writeDate;

        this.viewCount = resultSet.getViewCount();
    }

    public static List<NoticeBoardListItem> getList(List<GetNoticeBoardListResultSet> resultSets) throws Exception {
        List<NoticeBoardListItem> noticeBoardList = new ArrayList<>();

        for(GetNoticeBoardListResultSet resultSet :resultSets) {
            NoticeBoardListItem noticeBoardListItem = new NoticeBoardListItem(resultSet);
            noticeBoardList.add(noticeBoardListItem);
        }
        return noticeBoardList;
    }
}
