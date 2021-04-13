package com.example.wbdvsp21recipeplannerserverjava.auth;

import com.example.wbdvsp21recipeplannerserverjava.jwt.JwtConfig;
import com.example.wbdvsp21recipeplannerserverjava.jwt.JwtSecretKey;
import com.example.wbdvsp21recipeplannerserverjava.services.ApplicationUserService;
import io.jsonwebtoken.*;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {


    private final ApplicationUserService userService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    public JwtTokenFilter(ApplicationUserService userService, SecretKey s, JwtConfig j) {
        this.userService = userService;
        this.secretKey = s;
        this.jwtConfig = j;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {


        final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        String username = null;

        String jwt = null;


        if ( authorizationHeader == null || !authorizationHeader.startsWith(jwtConfig.getTokenPrefix())) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorizationHeader.replace(jwtConfig.getTokenPrefix(), "");


        try {

            // it checks token signature and token expired or not
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);




            Claims body = claimsJws.getBody();
            username = body.getSubject();
            UserDetails userDetails = this.userService.loadUserByUsername(username);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (JwtException e) {
            throw new IllegalStateException(String.format("Token %s cannot be trusted", token));
        }

        filterChain.doFilter(request, response);

    }
}
