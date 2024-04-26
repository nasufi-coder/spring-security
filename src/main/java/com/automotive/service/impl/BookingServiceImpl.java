package com.automotive.service.impl;

import com.automotive.mapper.BookingMapper;
import com.automotive.models.dto.BookingDto;
import com.automotive.repository.AutoRepository;
import com.automotive.repository.BookingRepository;
import com.automotive.service.BookingService;
import com.automotive.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private final AutoRepository autoRepository;
    private final BookingMapper bookingMapper;
    private final UserService userService;
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(AutoRepository autoRepository, AutoServiceImpl autoService, AutoRepository autoRepository1, BookingMapper bookingMapper, UserService userService, BookingRepository bookingRepository) {
        this.autoRepository = autoRepository1;
        this.bookingMapper = bookingMapper;
        this.userService = userService;
        this.bookingRepository = bookingRepository;
    }


    @Override
    public void saveBooking(BookingDto bookingDto) {
        //get the user which is making the request
        var loggedInUser = userService.getLoggedInUsser();

        //map dto to model
        var bookingModel = bookingMapper.toModel(bookingDto);

        //get auto which is going to be booked
        var autoId = bookingDto.getAutoId();
        var autoToBook = autoRepository.findById(autoId).orElseThrow(() -> new IllegalArgumentException("Not able to find auto with id " + autoId));

        bookingModel.setBookedBy(loggedInUser);
        bookingModel.setBookedAuto(autoToBook);

        bookingRepository.save(bookingModel);
    }
}
