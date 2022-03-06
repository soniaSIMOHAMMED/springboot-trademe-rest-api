package com.springboot.trademe.use_cases.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByCity(String city);
    User getByLastname(String lastname);
    User getByEmail(String email);
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    //List<User> findByCreatedDate(Instant now);
    //List<User> findByCreatedDate(int localDate);
    List<User> findByTradeAndCreatedDate(String trade, int localDate);



}
