package io.playdata.springboot03.controller;

import io.playdata.springboot03.model.User;
import io.playdata.springboot03.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired // 컨트롤러에 레포지토리 자동 연결
    private UserRepository userRepository;

    @GetMapping("")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userRepository.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
