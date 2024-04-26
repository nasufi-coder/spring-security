package com.automotive.repository;

import com.automotive.models.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {

}
