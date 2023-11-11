package com.automotive.controller;

import com.automotive.configurations.jwtconfig.JwtTokenUtil;
import com.automotive.models.MessageResponse;
import com.automotive.models.entity.UserEntity;
import com.automotive.models.jwt.JwtRequest;
import com.automotive.models.jwt.JwtResponse;
import com.automotive.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/authenticate")
@AllArgsConstructor
@Slf4j
public class JwtAuthenticationController {

}