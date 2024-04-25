package com.automotive.models.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    private LocalDateTime bookedAt;
    private LocalDateTime bookedUntil;

    @ManyToOne()
    @JoinColumn(name = "bookedBy", referencedColumnName = "id")
    private UserEntity bookedBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookedAuto", referencedColumnName = "id")
    private AutoEntity bookedAuto;

}
