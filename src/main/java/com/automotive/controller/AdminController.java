package com.automotive.controller;

import com.automotive.models.MessageResponse;
import com.automotive.models.dto.UserDto;
import com.automotive.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private UserService userService;

    //Enable user
    @PostMapping("/enable/{username}")
    public ResponseEntity<?> enable(@PathVariable String username) throws Exception {
        userService.enableUser(username);
        return ResponseEntity
                .ok()
                .body(new MessageResponse("Changed successfully!"));
    }

    @GetMapping("/user/all")
    public List<UserDto> getUsers() throws Exception {
        return userService.getUsers();
    }

    @GetMapping("/user/{username}")
    public UserDto getUsers(@PathVariable String username) throws Exception {
        return userService.getOne(username);
    }
}
