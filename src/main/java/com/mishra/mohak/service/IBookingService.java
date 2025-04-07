package com.mishra.mohak.service;

import com.mishra.mohak.entity.Booking;
import com.mishra.mohak.entity.User;

public interface IBookingService {
    Integer book(Booking booking);
    Integer modifyBooking(Booking booking);
    void clearBooking(Integer booking);
    Booking showBooking(User user);
}
