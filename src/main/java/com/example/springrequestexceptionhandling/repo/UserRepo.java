package com.example.springrequestexceptionhandling.repo;

import com.example.springrequestexceptionhandling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUserId(int id);
}
