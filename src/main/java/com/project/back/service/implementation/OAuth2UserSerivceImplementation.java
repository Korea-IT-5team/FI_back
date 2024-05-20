package com.project.back.service.implementation;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.stereotype.Service;

import com.project.back.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuth2UserSerivceImplementation extends DefaultOAuth2UserService {
  private final UserRepository userRepository;
  private final 
}
