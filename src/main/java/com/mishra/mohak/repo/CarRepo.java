package com.mishra.mohak.repo;

import com.mishra.mohak.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, Integer> {
    Car findByName(String name);
}
