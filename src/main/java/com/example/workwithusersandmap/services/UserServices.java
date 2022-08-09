package com.example.workwithusersandmap.services;

import com.example.workwithusersandmap.entities.User;
import com.example.workwithusersandmap.repositories.UserCardRepository;
import com.example.workwithusersandmap.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserCardRepository userCardRepository;


    public UserServices(UserRepository userRepository, UserCardRepository userCardRepository) {
        this.userRepository = userRepository;
        this.userCardRepository = userCardRepository;
    }

    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public ArrayList<User> getAll(){
        return (ArrayList<User>) userRepository.findAll();
    }
    public User updateById(Long id,User user){
        userRepository.findById(id);
        return userRepository.saveAndFlush(user);

    }

    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }

    public User updateUserNumber(Long id, String newNumber,User user){
        userRepository.findById(id);
        user.getId();
        user.setNumber(newNumber);
        user.getFullName();
        user.getMaps();

        return userRepository.saveAndFlush(user);

    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
