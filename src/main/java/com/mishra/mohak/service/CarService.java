package com.mishra.mohak.service;

import com.mishra.mohak.entity.Car;
import com.mishra.mohak.exceptions.CarNotFoundException;
import com.mishra.mohak.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CarService implements ICarService {
    @Autowired
    CarRepo carRepo;


    @Override
    public void insertCar(Car car) {
        car.setCreatedAt(LocalDateTime.now());
        carRepo.save(car);
    }

    @Override
    public Car getCarById(Integer id) {
        return carRepo.findById(id).orElseThrow(()->new CarNotFoundException("Car not found"));
    }

    @Override
    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    @Override
    public void updateCar(Car car) {
        if(carRepo.existsById(car.getCarId())){
            car.setLastModifiedAt(LocalDateTime.now());
            Car c=getCarById(car.getCarId());
            carRepo.save(c);
        }
        else{
            throw new CarNotFoundException("Car not found");
        }

    }

    @Override
    public void deleteCarById(Integer id) {
        Car c=getCarById(id);
        carRepo.delete(c);
    }

    @Override
    public Car getCarByName(String name) {
        Car c=carRepo.findByCarName(name);
        if(c==null) {throw new CarNotFoundException("Car not found");}
        return c;
    }
}
