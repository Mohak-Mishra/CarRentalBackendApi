package com.mishra.mohak.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;

    private String carName;

    private String carBrand;

    private String carGear;

    private String carColor;

    private String carType;

    private String carYear;

    private boolean carAvailable;

    private String pickUp;


    private Integer noOfSeats;

    @ManyToOne
    @JoinColumn(name = "adminId",referencedColumnName = "adminId")
    private Admin admin;


    @ManyToMany
    @JoinTable(name = "user_and_car",
            joinColumns = {
            @JoinColumn(name="userId")
            },
            inverseJoinColumns = {
            @JoinColumn(name="carId")
            }
    )
    private List<User> users;

}
