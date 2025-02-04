package com.automotive.models.dto;

import com.automotive.models.entity.enums.RoleEnum;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserDetailsDto {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private String email;
    private String phoneNumber;
    private MultipartFile photo;
}
