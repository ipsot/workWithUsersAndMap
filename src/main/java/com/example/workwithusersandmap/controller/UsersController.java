package com.example.workwithusersandmap.controller;

import com.example.workwithusersandmap.entities.User;
import com.example.workwithusersandmap.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    private final UserServices userServices;

    public UsersController(UserServices userServices){
        this.userServices=userServices;
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) throws Exception{
        return userServices.createUser(user);
    }

    @GetMapping()
    public ArrayList<User> getAll()throws Exception{
        return userServices.getAll();
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id)
    {
        return userServices.findUserById(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user)throws Exception{
        return userServices.updateById(id,user);
    }

    @PutMapping("/updateUserNumber/{id}/{number}")
    public User updateUserNumber(@PathVariable Long id, @PathVariable String number,@RequestBody User user) throws Exception{
        return userServices.updateUserNumber(id,number,user);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) throws Exception{
        userServices.deleteById(id);
    }

}
