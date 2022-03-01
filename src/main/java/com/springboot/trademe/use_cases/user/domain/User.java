package com.springboot.trademe.use_cases.user.domain;

import lombok.*;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long userId;

    @Column(name = "lastname", nullable = false)
    private  String lastname;

    @Column(name = "firstname", nullable = false)
    private  String firstname;

    @Column(name = "age", nullable = false)
    private  int age;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "phone number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private  String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "trade", nullable = false)
    private String trade;









/*    public void setTrade(String job){
        if(job== "Electrician"){this.trade = Trade.ELECTRICIAN;}
        if(job== "Mason"){this.trade = Trade.MASON;}
        if(job== "Plumber"){this.trade = Trade.PLUMBER;}
        if(job== "Carpenter"){this.trade = Trade.CARPENTER;}
    }*/

/*    public Trade getTradeFromString(String job){
        if(job== "Electrician"){return Trade.ELECTRICIAN;}
        if(job== "Mason"){return Trade.MASON;}
        if(job== "Plumber"){return Trade.PLUMBER;}
        if(job== "Carpenter"){return Trade.CARPENTER;}
        return null;
    }*/

  /*  public String getTradeString(Trade job){
        if(job== Trade.ELECTRICIAN){return "Electrician";}
        if(job== Trade.MASON){return "Mason";}
        if(job== Trade.PLUMBER){return "Plumber";}
        if(job== Trade.CARPENTER){return "Carpenter";}
        return null;
    }*/

  //  public void changePassword(String newPassword) {this.password = Objects.requireNonNull(newPassword);}
   // public void changeAddress(Address newAddress) {this.address = Objects.requireNonNull(newAddress);}









}