package com.stefanini.librarybackend.security;


import com.stefanini.librarybackend.auth.AppAuthenticationFilter;
import com.stefanini.librarybackend.auth.AppAuthorizationFilter;
import com.stefanini.librarybackend.service.impl.AppUserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserServiceImpl appUserServiceImpl;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .authorizeRequests()

                .antMatchers("/", "index", "/css/*", "/js/*", "/login", "/api/login").permitAll()
<<<<<<< HEAD

                .antMatchers("/api/token/refresh", "/sign-up", "/api/sign-up").permitAll()

                .antMatchers(GET,"/api/author/**", "/api/book/**", "/api/category/**").permitAll()
=======
                .antMatchers("/api/token/refresh", "/sign-up", "/api/sign-up",
                        "/api/user/update/{id}", "/api/user/delete/{id}","/api/user/assignRole/{id}/{role}" ).permitAll()
                .antMatchers(GET,"/api/author/**", "/api/book/**", "/api/category/categories").permitAll()
>>>>>>> 0eb17c67b02e8eccd12b20ab6f932f0296ce86ae
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilter(new AppAuthenticationFilter(authenticationManagerBean()))
                .addFilterBefore(new AppAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserServiceImpl).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
