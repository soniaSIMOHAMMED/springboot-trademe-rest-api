package com.springboot.trademe.use_cases.user.application.create;

import com.springboot.trademe.kernel.Command;

public class CreateUser implements Command {

    public String lastname;
    public String firstname;
    public int age;
    public String city;
    public String phoneNumber;
    public String email;
    public String password;
    public String trade;
    public String paymentMethod;

    public CreateUser(String lastname, String firstname, int age, String city, String phoneNumber, String email, String password, String trade, String paymentMethod) {
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
}
