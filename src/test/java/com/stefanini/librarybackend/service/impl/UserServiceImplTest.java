package com.stefanini.librarybackend.service.impl;

import com.stefanini.librarybackend.dao.impl.UserDAOImpl;
import com.stefanini.librarybackend.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Mock
    private UserDAOImpl userDAO;
    private AutoCloseable autoCloseable;
    private UserService underTest;

    @BeforeEach
    void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new UserServiceImpl(userDAO, );
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void showAllUsers() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByEmail() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void assignRole() {
    }

    @Test
    void getUserHistory() {
    }

    @Test
    void getUserBooks() {
    }
    
    @Test
    void changePassword() {
    }

    @Test
    void findUserByAnyCriteria() {
    }

    @Test
    void sendLinkForChangePassword() {
    }
}