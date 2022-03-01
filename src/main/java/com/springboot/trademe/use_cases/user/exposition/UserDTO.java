package com.springboot.trademe.use_cases.user.exposition;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class UserDTO {


    public Long userId;
    public String lastname;
    public String firstname;
    public int age;
    public String city;
    public String phoneNumber;
    public String email;
    public String password;
    public String trade;

    public UserDTO(Long userId, String lastname, String firstname, int age, String city, String phoneNumber, String email, String password, String trade) {
        this.userId = userId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.trade = trade;
    }
}
