package com.mishra.mohak.service;

import com.mishra.mohak.entity.Car;

import java.util.List;

public interface ICarService {
    void insertCar(Car car);
    Car getCarById(Integer id);
    List<Car> getAllCars();
    void updateCar(Car car);
    void deleteCarById(Integer id);
    Car getCarByName(String name);
}
