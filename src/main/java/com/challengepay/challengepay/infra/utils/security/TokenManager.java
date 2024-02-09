package com.challengepay.challengepay.infra.utils.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;

import com.challengepay.challengepay.usecase.utils.ITokenManager;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
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
    public Object[] isTokenValid(String token) {
        Object[] result = new Object[2];
        try {
            Jwts.parserBuilder()
                .setSigningKey(JWT_SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token);
            result[0] = true;
            result[1] = "Valid token";
        } catch (Exception e) {
            result[0] = false;
            result[1] = e.getMessage();
        }
        return result;
    }
}
