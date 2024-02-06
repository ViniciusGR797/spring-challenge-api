package com.challengepay.challengepay.usecase.utils;

public interface IPasswordEncryptor {
    String encodePassword(String password);
    boolean matches(String rawPassword, String encodedPassword);
}
