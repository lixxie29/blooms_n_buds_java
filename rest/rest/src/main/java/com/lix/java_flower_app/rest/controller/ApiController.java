package com.lix.java_flower_app.rest.controller;

import com.lix.java_flower_app.rest.models.User;
import com.lix.java_flower_app.rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value ="/")
    public String getPage(){
        return "welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return ">>> saved user";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setRole(user.getRole());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        userRepo.save(updatedUser);
        return ">>> updated user";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return ">>> deleted user with id: "+id;
    }
}
