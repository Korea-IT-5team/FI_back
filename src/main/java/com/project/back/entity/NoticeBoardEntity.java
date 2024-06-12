package com.project.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.project.back.dto.request.board.noticeboard.PatchNoticeBoardRequestDto;
import com.project.back.dto.request.board.noticeboard.PostNoticeBoardRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="noticeBoard")
@Table(name="notice_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeBoardEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer noticeNumber;
    private String noticeTitle;
    private String noticeWriterId;
    private String noticeWriterNickname;
    private String noticeWriteDatetime;
    private String noticeContents;
    private Integer viewCount;

    public NoticeBoardEntity(PostNoticeBoardRequestDto dto, String userEmailId) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String noticeWriteDatetime = simpleDateFormat.format(now);

        this.noticeTitle = dto.getNoticeTitle();
        this.noticeContents = dto.getNoticeContents();
        this.noticeWriterId = userEmailId;
        this.noticeWriteDatetime = noticeWriteDatetime;
        this.viewCount = 0;
    }

    public void increaseViewCount() {
        this.viewCount++;
    }

    public void update(PatchNoticeBoardRequestDto dto) {
        this.noticeTitle = dto.getNoticeTitle();
        this.noticeContents = dto.getNoticeContents();
    }    
}
