package com.springboot.trademe.use_cases.user.domain;

import com.springboot.trademe.use_cases.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByCity(String city);
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);


}
