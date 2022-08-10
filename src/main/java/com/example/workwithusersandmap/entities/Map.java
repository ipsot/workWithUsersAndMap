package com.example.workwithusersandmap.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "cards")
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String number;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime expirationDate;

    private boolean isBlock;


    public Map(){}

    public Map(String number, LocalDateTime expirationDate, boolean isBlock) { //(Been User user)

        this.number = number;
        this.expirationDate = expirationDate;
        this.isBlock = isBlock;
//        this.user=user;
    }

    public Map(Long id, String number, LocalDateTime expirationDate, boolean block) { //Been User user
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

//    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
//    private User user;
}
