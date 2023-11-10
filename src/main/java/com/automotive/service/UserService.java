package com.automotive.service;

import com.automotive.models.dto.UserDto;
import com.automotive.models.entity.UserEntity;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserService {
    void createUser(UserEntity userEntity);

    List<UserDto> getUsers();

    void enableUser(String userId);
}
