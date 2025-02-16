package com.example.demo.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;


@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws  IOException {
        String targetUrl = (String) request.getSession().getAttribute("REDIRECT_URL");
        request.getSession().removeAttribute("REDIRECT_URL");


        if (targetUrl == null || targetUrl.isEmpty() || targetUrl.contains("favicon.ico") ||  targetUrl.contains("error")) {
            targetUrl = "/";  // Default URL
        }

        clearAuthenticationAttributes(request);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}