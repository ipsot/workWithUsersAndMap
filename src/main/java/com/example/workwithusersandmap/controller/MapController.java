package com.example.workwithusersandmap.controller;

import com.example.workwithusersandmap.entities.Map;
import com.example.workwithusersandmap.entities.User;
import com.example.workwithusersandmap.repositories.UserCardRepository;
import com.example.workwithusersandmap.repositories.UserRepository;
import com.example.workwithusersandmap.services.MapServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class MapController{

    @Autowired
    private final MapServices mapServices;

    private final UserRepository userRepository;
    private final UserCardRepository userCardRepository;

    public MapController(MapServices mapServices,UserRepository userRepository,UserCardRepository userCardRepository){
        this.mapServices = mapServices;
        this.userRepository=userRepository;
        this.userCardRepository=userCardRepository;

    }

//    @GetMapping("/getUserCard/{id}")
//    public ArrayList<Map> getCards(@PathVariable Long id){
//        return mapServices.getAllCardUser(id);
//    }

    @PostMapping("/addCardFor/{id}")
    public Map createCard(@RequestBody Map map,@PathVariable Long id){


        Map finalMap = map;
        map=userRepository.findById(id).map(card->{card.getMaps().add(finalMap);
            return userCardRepository.saveAndFlush(finalMap);}).orElse(null);

        return userCardRepository.saveAndFlush(map);
    }

    @GetMapping("/seeUserCard/{id}")
    public ArrayList<String> getUserCards(@PathVariable Long id){
        return mapServices.getAllCardUser(id);
    }

    @PutMapping("/blockCard/{id}")
    public Map blockCard(@PathVariable Long id){
        return mapServices.blockingCard(id);
    }
}
