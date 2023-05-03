package io.playdata.springboot03.controller;

import io.playdata.springboot03.model.User;
import io.playdata.springboot03.repository.UserRepository;
import io.playdata.springboot03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired // 컨트롤러에 레포지토리 자동 연결
    private UserRepository userRepository;

    @GetMapping("")
    public List<User> getUsers(){
//        return userRepository.findAll();
        return userService.getUsers();
    }


    @PostMapping("") //
    public ResponseEntity<User> createUser(@RequestBody User user){ // HTTP POST 요청으로 전송된 데이터를 받아들이는 메소드
//        User createdUser = userRepository.save(user);
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user){
        // @RequestBody : body를 통해 Request를 받아옴.
        User updatedUser = userService.update(userId, user);
        if (updatedUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}") // https://localhost:8080/users/1 -> users/{userId}
    public ResponseEntity<User> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
