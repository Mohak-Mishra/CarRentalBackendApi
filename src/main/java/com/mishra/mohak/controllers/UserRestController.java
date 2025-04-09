package com.mishra.mohak.controllers;

import com.mishra.mohak.entity.Booking;
import com.mishra.mohak.entity.Car;
import com.mishra.mohak.entity.User;
import com.mishra.mohak.service.BookingService;
import com.mishra.mohak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/user")
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;


    @PostMapping("/sign/up")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>("User got signed Up", HttpStatus.CREATED);
    }

    @GetMapping("/show/booking/{id}")
    public ResponseEntity<String> showBooking(@PathVariable int id) {
        bookingService.getBookingById(id);
        return new ResponseEntity<>("User got booking", HttpStatus.OK);
    }

    @PostMapping("/do/booking")
    public ResponseEntity<Integer> doBooking(@RequestBody Booking booking,@RequestBody Car car) {
        bookingService.book(booking,car);
        return new ResponseEntity<>(booking.getId(),HttpStatus.CREATED);
    }

    @DeleteMapping("/cancel/booking")
    public ResponseEntity<String> cancelBooking(@RequestBody Booking booking, @RequestBody Car car) {
        bookingService.clearBooking(booking.getId(),car);
        return new ResponseEntity<>("User got cancelled", HttpStatus.OK);
    }

    @PostMapping("/show/cars")
    public ResponseEntity<List<Car>> showCars() {
        return new ResponseEntity<>(bookingService.getAllCars(), HttpStatus.OK);
    }
}
