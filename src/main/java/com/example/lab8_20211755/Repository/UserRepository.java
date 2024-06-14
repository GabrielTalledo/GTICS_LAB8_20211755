package com.example.lab8_20211755.Repository;

import com.example.lab8_20211755.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNombre(String nombre);
    User findByUsername(String username);
}

