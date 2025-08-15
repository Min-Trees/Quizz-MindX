package com.quizz.app.service;

import com.quizz.app.dto.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void registerReturnsToken() {
        RegisterRequest req = new RegisterRequest();
        req.setEmail("test@example.com");
        req.setPassword("password");
        req.setName("Test");
        String token = userService.register(req);
        assertNotNull(token);
    }
}
