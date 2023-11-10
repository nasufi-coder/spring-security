package com.automotive.service.impl;

import com.automotive.mapper.UserMapper;
import com.automotive.models.dto.UserDto;
import com.automotive.models.entity.UserEntity;
import com.automotive.repository.UserRepository;
import com.automotive.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    @Override
    public void createUser(UserEntity userEntity) {
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }

    @Override
    public List<UserDto> getUsers() {
        var users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }

    @Override
    public void enableUser(String userId) {
        var user = userRepository.findByUsername(userId).orElseThrow(() -> new IllegalArgumentException("Not able to find user with username " + userId));
        user.setEnabled(true);
    }

}
