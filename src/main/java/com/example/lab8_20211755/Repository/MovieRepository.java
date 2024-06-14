package com.example.lab8_20211755.Repository;

import com.example.lab8_20211755.Entity.Movie;
import com.example.lab8_20211755.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
