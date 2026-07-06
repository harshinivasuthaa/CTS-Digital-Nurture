package org.example.SpringTesting.service;

import org.example.SpringTesting.entity.User;
import org.example.SpringTesting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}