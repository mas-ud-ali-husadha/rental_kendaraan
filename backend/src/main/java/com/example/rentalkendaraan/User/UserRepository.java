package com.example.rentalkendaraan.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Bertugas untuk operasi terhadap database
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
