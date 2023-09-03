package com.automotive.service;

import com.automotive.models.dto.UserDto;

public interface UserService {
    void createUser(UserDto userDto);

    void enableUser(String userId);
}
