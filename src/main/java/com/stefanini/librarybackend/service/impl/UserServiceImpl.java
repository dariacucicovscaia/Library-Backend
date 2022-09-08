package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.UserDAO;
import com.stefanini.librarybackend.dao.impl.UserDAOImpl;
import com.stefanini.librarybackend.domain.Book;
import com.stefanini.librarybackend.domain.History;
import com.stefanini.librarybackend.domain.User;
import com.stefanini.librarybackend.domain.enums.Role;
import com.stefanini.librarybackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserDAO<User> userDao;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(UserDAOImpl userDao, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public User createUser(User user) {
        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>(Arrays.asList(Role.USER)));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.create(user);
    }

    @Override
    public User updateUser(int id, User user) {
        User u = findById(id);
        u.setEmail(user.getEmail());

        u.getProfile().setFirstName(user.getProfile().getFirstName());
        u.getProfile().setLastName(user.getProfile().getLastName());
        u.getProfile().setPhoneNumber(user.getProfile().getPhoneNumber());

        if (user.getPassword() != null) {
            u.setPassword(passwordEncoder.encode(user.getPassword()));
        }

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
    public int deleteByEmail(String email) {
        return userDao.removeById(findByEmail(email).getId());
    }

    @Override
    public int deleteById(int id) {
        return userDao.removeById(id);
    }

    @Override
    @Transactional
    public User assignRole(int id, Role role) {
        User user = findById(id);
        user.getRoles().add(role);
        log.info("Role {} was assigned to user with id {}", role.name(), user.getId());
        return userDao.update(user);
    }

    @Override
    public List<History> getUserHistory(int userId) {
        return userDao.getById(userId).getHistory();
    }


    @Override
    public List<Book> getUserBooks(int userId) {
        return userDao.getById(userId).getBook();
    }

    @Override
    public User changePassword(int id, String password) {
        User u = findById(id);
        u.setHasTemporaryPassword(false);
        u.setPassword(passwordEncoder.encode(password));
        return userDao.update(u);
    }


    public List<User> findUserByAnyCriteria(String criteria) {
        return userDao.getUsersByCriteria(criteria);
    }

}