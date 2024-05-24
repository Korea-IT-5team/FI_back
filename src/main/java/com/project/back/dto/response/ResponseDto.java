package com.project.back.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto {
    public static Object favoriteRestaurantEntity;
    private String code;
    private String message;

    // 응답 : 성공
    public static ResponseEntity<ResponseDto> success() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    //응답: 실패 (데이터 유효성 검사 실패)
    public static ResponseEntity<ResponseDto> validationFailed() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.VALIDATION_FAILED,ResponseMessage.VALIDATION_FAILED);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // 응답: 실패 (중복된 이메일)
    public static ResponseEntity<ResponseDto> duplicatedEmailId() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATED_EMAILID,ResponseMessage.DUPLICATED_EMAILID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // 응답: 실패 (중복된 닉네임)
    public static ResponseEntity<ResponseDto> duplicatedNickname() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATED_NICKNAME,ResponseMessage.DUPLICATED_NICKNAME);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // 응답: 실패 (인증 번호 전송 실패)
    public static ResponseEntity<ResponseDto> authNumberSendFailed() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.AUTH_NUMBER_SEND_FAILED,ResponseMessage.AUTH_NUMBER_SEND_FAILED);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    // 응답: 실패 (존재하지 않는 식당)
    public static ResponseEntity<ResponseDto> noExistRestaurant() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.NO_EXIST_RESTAURANT,ResponseMessage.NO_EXIST_RESTAURANT);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // 응답 : 실패 (존재하지 않는 예약내역)
    public static ResponseEntity<ResponseDto> noExistReservation() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.NO_EXIST_RESERVATION,ResponseMessage.NO_EXIST_RESERVATION);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // 응답 : 실패 (존재하지 않는 리뷰내역)
    public static ResponseEntity<ResponseDto> noExistReview() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.NO_EXIST_REVIEW,ResponseMessage.NO_EXIST_REVIEW);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }



    // 응답: 실패 (답변 완료된 게시물) or 응답: 실패 (이미 작성된 답글)
    public static ResponseEntity<ResponseDto> writtenComment() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.WRITTEN_COMMENT ,ResponseMessage.WRITTEN_COMMENT);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // 응답: 실패 (로그인 실패)
    public static ResponseEntity<ResponseDto> signInFailed() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.SIGN_IN_FAILED,ResponseMessage.SIGN_IN_FAILED);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // 응답: 실패 (인증 실패) OR 응답: 실패 (전화번호 인증 실패)
    public static ResponseEntity<ResponseDto> authenticationFailed() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.AUTHENTICATION_FAILED,ResponseMessage.AUTHENTICATION_FAILED);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }

    // 응답: 실패 (인가 실패) or 응답: 실패 (권한 없음)
    public static ResponseEntity<ResponseDto> authorizationFailed() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.AUTHORIZATION_FAILED,ResponseMessage.AUTHORIZATION_FAILED);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseBody);
    }

    // 응답: 실패 (사용자 정보 불일치)
    public static ResponseEntity<ResponseDto> noExistUser() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_FOUND_USER,ResponseMessage.NOT_FOUND_USER);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }

    // 응답: 실패 (토큰 생성 실패)
    public static ResponseEntity<ResponseDto> tokenCreationFailed() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.TOKEN_CREATION_FAILED,ResponseMessage.TOKEN_CREATION_FAILED);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    // 응답: 실패 (재설정 링크 전송 실패)
    public static ResponseEntity<ResponseDto> resetLinkSendFailed() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.RESET_LINK_SEND_FAILED,ResponseMessage.RESET_LINK_SEND_FAILED);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    // 응답: 실패 (존재하지 않는 게시물)
    public static ResponseEntity<ResponseDto> noExistNoticeBoard() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.NO_EXIST_NOTICE_BOARD,ResponseMessage.NO_EXIST_NOTICE_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // 응답: 실패 (존재하지 않는 게시물)
    public static ResponseEntity<ResponseDto> noExistInquiryBoard() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.NO_EXIST_INQUIRY_BOARD,ResponseMessage.NO_EXIST_INQUIRY_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // 응답: 실패 (데이터베이스 에러)
    public static ResponseEntity<ResponseDto> databaseError() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.DATABASE_ERROR,ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}
