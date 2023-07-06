package com.codeclan.example.courseService.others;

import com.codeclan.example.courseService.models.Booking;
import com.codeclan.example.courseService.models.Course;
import com.codeclan.example.courseService.models.Customer;
import com.codeclan.example.courseService.repositories.BookingRepository;
import com.codeclan.example.courseService.repositories.CourseRepository;
import com.codeclan.example.courseService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Profile("!test")
//@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {
    };
    public void run(ApplicationArguments args){
        Customer john = new Customer("John", "Edinburgh", 30);
        customerRepository.save(john);
        Course pythonBasics = new Course("Python Basics", "Edinburgh", 4.2);
        courseRepository.save(pythonBasics);
        Booking booking1 = new Booking("31/03/2023", pythonBasics, john);
        bookingRepository.save(booking1);

        Customer jack = new Customer("Jack", "Edinburgh", 27);
        customerRepository.save(jack);
        Course javaBasics = new Course("Java Basics", "Edinburgh", 4.6);
        courseRepository.save(javaBasics);
        Booking booking2 = new Booking("31/06/2023", javaBasics, jack);
        bookingRepository.save(booking2);

        Customer ann = new Customer("Ann", "Glasgow", 33);
        customerRepository.save(ann);
        Course jsBasics = new Course("JS Basics", "Glasgow", 4.9);
        courseRepository.save(jsBasics);
        Booking booking3 = new Booking("31/04/2023", jsBasics, ann);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("31/09/2023", javaBasics, john);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("31/09/2023", jsBasics, jack);
        bookingRepository.save(booking5);

    }
}
