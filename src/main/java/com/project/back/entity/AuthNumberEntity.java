package com.project.back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="authNumber")
@Table(name="auth_number")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthNumberEntity {
  @Id
  private String telNumber;
  private String authNumber;
}