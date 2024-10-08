package com.automotive.service;

import com.automotive.models.dto.BookingDto;

import java.util.List;

public interface BookingService {

    void saveBooking(BookingDto bookingDto);

    List<BookingDto> getAll();
    List<Object[]> getBookedDatesForCar(Integer autoID);

    BookingDto getOne(Integer id);

    void deleteOne(Integer id);

}
