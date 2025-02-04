package com.automotive.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "bookings")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate bookedFrom;
    private LocalDate bookedUntil;

    @ManyToOne()
    @JoinColumn(name = "bookedBy", referencedColumnName = "id")
    private UserEntity bookedBy;

    @ManyToOne()
    @JoinColumn(name = "bookedAuto", referencedColumnName = "id")
    private AutoEntity bookedAuto;

}
