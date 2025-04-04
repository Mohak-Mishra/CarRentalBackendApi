package com.mishra.mohak.repo;

import com.mishra.mohak.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
