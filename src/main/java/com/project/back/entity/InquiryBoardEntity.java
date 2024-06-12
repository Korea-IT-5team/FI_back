package com.project.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.project.back.dto.request.board.inquiryboard.PatchInquiryBoardRequestDto;
import com.project.back.dto.request.board.inquiryboard.PostInquiryBoardRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String inquiryWriterId;
    private String inquiryTitle;
    private String inquiryContents;
    private String inquiryWriteDatetime;
    private String inquiryComment;

    public InquiryBoardEntity(PostInquiryBoardRequestDto dto, String userEmailId) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String inquiryWriteDatetime = simpleDateFormat.format(now);

        this.status = false;
        this.inquiryPublic = dto.getInquiryPublic();
        this.inquiryTitle = dto.getInquiryTitle();
        this.inquiryContents = dto.getInquiryContents();
        this.inquiryWriterId = userEmailId;
        this.inquiryWriteDatetime = inquiryWriteDatetime;
    }

    public void update(PatchInquiryBoardRequestDto dto) {
        this.inquiryTitle = dto.getInquiryTitle();
        this.inquiryContents = dto.getInquiryContents();
    }
}
