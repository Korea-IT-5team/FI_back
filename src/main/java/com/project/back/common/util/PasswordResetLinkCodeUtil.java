package com.project.back.common.util;

import java.util.Random;

public class PasswordResetLinkCodeUtil {
  public static String createCode() {
    String code = "";
    Random random = new Random();

    for (int index = 0; index < 7; index++) { code += random.nextInt(10); }
    return code;
  }
  
}
