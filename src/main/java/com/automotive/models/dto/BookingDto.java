package com.automotive.models.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDto {

    private Integer id;

    private LocalDate bookedFrom;

    private LocalDate bookedUntil;

    private Integer autoId;

    private AutoDTO bookedAuto;

    private UserDto bookedBy;
}
