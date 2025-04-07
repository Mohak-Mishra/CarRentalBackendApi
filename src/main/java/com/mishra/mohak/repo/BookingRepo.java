package com.mishra.mohak.repo;

import com.mishra.mohak.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
    Booking findBookingByUserId(Integer userId);
}
