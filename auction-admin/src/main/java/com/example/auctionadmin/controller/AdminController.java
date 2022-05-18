package com.example.auctionadmin.controller;

import com.example.auctionadmin.model.User;
import com.example.auctionadmin.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> saveOrUpdateProfile(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>("User profile submission successfully", HttpStatus.OK);
    }
}
