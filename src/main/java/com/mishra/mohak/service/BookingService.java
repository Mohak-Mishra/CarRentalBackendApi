package com.mishra.mohak.service;

import com.mishra.mohak.entity.Booking;
import com.mishra.mohak.entity.Car;
import com.mishra.mohak.entity.User;
import com.mishra.mohak.exceptions.BookingNotFoundException;
import com.mishra.mohak.repo.BookingRepo;
import com.mishra.mohak.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService implements Serializable ,IBookingService {
    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    ICarService carService;
    @Override
    public Integer book(Booking booking, Car car) {
        booking.setCreatedAt(LocalDateTime.now());
        car.setCarAvailable(false);
        bookingRepo.save(booking);
        carService.updateCar(car);
        return booking.getId();
    }

    @Override
    public Integer modifyBooking(Booking booking) {
        if(bookingRepo.existsById(booking.getId())) {
            booking.setLastModifiedAt(LocalDateTime.now());
            bookingRepo.save(booking);
            return booking.getId();
        }
        throw new BookingNotFoundException("no booking is found");
    }

    @Override
    public void clearBooking(Integer id, Car car) {

        if(bookingRepo.existsById(id)) {
            bookingRepo.deleteById(id);
            car.setCarAvailable(false);
        }
        throw new BookingNotFoundException("no booking is found");
    }

    @Override
    public Booking showBooking(User user) {
       return bookingRepo.findBookingByUser(user);
    }

    public Booking getBookingById(Integer id) {
        return bookingRepo.getReferenceById(id);
    }

    public List<Car> getAllCars() {
        List<Car> cars = carService.getAllCars();
        cars.removeIf(car -> !car.isCarAvailable());
        return cars;
    }
}
