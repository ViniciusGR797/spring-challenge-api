package com.challengepay.challengepay.infra.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.challengepay.challengepay.usecase.utils.IPasswordEncryptor;

public class PasswordEncryptor implements IPasswordEncryptor {

    private static final int STRENGTH = 10; // Strength para o algoritmo de hashing

    @Override
    public String encodePassword(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(STRENGTH);
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(STRENGTH);
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}

