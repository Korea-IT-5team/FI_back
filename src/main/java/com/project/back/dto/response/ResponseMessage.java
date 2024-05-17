package com.project.back.dto.response;

// 200 : SU/success.
// 400 필수 데이터 미입력(데이터 유효성 검사 실패): VF / Validation Failed.
// 400 중복된 이메일: DE/Duplicatied Email.
// 400 중복된 닉네임: DN/Duplicatied Nickname.
// 400 존재하지 않는 식당:  NR/No_Exist_Restaurant.
// 400 존재하지 않는 게시물 : NB/No_Exist_InquiryBoard.
// 400 이미 작성된 답글 : WC/Written Comment.
// 401 로그인 정보 불일치: SF/Sign in Failed.
// 401 인증 실패: AF / Authentication Failed.
// 403 인가 실패 : AF / Authorization Failed.
// 404 사용자 정보 불일치 : NF / User not found.
// 500 토큰 생성 실패:TF/Token creation Failed.
// 500 인증 번호 전송 실패: SF/Auth Number Send Failed.
// 500 재설정 링크 전송 실패 : SF/Reset Link Send Failed.
// 500 데이터베이스오류: DBE/Database Error.

// Response의 공통된 Message 값
public interface ResponseMessage 
{
    String SUCCESS = "success."; 
    String VALIDATION_FAILED ="Validation Failed."; 
    String DUPLICATED_EMAILID="Duplicatied Email."; 
    String DUPLICATED_NICKNAME="Duplicatied Nickname."; 
    String WRITTEN_COMMENT = "Written Comment.";
    String SIGN_IN_FAILED="Sign in Failed."; 
    String AUTHENTICATION_FAILED="Authentication Failed."; 
    String AUTHORIZATION_FAILED = "Authorization Failed."; 
    String USER_NOT_FOUND="User not found."; 
    String TOKEN_CREATION_FAILED="Token creation Failed."; 
    String DATABASE_ERROR="Database Error."; 
    String AUTH_NUMBER_SEND_FAILED="Auth Number Send Failed.";
    String RESET_LINK_SEND_FAILED = "Reset Link Send Failed.";
    String NO_EXIST_RESTAURANT = "No_Exist_Restaurant."; 
    String NO_EXIST_INQUIRYBOARD = "No_Exist_InquiryBoard.";
}
