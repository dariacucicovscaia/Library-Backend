package com.stefanini.librarybackend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.enums.Role;
import com.stefanini.librarybackend.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController("api/")
//@RequestMapping(value = "/test")
@Slf4j
public class UserController {
    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("api/admin/allUsers")
    public List<User> getAllUsers() {
        return userService.showAllUsers();
    }

    @PostMapping("/api/createUser")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("api/admin/findUserById/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PutMapping("api/user/updateUser/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @PutMapping("api/admin/assignRole/{id}/{role}")
    public User assignRole(@PathVariable int id, @PathVariable Role role) {
        return userService.assignRole(id, role);
    }

    @DeleteMapping("api/user/delete/{id}")
    public int deleteById(@PathVariable int id) {
        return userService.deleteById(id);
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);

                String email = decodedJWT.getSubject();
                User user = userService.findByEmail(email);


                String access_token = JWT.create()
                        .withSubject(user.getEmail())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::name).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);


            } catch (Exception exception) {
                log.error(exception.getMessage());
                log.error("Error logging in: {} ",exception.getMessage() );

                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        }else if(authorizationHeader == null){
            Map<String, String> error = new HashMap<>();
            error.put("error_message", "Authorization header cant be null!");

            response.setContentType(APPLICATION_JSON_VALUE);
            new ObjectMapper().writeValue(response.getOutputStream(), error);
            log.error("Authorization header cant be null!");
        } else {
           throw new RuntimeException("Refreshed token is missing");
        }
      }


}
