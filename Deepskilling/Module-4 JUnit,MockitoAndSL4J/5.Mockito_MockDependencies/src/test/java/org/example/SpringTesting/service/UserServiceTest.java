package org.example.SpringTesting.service;

import org.example.SpringTesting.entity.User;
import org.example.SpringTesting.repository.UserRepository;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest{

    @Test
    void testGetUserById(){

        UserRepository repo = mock(UserRepository.class);
        User user = new User(1L, "Alice");
        when(repo.findById(1L)).thenReturn(Optional.of(user));
        UserService service = new UserService();
        service.setUserRepository(repo);
        User result = service.getUserById(1L);
        assertEquals("Alice", result.getName());
    }
}