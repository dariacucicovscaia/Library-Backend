package com.stefanini.librarybackend.service.impl;


import com.stefanini.librarybackend.dao.UserDAO;
import com.stefanini.librarybackend.dao.impl.UserDAOImpl;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.enums.Role;
import com.stefanini.librarybackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDAO<User> userDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Email not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.name())));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }


    @Override
    @Transactional
    public User createUser(User user) {
        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>(Arrays.asList(Role.USER)));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.create(user);
    }

    @Override
    @Transactional
    public User updateUser(int id, User user) {
        User u = findById(id);
        u.setEmail(user.getEmail());
        u.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.update(u);
    }

    @Override
    public List<User> showAllUsers() {
        return userDao.getAll();
    }

    @Override
    public User findById(int id) {
        return userDao.getById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    @Transactional
    public int deleteByEmail(String email) {
        return userDao.removeById(findByEmail(email).getId());
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        return userDao.removeById(id);
    }

    @Override
    @Transactional
    public User assignRole(int id, Role role) {
        User u = findById(id);
        u.getRoles().add(role);
        return userDao.update(u);
    }


}
