package com.study.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

public class MD5Util {

  public static String md5(String src) {
    return DigestUtils.md5Hex(src);
  }

  private static final String salt = "1a2b3c4d";

  public static String inputPassToFormPass(String inputPass) {
    String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
    System.out.println(str);
    return md5(str);
  }

  public static String formPassToDBPass(String formPass, String salt) {
    String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
    return md5(str);
  }

  public static boolean validatedPassword(String userPassword, String dbPassword, String salt) {
    if (StringUtils.isBlank(userPassword)
        || StringUtils.isBlank(dbPassword)
        || StringUtils.isBlank(salt)) {
      return Boolean.FALSE;
    }
    return dbPassword.equals(formPassToDBPass(userPassword, salt));
  }

  public static String inputPassToDbPass(String inputPass, String saltDB) {
    String formPass = inputPassToFormPass(inputPass);
    String dbPass = formPassToDBPass(formPass, saltDB);
    return dbPass;
  }

  public static void main(String[] args) {
    System.out.println(inputPassToDbPass("admin1234","1a2b3c4d"));
  }
}
