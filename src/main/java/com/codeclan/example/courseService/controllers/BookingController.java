package com.codeclan.example.courseService.controllers;

import com.codeclan.example.courseService.models.Booking;
import com.codeclan.example.courseService.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getBookingsByDate(
        @RequestParam(name = "byDate", required = false) String date){
        if(date != null) {
            return new ResponseEntity<>(bookingRepository.findBookingByDate(date), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
        }
    }
}
