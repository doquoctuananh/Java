package com.example.demo.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPasswordUtils {
    public static String EncryptPasswordUtils(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static Boolean ParseEncrypt(String password, String currentPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(currentPassword, password);
    }
}
