package com.project.back.entity;

import java.util.Date;
import java.time.Instant;
import java.text.SimpleDateFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import com.project.back.dto.request.board.inquiryboard.PostInquiryBoardRequestDto;
import com.project.back.common.util.ChangeDateFormatUtil;
import com.project.back.dto.request.board.inquiryboard.PatchInquiryBoardRequestDto;

@Entity(name="inquiryBoard")
@Table(name="inquiry_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryBoardEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer inquiryNumber;
    private Boolean status;
    private Boolean inquiryPublic;
    private String inquiryTitle;
    private String inquiryComment;
    private String inquiryWriterId;
    private String inquiryContents;
    private String inquiryWriteDatetime;

    public InquiryBoardEntity(PostInquiryBoardRequestDto dto, String userEmailId) {
        // Date now = Date.from(Instant.now());
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String inquiryWriteDatetime = simpleDateFormat.format(now);

        String dateNow = ChangeDateFormatUtil.nowYYYYMMDD();
        this.inquiryWriteDatetime = dateNow;
    

        this.status = false;
        this.inquiryWriterId = userEmailId;
        
        this.inquiryTitle = dto.getInquiryTitle();
        this.inquiryPublic = dto.getInquiryPublic();
        this.inquiryContents = dto.getInquiryContents();
    }

    public void update(PatchInquiryBoardRequestDto dto) {
        this.inquiryTitle = dto.getInquiryTitle();
        this.inquiryContents = dto.getInquiryContents();
    }
}
