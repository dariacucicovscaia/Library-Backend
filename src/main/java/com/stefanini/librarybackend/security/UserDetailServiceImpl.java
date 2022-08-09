package com.stefanini.librarybackend.security;

import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

   @Autowired
    private UserService userService;

   // @Bean
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            User user = userService.findByEmail(email);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return new CustomUserDetails(user);
        }

}