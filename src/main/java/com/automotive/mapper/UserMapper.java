package com.automotive.mapper;

import com.automotive.models.dto.UserDetailsDto;
import com.automotive.models.dto.UserDto;
import com.automotive.models.entity.UserEntity;
import com.automotive.models.entity.enums.RoleEnum;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface UserMapper {

    UserEntity toModel(UserDto userDto);

    UserDto toDto(UserEntity userEntity);

    List<UserDto> toDtoList(List<UserEntity> userEntities);

    @Mapping(target = "role", source = "role", qualifiedByName = "mapRoleEnum")
    @Mapping(target = "photo", source = "photo", qualifiedByName = "mapMultipartFileToBytes")
        // Add custom conversion for photo
    UserEntity toModel(UserDetailsDto userDetailsDto);

    // Custom Role Mapping
    @Named("mapRoleEnum")
    default RoleEnum mapRoleEnum(String role) {
        if (role == null) {
            return null;
        }
        try {
            return RoleEnum.valueOf(role.toUpperCase()); // Ensure case-insensitivity
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid role: " + role);
        }
    }

    // Custom MultipartFile to byte[] Mapping
    @Named("mapMultipartFileToBytes")
    default byte[] mapMultipartFileToBytes(MultipartFile photo) {
        if (photo == null || photo.isEmpty()) {
            return null;
        }
        try {
            return photo.getBytes(); // Convert MultipartFile to byte[]
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert MultipartFile to byte[]", e);
        }
    }
}
