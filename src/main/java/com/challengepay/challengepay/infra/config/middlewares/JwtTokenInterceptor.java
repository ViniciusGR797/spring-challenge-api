package com.challengepay.challengepay.infra.config.middlewares;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.stereotype.Component;

import com.challengepay.challengepay.entity.user.exception.InvalidTokenException;
import com.challengepay.challengepay.infra.utils.security.TokenManager;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class JwtTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenManager tokenManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();

            if (method.getAnnotation(JwtToken.class) != null) {
                String authorizationHeader = request.getHeader("Authorization");

                if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
                    throw new InvalidTokenException("The token is required, but has not been provided");
                }

                String token = authorizationHeader.substring(7);
                Object[] isValid = tokenManager.isTokenValid(token);

                if (!(boolean) isValid[0]) {
                    throw new InvalidTokenException((String) isValid[1]);
                }
            }
        }

        return true;
    }


}

