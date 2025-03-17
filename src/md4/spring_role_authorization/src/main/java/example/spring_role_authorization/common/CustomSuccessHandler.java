package example.spring_role_authorization.common;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        boolean isAdmin = authentication.getAuthorities().stream().
                anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        if (isAdmin) {
            response.sendRedirect("/dashboard");
        }
        else {
            response.sendRedirect("/user");
        }
//        String targetUrl = (String) request.getSession().getAttribute("REDIRECT_URL");
//        request.getSession().removeAttribute("REDIRECT_URL");
//
//        if(targetUrl == null || targetUrl.contains("error") || targetUrl.isEmpty()) {
//            targetUrl = "/";
//        }
//        clearAuthenticationAttributes(request);
//        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
