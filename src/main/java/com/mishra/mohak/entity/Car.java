package com.mishra.mohak.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity {



    private String carBrand;

    private String carGear;

    @ElementCollection
    private List<String> carColor;

    private String carType;

    private String carYear;

    private boolean carAvailable;


    private String location;


    private Integer noOfSeats;


    @Column(columnDefinition = "LONGBLOB")
    @ElementCollection
    private List<Byte[]> images;


    @ManyToOne
    @JoinColumn(name = "adminId")
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
