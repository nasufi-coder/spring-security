package com.automotive.controller;

import com.automotive.models.MessageResponse;
import com.automotive.models.dto.UserDto;
import com.automotive.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    UserService userService;

    //register a new user
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) throws Exception {
        userService.createUser(userDto);
        return ResponseEntity
                .ok()
                .body(new MessageResponse("User is successfully created!"));
    }

    //Enable user
    @PostMapping("/enable/{username}")
    public ResponseEntity<?> enable(@PathVariable String username) throws Exception {
        userService.enableUser(username);
        return ResponseEntity
                .ok()
                .body(new MessageResponse("User is successfully enabled!"));
    }
}
