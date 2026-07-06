package org.example.SpringTesting.Controller;

import org.example.SpringTesting.entity.User;
import org.example.SpringTesting.service.UserService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerMvcTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService service;

    @Test
    void testGetUser() throws Exception {
        when(service.getUserById(1L)).thenReturn(new User(1L,"Alice"));
        mockMvc.perform(get("/users/1")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("Alice"));
    }
}