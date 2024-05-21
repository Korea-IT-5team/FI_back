package com.project.back.service.implementation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.back.provider.SmsProvider;
import com.project.back.service.SmsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SmsServiceImplementation implements SmsService {
  private final SmsProvider smsProvider;

  @Override
  public ResponseEntity<String> sendSms(String to) {

    try {
      boolean result = smsProvider.sendSms(to);
      if (!result) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("메세지 전송에 실패했습니다.");
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("메세지 전송 중 예외가 발생했습니다.");
    }
    return ResponseEntity.status(HttpStatus.OK).body("메세지 전송에 성공했습니다.");
  }
  
}
