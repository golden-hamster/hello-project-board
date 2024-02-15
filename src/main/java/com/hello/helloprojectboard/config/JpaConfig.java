package com.hello.helloprojectboard.config;

import com.hello.helloprojectboard.dto.security.BoardPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

//    @Bean
//    public AuditorAware<String> auditorAware() {
//        return () -> Optional.ofNullable(SecurityContextHolder.getContext())
//                .map(SecurityContext::getAuthentication)
//                .filter(Authentication::isAuthenticated)
//                .map(Authentication::getPrincipal)
//                .map(BoardPrincipal.class::cast)
//                .map(BoardPrincipal::getUsername);
//    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//                 인증되지 않은 사용자인 경우
            if (authentication == null || !authentication.isAuthenticated()) {
                return Optional.empty();
            }

//                 인증된 사용자인 경우
            Object principal = authentication.getPrincipal();
            if (principal instanceof BoardPrincipal) {
                return Optional.of(((BoardPrincipal) principal).getUsername());
            }
            return Optional.empty();
        };
    }
}
