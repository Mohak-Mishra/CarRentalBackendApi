package com.mishra.mohak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class CarRentalBackendApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRentalBackendApiApplication.class, args);
    }

}
