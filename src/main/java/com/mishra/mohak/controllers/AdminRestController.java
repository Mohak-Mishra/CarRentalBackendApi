package com.mishra.mohak.controllers;

import com.mishra.mohak.entity.Admin;
import com.mishra.mohak.entity.Car;
import com.mishra.mohak.service.AdminService;
import com.mishra.mohak.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/admin")
public class AdminRestController {
    @Autowired
    IAdminService adminService;


    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Admin admin) {
       adminService.saveAdmin(admin);
      return new ResponseEntity<String>("admin got saved", HttpStatus.CREATED);
    }

    @GetMapping("/getAdminById/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable Integer id) {
        Admin a= adminService.getAdmin(id);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping("/getAdminByName/{name}")
    public ResponseEntity<Admin> getAdminByName(@PathVariable String name) {
        return new ResponseEntity<>(adminService.getAdminByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity<String>("admin got deleted", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
        return new ResponseEntity<>("admin got updated", HttpStatus.OK);
    }

    @PostMapping("/addCar")
    public ResponseEntity<String> addCar(@RequestBody Car car) {
        adminService.addCar(car);
        return new ResponseEntity<>("car got added", HttpStatus.CREATED);
    }

}
