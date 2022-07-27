package com.example.springrequestexceptionhandling.service;

import com.example.springrequestexceptionhandling.dto.UserRequest;
import com.example.springrequestexceptionhandling.exception.UserNotFoundException;
import com.example.springrequestexceptionhandling.model.User;
import com.example.springrequestexceptionhandling.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repository;


    public User saveUser(UserRequest userRequest) {
        User user = User.
                build(0, userRequest.getName(), userRequest.getEmail(),
                        userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return repository.save(user);
    }


    public List<User> getALlUsers() {
        return repository.findAll();
    }


    public User getUser(int id) throws UserNotFoundException {
        User user= repository.findByUserId(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("user not found with id : "+id);
        }
    }
}
