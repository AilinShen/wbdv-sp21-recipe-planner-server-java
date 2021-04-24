package com.example.wbdvsp21recipeplannerserverjava.auth;

import com.example.wbdvsp21recipeplannerserverjava.jwt.JwtConfig;
import com.example.wbdvsp21recipeplannerserverjava.jwt.JwtSecretKey;
import com.example.wbdvsp21recipeplannerserverjava.models.User;
import com.example.wbdvsp21recipeplannerserverjava.security.ApiResponse;
import com.example.wbdvsp21recipeplannerserverjava.services.ApplicationUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final ApplicationUserService userService;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager,
                                                      ApplicationUserService userService,
                                                      JwtConfig jwtConfig,
                                                      SecretKey secretKey) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try{
            System.out.println("Come in");
             UserAuthenticationRequest authenticationRequest = new ObjectMapper()
                     .readValue(request.getInputStream(), UserAuthenticationRequest.class);

             // check whether user and password are correct
            //
            UserDetails userDetail = userService.loadUserByUsername(authenticationRequest.getEmail());


            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    userDetail, //principal
                    authenticationRequest.getPassword()); //credential
            authenticationManager.authenticate(authentication);

            return authentication;


        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        // change authResult to specific to my user

        ApplicationUserPrincipal userDetail = (ApplicationUserPrincipal) authResult.getPrincipal();


        String token = Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(userDetail.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
                .signWith(secretKey)
                .compact();

        response.addHeader(jwtConfig.getAuthorizationHeader(), jwtConfig.getTokenPrefix() + token);


        User user = userService.findUserByEmail(userDetail.getEmail()).get(0);
        UserAuthenticationResponse result = new UserAuthenticationResponse(200,
                jwtConfig.getTokenPrefix() + token,
                user.getEmail(),
                user.getId().toString(),
                user.getName(),
                user.getRole(), "success");

        System.out.println();

        ObjectMapper objectMapper= new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(result);
        response.getWriter().write(jsonString);
        response.getWriter().flush();

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {

        UserAuthenticationResponse result = new UserAuthenticationResponse(403,
                "", "", "", "", "", "Invalid password");

//        response.setContentType("application/json");
//        response.setCharacterEncoding("utf-8");
        ObjectMapper objectMapper= new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(result);
        response.getWriter().write(jsonString);
        response.getWriter().flush();
    }
}
