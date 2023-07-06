package com.codeclan.example.courseService.controllers;

import com.codeclan.example.courseService.models.Course;
import com.codeclan.example.courseService.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codeclan.example.courseService.helpers.CourseHelper;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;


//    @GetMapping(value = "/courses")
//    public ResponseEntity<List<Course>> getAllCourses(){
//        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
//    }
    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getCoursesByStarRating(
            @RequestParam(name = "byStarRating", required = false) Double starRating,
            @RequestParam(name = "byBookingsCustomerName", required = false) String customerName) {
    return CourseHelper.handleParams(customerName, starRating, courseRepository);
    };




 }
