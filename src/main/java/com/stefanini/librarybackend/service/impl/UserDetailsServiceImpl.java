package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.UserDAO;
import com.stefanini.librarybackend.dao.impl.UserDAOImpl;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.enums.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDAO<User> userDAO;

    public UserDetailsServiceImpl(UserDAOImpl userDAOImpl) {
        this.userDAO = userDAOImpl;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDAO.findUserByEmail(email);

        if (user == null) {
            log.error("User with such email not found");
            throw new UsernameNotFoundException("User with such email not found");
        } else {
            log.info("User with such email found: {}", email);
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getUserAuthorities(user.getRoles()));
    }

    private Collection<SimpleGrantedAuthority> getUserAuthorities(Set<Role> roles) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.name()));
        });
        return authorities;
    }
}
