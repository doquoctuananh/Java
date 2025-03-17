package example.spring_role_authorization.security;

import example.spring_role_authorization.common.CustomSuccessHandler;
import example.spring_role_authorization.common.CustomeAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.beans.BeanProperty;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Autowired
    private CustomeAuthenticationEntryPoint customeAuthenticationEntryPoint;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/","/home","/account/**").permitAll()
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/customer/**").hasRole("CUSTOMER")
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/process_login")
                        .successHandler(customSuccessHandler)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutRequestMatcher( new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .permitAll()
                )
                .sessionManagement(session-> session
                        .invalidSessionUrl("/login")
                        .maximumSessions(1)
                        .expiredUrl("/login")
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(customeAuthenticationEntryPoint))
                .requestCache(rc -> rc.disable())
        ;
        return http.build();

    }
}
