package com.automotive.service;

import com.automotive.models.dto.UserDetailsDto;
import com.automotive.models.dto.UserDto;
import com.automotive.models.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(UserDetailsDto userDetailsDto);

    void updateUser(UserDetailsDto userDetailsDto);

    List<UserDto> getUsers();

    UserDto getOne(String username);

    void enableUser(String userId);

    Optional<UserEntity> findByUsername(String username);

    UserEntity getLoggedInUsser();
}
