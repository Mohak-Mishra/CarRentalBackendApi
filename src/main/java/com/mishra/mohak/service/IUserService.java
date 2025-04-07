package com.mishra.mohak.service;

import com.mishra.mohak.entity.User;
import com.mishra.mohak.entity.Car;
import java.util.List;

public interface IUserService {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);


}
