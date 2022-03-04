package com.springboot.trademe.use_cases.user.exposition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    public String paymentMethod;

    public UserDTO(Long userId, String lastname, String firstname, int age, String city, String phoneNumber, String email, String password, String trade, String paymentMethod) {
        this.userId = userId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.trade = trade;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", trade='" + trade + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
