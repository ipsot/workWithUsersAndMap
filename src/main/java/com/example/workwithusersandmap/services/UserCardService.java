package com.example.workwithusersandmap.services;

import com.example.workwithusersandmap.entities.Map;
import com.example.workwithusersandmap.entities.User;

import java.util.ArrayList;
import java.util.Optional;

public interface UserCardService {
    ArrayList<String> getAllCardUser(Long id);
}
