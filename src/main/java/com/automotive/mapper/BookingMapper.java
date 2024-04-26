package com.automotive.mapper;

import com.automotive.models.dto.BookingDto;
import com.automotive.models.entity.BookingEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface BookingMapper {

    BookingEntity toModel(BookingDto bookingDto);

    BookingDto toDto(BookingEntity bookingEntity);

    List<BookingDto> toDtoList(List<BookingEntity> bookingEntities);

}
