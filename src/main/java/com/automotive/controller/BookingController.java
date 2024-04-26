package com.automotive.controller;

import com.automotive.models.MessageResponse;
import com.automotive.models.dto.BookingDto;
import com.automotive.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;

    @PostMapping("/saveBooking")
    public ResponseEntity<?> register(@RequestBody BookingDto bookingDto) throws Exception {

        bookingService.saveBooking(bookingDto);
        return ResponseEntity
                .ok()
                .body(new MessageResponse("Auto is successfully booked!"));
    }
}
