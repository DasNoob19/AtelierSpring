package com.example.exercisespring.controller;

import com.example.exercisespring.model.User;
import com.example.exercisespring.repository.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers(){
        try{
            List<User> userList = new ArrayList<>();
            userRepository.findAll().forEach(userList::add);
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id){
        Optional<User> users = userRepository.findById(id);
        if (users.isPresent()){
            return new ResponseEntity<>(users.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        try{
            User postUser = userRepository
                    .save(new User(user.getName(), user.getEmail(), user.getPhone(), user.getCredit()));
            return new ResponseEntity<>(postUser, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<User> updateUserCredit(@PathVariable("id") long id,@RequestBody User user){
        try{
            User patchUser = userRepository.findById(id).get();
            patchUser.setCredit(user.getCredit());
            return new ResponseEntity<>(userRepository.save(patchUser), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
        Optional<User> userData = userRepository.findById(id);
        if (userData.isPresent()){
            User putUser = userData.get();
            putUser.setName(user.getName());
            putUser.setEmail(user.getEmail());
            putUser.setPhone(user.getPhone());
            putUser.setCredit(user.getCredit());
            return new ResponseEntity<>(userRepository.save(putUser), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
