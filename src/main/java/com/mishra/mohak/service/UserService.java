package com.mishra.mohak.service;

import com.mishra.mohak.entity.User;
import com.mishra.mohak.exceptions.UserNotFoundException;
import com.mishra.mohak.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void updateUser(User user) {
        if(userRepo.existsById(user.getUserId())) {
            userRepo.save(user);
        }
        else{
            throw new UserNotFoundException("User not found");
        }

    }

    @Override
    public void deleteUser(Integer id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        }
        else{
            throw new UserNotFoundException("User not found");
        }
    }
}
