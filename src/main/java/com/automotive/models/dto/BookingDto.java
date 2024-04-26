package com.automotive.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDto {

    private Integer id;

    private String description;

    private LocalDateTime bookedAt;

    private LocalDateTime bookedUntil;

    private Integer autoId;
}
