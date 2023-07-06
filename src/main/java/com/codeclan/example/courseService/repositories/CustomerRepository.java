package com.codeclan.example.courseService.repositories;

import com.codeclan.example.courseService.models.Course;
import com.codeclan.example.courseService.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseNameIgnoreCase(String courseName);
}
