package com.springboot.trademe.use_cases.user.exposition;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserDTO {


    public Long userId;

    @NotEmpty(message = "lastname should not be null or empty")
    public String lastname;

    @NotEmpty(message = "firstname should not be null or empty")
    public String firstname;
    public int age;

    @NotEmpty(message = "city should not be null or empty")
    public String city;

    @NotEmpty(message = "city should not be null or empty")
    @Pattern(regexp="(^$|[0-9]{10})")
    public String phoneNumber;

    @NotEmpty(message = "email should not be null or empty")
    @Email
    public String email;

    @NotEmpty(message = "password should not be null or empty")
    public String password;

    @NotEmpty(message = "trade should not be null or empty")
    public String trade;

    @NotEmpty(message = "paymentMethod should not be null or empty")
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
