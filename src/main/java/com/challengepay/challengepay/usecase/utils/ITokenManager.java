package com.challengepay.challengepay.usecase.utils;

import java.util.Map;

public interface ITokenManager {
    String createToken(String id);
    String getTokenId(String token);
    Map<String, Object> getClaims(String token);
    boolean isTokenValid(String token);
}
