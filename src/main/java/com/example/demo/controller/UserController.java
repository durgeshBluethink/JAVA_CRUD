package com.example.demo.controller;

import com.example.demo.Service.UserService;
import com.example.demo.entity.UserEntity;
import com.example.demo.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    public UserController(UserService userService, UserRepository userRepository) {
//        this.userService = userService;
//    }

    // Add
    @PostMapping(value = "/users")
    public ResponseEntity<Object> Post(@RequestBody UserEntity params) {
        try {
            UserEntity result = userService.Post(params);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    // Get
    @GetMapping(value = "/users")
    public ResponseEntity<Object> Get() {
        try {
            List<UserEntity> result = userService.Get();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // Get By ID
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Object> Get(@PathVariable int id) {
        try {
            UserEntity result = userService.Get(id);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // Update
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<Object> Update(@PathVariable int id, @RequestBody UserEntity params) {
        try {
            UserEntity result = userService.Update(params, id);
            return ResponseHandler.generateResponse("Updated", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // Delete
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Object> Delete(@PathVariable int id) {
        try {
            String result = userService.Delete(id);
            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}