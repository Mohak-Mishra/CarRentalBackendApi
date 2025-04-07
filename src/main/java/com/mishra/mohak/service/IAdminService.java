package com.mishra.mohak.service;

import com.mishra.mohak.entity.Admin;
import com.mishra.mohak.entity.Car;

import java.util.List;

public interface IAdminService {
   Admin getAdmin(Integer id);
   void saveAdmin(Admin admin);
   void deleteAdmin(Integer admin);
   void updateAdmin(Admin admin);
   Admin getAdminByName(String name);
   void addCar(Car car);
}
