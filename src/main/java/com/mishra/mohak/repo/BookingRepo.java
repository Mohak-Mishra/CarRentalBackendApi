package com.mishra.mohak.repo;

import com.mishra.mohak.entity.Booking;
import com.mishra.mohak.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
    Booking findBookingByUser(User user);
}
