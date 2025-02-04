package com.automotive.repository;

import com.automotive.models.entity.AutoEntity;
import com.automotive.models.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

    @Transactional
    @Query(nativeQuery = true, value = "Select * from bookings where booked_By = ?1")
    List<BookingEntity> findByUser(Integer userID);

    @Transactional
    @Query(nativeQuery = true, value = "Select * from bookings where booked_By = ?1 and id = ?2")
    Optional<BookingEntity> findOneByUserAndBooking(Integer userID, Integer bookingID);

    @Transactional
    @Query(nativeQuery = true, value = "Select * from bookings where booked_Auto = ?1")
    Optional<BookingEntity> findOneByAuto(Integer autoID);

    @Query("SELECT b.bookedFrom, b.bookedUntil FROM BookingEntity b WHERE b.bookedAuto.id = :carId")
    List<Object[]> findBookedDatesByCarId(@Param("carId") Integer carId);

    @Query("SELECT b FROM BookingEntity b WHERE b.bookedAuto = :auto AND " +
            "(b.bookedFrom < :endDate AND b.bookedUntil > :startDate)")
    List<BookingEntity> findOverlappingBookings(
            @Param("auto") AutoEntity auto,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
