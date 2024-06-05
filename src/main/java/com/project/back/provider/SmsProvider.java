package com.project.back.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Component
public class SmsProvider {
  private final DefaultMessageService messageService;

  @Value("${sms.from-number}") String FROM;

  public SmsProvider(
    @Value("${sms.api-key}") String API_KEY,
    @Value("${sms.api-secret-key}") String API_SECRET_KEY,
    @Value("${sms.domain}") String API_DOMAIN
  ) {
    this.messageService = NurigoApp.INSTANCE.initialize(API_KEY, API_SECRET_KEY, API_DOMAIN);
  }

  public boolean sendAuthNumber(String userTelNumber, String authNumber) {
    Message message = new Message();
    message.setFrom(FROM);
    message.setTo(userTelNumber);
    message.setText(getAuthNumberText(authNumber));

    SingleMessageSentResponse response = messageService.sendOne(new SingleMessageSendingRequest(message));

    String statusCode = response.getStatusCode();
    boolean result = statusCode.equals("2000");

    return result;
  }
  private String getAuthNumberText(String authNumber) {
    String text = "요청하신 인증 번호는 " + authNumber + "입니다.";
    return text;
  }

  public boolean sendPasswordResetLink(String userTelNumber, String resetLinkCode) {
    Message message = new Message();
    message.setFrom(FROM);
    message.setTo(userTelNumber);
    message.setText(getResetLinkCodeText(resetLinkCode));

    SingleMessageSentResponse response = messageService.sendOne(new SingleMessageSendingRequest(message));

    String statusCode = response.getStatusCode();
    boolean result = statusCode.equals("2000");

    return result;
  }
  private String getResetLinkCodeText(String resetLinkCode) {
    String text = "http://localhost:9999/api/v1/auth/password-update/" + resetLinkCode;
    return text;
  }
}
