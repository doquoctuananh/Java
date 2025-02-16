package com.example.demo.common;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        if (request.getRequestURI().contains("favicon.ico")) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // Lưu URL hiện tại vào session
        String targetUrl = request.getRequestURI();
        String queryString = request.getQueryString();
        if (queryString != null) {
            targetUrl += "?" + queryString;
        }

        request.getSession().setAttribute("REDIRECT_URL", targetUrl);

        // Redirect tới trang login
        response.sendRedirect("/login");
    }
}
