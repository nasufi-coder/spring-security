package com.automotive.models.dto;

import com.automotive.models.entity.enums.RoleEnum;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private RoleEnum role;

    private String email;

    private String phoneNumber;

    private Date dateCreated;

    private String modifiedBy;

    private Boolean isNonLocked;

    private Boolean enabled;


}
