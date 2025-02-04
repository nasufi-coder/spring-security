package com.automotive.controller;

import com.automotive.configurations.jwtconfig.JwtTokenUtil;
import com.automotive.models.MessageResponse;
import com.automotive.models.dto.UserDetailsDto;
import com.automotive.models.dto.UserDto;
import com.automotive.models.entity.UserEntity;
import com.automotive.models.jwt.JwtRequest;
import com.automotive.models.jwt.JwtResponse;
import com.automotive.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtUtils;
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody JwtRequest loginRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserEntity userDetails = (UserEntity) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            // ✅ Convert byte[] photo to Base64 String
            String photoBase64 = "";
            if (userDetails.getPhoto() != null) {
                photoBase64 = Base64.getEncoder().encodeToString(userDetails.getPhoto());
            }

            logger.info(userDetails.getUsername() + " is logged in!");

            return ResponseEntity.ok(new JwtResponse(
                    jwt,
                    userDetails.getUsername(),
                    photoBase64,  // ✅ Send Base64 string instead of raw byte[]
                    roles
            ));
        } catch (Exception exception) {
            return ResponseEntity.ok(new MessageResponse(exception.getMessage()));
        }
    }


    // register a new user and accept a photo as a blob
    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> register(@ModelAttribute UserDetailsDto userDetailsDto) throws Exception {
        // Convert role manually

        // Convert MultipartFile to byte[]
        byte[] photoBytes = null;
        if (userDetailsDto.getPhoto() != null && !userDetailsDto.getPhoto().isEmpty()) {
            photoBytes = userDetailsDto.getPhoto().getBytes();
        }

        userService.saveUser(userDetailsDto);
        return ResponseEntity.ok().body(new MessageResponse("User successfully created!"));
    }


    @GetMapping("/{username}")
    public UserDto getUsers(@PathVariable String username) {
        return userService.getOne(username);
    }

    //update a new user
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserDetailsDto userDetailsDto) throws Exception {
        userService.updateUser(userDetailsDto);
        return ResponseEntity
                .ok()
                .body(new MessageResponse("User is successfully updated!"));
    }


}
