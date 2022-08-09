package com.example.workwithusersandmap.repositories;

import com.example.workwithusersandmap.entities.Map;
import com.example.workwithusersandmap.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserCardRepository extends JpaRepository<Map,Long> {
    @Query(value = "Select users.full_name, cards.number, cards.user_id from cards join users on users.id=cards.user_id where user_id=?1",nativeQuery = true)
    Optional<Map> getAllCardUser(Long id);
}
