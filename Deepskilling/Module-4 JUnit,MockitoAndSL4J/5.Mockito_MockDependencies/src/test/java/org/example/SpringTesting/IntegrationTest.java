package org.example.SpringTesting;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.example.SpringTesting.entity.User;
import org.example.SpringTesting.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.*;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTest{

    @Autowired
    UserRepository repository;

    @Test
    void testSaveUser() {
        User user = new User();
        user.setName("Alice");
        User saved = repository.save(user);
        assertNotNull(saved.getId());
        assertEquals("Alice", saved.getName());
    }
}