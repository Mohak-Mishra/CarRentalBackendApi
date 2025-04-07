package com.mishra.mohak.service;

import com.mishra.mohak.entity.Booking;
import com.mishra.mohak.entity.User;
import com.mishra.mohak.exceptions.BookingNotFoundException;
import com.mishra.mohak.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
@Service
public class BookingService implements Serializable ,IBookingService {
    @Autowired
    BookingRepo bookingRepo;
    @Override
    public Integer book(Booking booking) {
        bookingRepo.save(booking);
        return booking.getId();
    }

    @Override
    public Integer modifyBooking(Booking booking) {
        if(bookingRepo.existsById(booking.getId())) {
            bookingRepo.save(booking);
            return booking.getId();
        }
        throw new BookingNotFoundException("no booking is found");
    }

    @Override
    public void clearBooking(Integer id) {
        if(bookingRepo.existsById(id)) {
            bookingRepo.deleteById(id);

        }
        throw new BookingNotFoundException("no booking is found");
    }

    @Override
    public Booking showBooking(User user) {
       return bookingRepo.findBookingByUser(user);
    }
}
