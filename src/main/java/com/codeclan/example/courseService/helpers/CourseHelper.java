package com.codeclan.example.courseService.helpers;

import com.codeclan.example.courseService.models.Course;
import com.codeclan.example.courseService.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Entity;
import java.util.List;

public class CourseHelper {


    static public ResponseEntity<List<Course>> handleParams(String customerName, Double starRating, CourseRepository courseRepository){
        if(customerName != null){
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerName(customerName), HttpStatus.OK);
        } else if (starRating != null) {
            return new ResponseEntity<>(courseRepository.findByStarRating(starRating), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
        }
    };
//        private ResponseEntity<List<Course>> findByBookingsCustomerName;
//
//
//    @RequestParam(name = "byStarRating", required = false) double starRating
//    public ResponseEntity<List<Course>> getCoursesByParam(
//            @RequestParam(name = "byBookingsCustomerName", required = false) String customerName,
//            @RequestParam(name = "byStarRating", required = false) double starRating) {

}
