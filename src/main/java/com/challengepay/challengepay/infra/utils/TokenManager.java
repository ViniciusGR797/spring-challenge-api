package com.challengepay.challengepay.infra.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;

import com.challengepay.challengepay.usecase.utils.ITokenManager;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenManager implements ITokenManager {

    private static final String JWT_SECRET_KEY = "DyHj+OPBK1H5f+uS3RzV2xSTe8bk+LzphtJqvCrlXcEdYsakbEcN3tkBEnAMO+SF/+M0cHuL73oaAT9fhwBrcA==";
    private static final int JWT_ACCESS_TOKEN_EXPIRES_IN_HOURS = 6;

    @Override
    public String createToken(String id) {
        Key key = Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes());
        
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_ACCESS_TOKEN_EXPIRES_IN_HOURS * 60 * 60 * 1000);

        return Jwts.builder()
                .setSubject(id)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    @Override
    public String getTokenId(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(JWT_SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getId();
    }

    @Override
    public Map<String, Object> getClaims(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(JWT_SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return new HashMap<>(claims);
    }

    @Override
    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(JWT_SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
