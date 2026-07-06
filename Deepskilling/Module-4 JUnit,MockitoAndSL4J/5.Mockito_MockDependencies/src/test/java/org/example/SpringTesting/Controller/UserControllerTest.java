
package org.example.SpringTesting.Controller;

import org.example.SpringTesting.entity.User;
import org.example.SpringTesting.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Test
    void testGetUser() {

        UserService service = mock(UserService.class);

        User user = new User(1L, "Alice");

        when(service.getUserById(1L)).thenReturn(user);

        UserController controller = new UserController();
        controller.setUserService(service);

        ResponseEntity<User> response = controller.getUser(1L);

        assertEquals("Alice", response.getBody().getName());
    }
}