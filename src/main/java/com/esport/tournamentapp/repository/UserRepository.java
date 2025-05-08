package com.esport.tournamentapp.repository;

import com.esport.tournamentapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findByEmailContainingIgnoreCase(String email);
    User findByEmail(String email);

}