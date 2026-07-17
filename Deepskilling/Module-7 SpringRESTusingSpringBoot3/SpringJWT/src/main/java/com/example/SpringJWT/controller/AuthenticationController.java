package com.example.SpringJWT.controller;

import com.example.SpringJWT.model.AuthenticationRequest;
import com.example.SpringJWT.model.AuthenticationResponse;
import com.example.SpringJWT.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest request) {

        if ("user".equals(request.getUsername()) && "pwd".equals(request.getPassword())) {

            String token = jwtUtil.generateToken(request.getUsername());
            return new AuthenticationResponse(token);
        }

        return new AuthenticationResponse("Invalid Credentials");
    }
}