package com.backend.api.util;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // Set response content type and encoding
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Write a custom error message to the response body
        response.getWriter().write("{\"error\": \"Unauthorized access\", \"message\": \"You must provide a valid token to access this resource\"}");
    }
    
}
