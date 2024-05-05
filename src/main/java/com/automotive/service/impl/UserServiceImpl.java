package com.automotive.service.impl;

import com.automotive.mapper.UserMapper;
import com.automotive.models.dto.UserDetailsDto;
import com.automotive.models.dto.UserDto;
import com.automotive.models.entity.UserEntity;
import com.automotive.repository.UserRepository;
import com.automotive.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    @Override
    public void saveUser(UserDetailsDto userDto) {
        var isExistingUser = findByUsername(userDto.getUsername());
        if (isExistingUser.isPresent()) {
            throw new IllegalArgumentException("User with this username is already registered!");
        }
        userDto.setPassword(encoder.encode(userDto.getPassword()));
        var userEntity = userMapper.toModel(userDto);
        userEntity.setAccountNonLocked(true);
        userRepository.save(userEntity);
    }

    @Override
    public void updateUser(UserDetailsDto userDto) {
        var isExistingUser = findByUsername(userDto.getUsername());
        if (isExistingUser.isEmpty()) {
            throw new IllegalArgumentException("User with this username is not registered!");
        }
        var loggedInUser = this.getLoggedInUsser();
        if (!loggedInUser.getUsername().equals(userDto.getUsername())) {
            throw new IllegalArgumentException("This user is not allowed to modify user with username: " + userDto.getUsername());
        }
        userDto.setId(isExistingUser.get().getId());

        var userEntity = userMapper.toModel(userDto);
        userEntity.setEnabled(isExistingUser.get().isEnabled());
        userEntity.setAccountNonLocked(true);

        userRepository.save(userEntity);
    }

    @Override
    public List<UserDto> getUsers() {
        var users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }

    @Override
    public UserDto getOne(String username) {
        var user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Not able to find user with username " + username));
        return userMapper.toDto(user);
    }

    @Override
    public void enableUser(String userId) {
        var user = userRepository.findByUsername(userId).orElseThrow(() -> new IllegalArgumentException("Not able to find user with username " + userId));
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserEntity getLoggedInUsser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Optional<UserEntity> user = findByUsername(userDetails.getUsername());
        return user.orElse(null);
    }


}
