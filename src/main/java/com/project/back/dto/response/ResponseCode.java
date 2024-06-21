package com.project.back.dto.response;

public interface ResponseCode {
    String SUCCESS = "SU"; 
    String VALIDATION_FAILED = "VF"; 
    String DUPLICATED_EMAILID = "DE"; 
    String DUPLICATED_NICKNAME = "DN"; 
    String DUPLICATED_BUSINESS_REGISTRATION_NUMBER = "DR";
    String NO_EXIST_RESTAURANT = "NR"; 
    String NO_EXIST_RESERVATION = "NR";
    String NO_EXIST_REVIEW = "NR";
    String NO_EXIST_NOTICE_BOARD = "NN";
    String NO_EXIST_INQUIRY_BOARD = "NI";
    String WRITTEN_COMMENT = "WC";
    String SIGN_IN_FAILED = "SF";
    String AUTHENTICATION_FAILED = "AF"; 
    String AUTHORIZATION_FAILED = "AF"; 
    String NOT_FOUND_USER = "NU";
    String AUTH_NUMBER_SEND_FAILED = "SF";
    String TOKEN_CREATION_FAILED = "TF"; 
    String DATABASE_ERROR = "DBE";
}

