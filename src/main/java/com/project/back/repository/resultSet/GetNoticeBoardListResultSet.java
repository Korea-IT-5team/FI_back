package com.project.back.repository.resultSet;

public interface GetNoticeBoardListResultSet {
  Integer getNoticeNumber();
  String getNoticeTitle();
  String getNoticeWriterNickname();
  String getNoticeWriteDatetime();
  Integer getNoticeViewCount();
}
