package com.codeclan.example.courseService.controllers;

import com.codeclan.example.courseService.models.Course;
import com.codeclan.example.courseService.models.Customer;
import com.codeclan.example.courseService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomersByCourseName(
            @RequestParam(name = "byBookingsCourseName", required = false) String courseName) {
        if(courseName != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(courseName), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
        }
    }
}
