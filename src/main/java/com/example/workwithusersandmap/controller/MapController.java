package com.example.workwithusersandmap.controller;

import com.example.workwithusersandmap.entities.Map;
import com.example.workwithusersandmap.entities.User;
import com.example.workwithusersandmap.services.MapServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class MapController{

    @Autowired
    private final MapServices mapServices;

    public MapController(MapServices mapServices){
        this.mapServices = mapServices;
    }

//    @GetMapping("/getUserCard/{id}")
//    public ArrayList<Map> getCards(@PathVariable Long id){
//        return mapServices.getAllCardUser(id);
//    }

    @PostMapping("/addCard")
    public Map createCard(@RequestBody Map map){
        return mapServices.createNewCard(map);
    }

    @GetMapping("/seeUserCard/{id}")
    public Optional<Map> getUserCards(@PathVariable Long id){
        return mapServices.getAllCardUser(id);
    }
}
