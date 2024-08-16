package com.automotive.controller;

import com.automotive.models.MessageResponse;
import com.automotive.models.dto.BookingDto;
import com.automotive.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


    @GetMapping("/cars/{carId}/booked-dates")
    public List<Object[]> getBookedDates(@PathVariable Integer carId) {
        return bookingService.getBookedDatesForCar(carId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookingDto>> getAll() throws Exception {

        return ResponseEntity
                .ok()
                .body(bookingService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getOne(@PathVariable Integer id) throws Exception {

        return ResponseEntity
                .ok()
                .body(bookingService.getOne(id));
    }
}
