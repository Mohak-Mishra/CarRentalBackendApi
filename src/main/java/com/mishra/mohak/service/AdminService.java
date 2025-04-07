package com.mishra.mohak.service;

import com.mishra.mohak.entity.Admin;
import com.mishra.mohak.entity.Car;
import com.mishra.mohak.exceptions.AdminNotFoundException;
import com.mishra.mohak.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {
    @Autowired
    AdminRepo adminRepo;

    public Admin getAdmin(Integer id) {
        return adminRepo.findById(id).orElseThrow(()->new AdminNotFoundException("admin not found"));
    }

    @Override
    public void saveAdmin(Admin admin) {
        adminRepo.save(admin);
    }

    @Override
    public void deleteAdmin(Integer id) {
        if(adminRepo.existsById(id)) adminRepo.deleteById(id);
        else throw new AdminNotFoundException("admin not found");
    }

    @Override
    public void updateAdmin(Admin admin) {
        if(adminRepo.existsById(admin.getAdminId())) adminRepo.save(admin);
        else throw new AdminNotFoundException("admin not found");
    }

    @Override
    public Admin getAdminByName(String name) {
        return adminRepo.findByAdminName(name);
    }

    @Override
    public void addCar(Car car) {
        CarService carService = new CarService();
        carService.insertCar(car);
    }
}
