package com.example.lab8_20211755.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie", nullable = false)
    private Integer id;

    @Column(name = "overview", nullable = false, length = 256)
    private String nombre;

    @Column(name = "popularity", nullable = false)
    private Float popularity;

    @Column(name = "release_date", nullable = false, length = 256)
    private String releaseDate;

    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
    private User user;
}
