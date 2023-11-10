package com.automotive.mapper;


import com.automotive.models.dto.AutoDTO;
import com.automotive.models.dto.UserDto;
import com.automotive.models.entity.AutoEntity;
import com.automotive.models.entity.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface AutoMapper {

    AutoEntity toModel(AutoDTO autoDTO);
    AutoDTO toDto(AutoEntity autoEntity);
    List<AutoDTO> toDtoList(List<AutoEntity> autoEntities);
}
