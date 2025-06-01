package com.api.chat_app.infrastructure.security.jwt;

import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(
           @Nonnull HttpServletRequest request,
           @Nonnull HttpServletResponse response,
           @Nonnull FilterChain filterChain)
            throws ServletException, IOException {

        if(request.getServletPath().contains("/auth")){
            filterChain.doFilter(request,response);
            return;
        }

        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
         if (authHeader == null || !authHeader.startsWith("Bearer ")) {
             filterChain.doFilter(request, response);
             return;
         }

         final String jwt = authHeader.substring(7);
         String email = jwtUtils.extractEmail(jwt);
         UserDetails userDetails = userDetailsService.loadUserByUsername(email);

         jwtUtils.isTokenValid(jwt, userDetails);


    }
}
