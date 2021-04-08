package com.example.wbdvsp21recipeplannerserverjava.security;


import com.example.wbdvsp21recipeplannerserverjava.auth.JwtTokenFilter;
import com.example.wbdvsp21recipeplannerserverjava.auth.JwtUsernameAndPasswordAuthenticationFilter;
import com.example.wbdvsp21recipeplannerserverjava.jwt.JwtConfig;
import com.example.wbdvsp21recipeplannerserverjava.models.UserRole;
import com.example.wbdvsp21recipeplannerserverjava.services.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;


@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final ApplicationUserService applicationUserService;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    @Autowired
    public ApplicationSecurityConfig(ApplicationUserService applicationUserService,
                                     JwtConfig jwtConfig,
                                     SecretKey secretKey) {
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
        this.applicationUserService = applicationUserService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
                .cors().and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), applicationUserService, jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenFilter(applicationUserService, secretKey, jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/hello").permitAll()
                .antMatchers("/creator").hasAnyRole(UserRole.CREATOR.toString())
                .antMatchers("/shopper").hasAnyRole(UserRole.SHOPPER.toString())
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(applicationUserService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}