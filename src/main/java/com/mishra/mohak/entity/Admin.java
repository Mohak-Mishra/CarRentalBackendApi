package com.mishra.mohak.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    @NotBlank
    private String adminPassword;
    @Column(unique=true)
    @NotBlank
    private String adminEmail;
    @NotBlank
    private String adminPhone;

    @OneToMany(mappedBy = "admin")
    private List<Car> cars;
}
