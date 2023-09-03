package com.automotive.service.impl;

import com.automotive.mapper.UserMapper;
import com.automotive.models.dto.UserDto;
import com.automotive.repository.UserRepository;
import com.automotive.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    @Override
    public void createUser(UserDto userDto) {
        var userEntity = userMapper.toModel(userDto);
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }

    @Override
    public void enableUser(String userId) {
        var user = userRepository.findByUsername(userId).orElseThrow(() -> new IllegalArgumentException("Not able to find user with username "+userId));
        user.setEnabled(true);
    }

}
