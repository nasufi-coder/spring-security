package com.automotive.models.dto;

import lombok.Data;

@Data
public class AutoDTO {

    private Integer id;

    private String brand;

    private String model;

    private String type;

    private String year;

    private String price;

    private Boolean isBooked;

}
