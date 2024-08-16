package com.automotive.models.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookingDto {

    private Integer id;

    private LocalDateTime bookedFrom;

    private LocalDateTime bookedUntil;

    private Integer autoId;

    private AutoDTO bookedAuto;

    private UserDto bookedBy;
}
