package com.codeclan.example.courseService.repositories;

import com.codeclan.example.courseService.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByStarRating(double starRating);
    List<Course> findByBookingsCustomerName(String customerName);
}
