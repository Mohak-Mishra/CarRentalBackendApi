package com.mishra.mohak.repo;

import com.mishra.mohak.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
    Admin findByName(String name);
}
