package com.automotive.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class AutoDTO {

    private Integer id;

    private String brand;

    private String model;

    private String type;

    private String year;

    private String price;

    private List<Object[]> bookedDates;

    private Boolean isBooked;

}
