package com.automotive.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "auto")
public class AutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String brand;
    private String model;
    private String type;
    private String year;
    private String price;
    private Boolean isBooked = false;

    @ManyToOne()
    @JoinColumn(name = "ownedBy", referencedColumnName = "id")
    private UserEntity ownedBy;

}
