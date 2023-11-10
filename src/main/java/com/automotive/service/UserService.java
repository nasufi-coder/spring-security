package com.automotive.service;

import com.automotive.models.dto.UserDto;
import com.automotive.models.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(UserEntity userEntity);

    List<UserDto> getUsers();

    void enableUser(String userId);

    Optional<UserEntity> findByUsername(String username);

    UserEntity getLoggedInUsser();
}
