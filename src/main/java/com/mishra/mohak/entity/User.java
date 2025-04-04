package com.mishra.mohak.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class User extends BaseEntity {


    private String userPassword;
    private String userEmail;
    private String userPhone;
    @Column(columnDefinition = "LONGBLOB")
    private byte[] userLicense;
    private String city;

    @ManyToMany(mappedBy = "users")
    private Set<Car> cars;
}
