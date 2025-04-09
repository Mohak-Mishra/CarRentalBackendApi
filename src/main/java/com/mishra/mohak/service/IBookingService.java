package com.mishra.mohak.service;

import com.mishra.mohak.entity.Booking;
import com.mishra.mohak.entity.Car;
import com.mishra.mohak.entity.User;

public interface IBookingService {
    Integer book(Booking booking, Car car);
    Integer modifyBooking(Booking booking);
    void clearBooking(Integer booking, Car car);
    Booking showBooking(User user);
}
