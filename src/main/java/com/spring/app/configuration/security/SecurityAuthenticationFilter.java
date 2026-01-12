package com.spring.app.configuration.security;

import com.spring.app.service.ApiUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private ApiUserService apiUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = this.recoverToken(request);
        if (token != null){
            String login = tokenService.validateToken(token);

            UserDetails apiUser = apiUserService.loadUserByUsername(login);
            var userPassToken = new UsernamePasswordAuthenticationToken(apiUser, null, apiUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(userPassToken);
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if (authHeader==null) return null;
        String token = authHeader.replace("Bearer ", "");
        return token;
    }
}
