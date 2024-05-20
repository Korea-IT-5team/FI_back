package com.project.back.entity;

import jakarta.persistence.Id;

public class AuthNumberEntity {
  @Id
  private String telNumber;
  private String authNumber;
}
