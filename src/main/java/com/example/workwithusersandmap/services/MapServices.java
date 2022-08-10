package com.example.workwithusersandmap.services;

import com.example.workwithusersandmap.entities.Map;
import com.example.workwithusersandmap.entities.User;
import com.example.workwithusersandmap.repositories.UserCardRepository;
import com.example.workwithusersandmap.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MapServices implements UserCardService {

    @Autowired
    private final UserCardRepository userCardRepository;
    @Autowired
    private final UserRepository userRepository;

    public MapServices(UserCardRepository userCardRepository, UserRepository userRepository) {
        this.userCardRepository = userCardRepository;
        this.userRepository = userRepository;
    }

    public Map createNewCard(Map map) {
        return userCardRepository.saveAndFlush(map);
    }

//    public Optional<User> getAllCardUser(Long id) {
//
//    }

    public Map blockingCard(Long id) {
        Map userCards = userCardRepository.findById(id).orElse(null);
        if (userCards != null) {
            if (!userCards.isBlock()) {
                userCards.setBlock(true);
            }
        }
        return userCardRepository.saveAndFlush(userCards);
    }

    @Override
    public ArrayList<String> getAllCardUser(Long id){
        var result=userCardRepository.getAllCardUser(id);
        return result;
    }
}
