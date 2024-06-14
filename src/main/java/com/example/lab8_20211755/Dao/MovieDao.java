package com.example.lab8_20211755.Dao;

import com.example.lab8_20211755.Entity.Movie;
import com.example.lab8_20211755.Entity.MovieAux;
import com.example.lab8_20211755.Entity.results;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieDao {
    public MovieAux listarPeliculasActuales(){
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwOGRkZTY0N2ViNTcxYjQ0NWMxZTJjYTAyNzAzOTc5OCIsInN1YiI6IjY2NmI4YmRjNTJjZjg0MzAzYjc2MjZhNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.i118CTvzWR3eU7SL8AOsz0IivxJT4niMcawwCNGX2ws");
        headers.set("accept","application/json");

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        try{
            ResponseEntity<MovieAux> responseEntity = restTemplate.exchange("https://api.themoviedb.org/3/movie/now_playing?language=es-PER", HttpMethod.GET, entity, MovieAux.class);
            return responseEntity.getBody();
        }catch (HttpClientErrorException.NotFound ex){
            return null;
        }

    }

    public Movie obtenerPeliculaPorTitulo(String title){
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwOGRkZTY0N2ViNTcxYjQ0NWMxZTJjYTAyNzAzOTc5OCIsInN1YiI6IjY2NmI4YmRjNTJjZjg0MzAzYjc2MjZhNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.i118CTvzWR3eU7SL8AOsz0IivxJT4niMcawwCNGX2ws");
        headers.set("accept","application/json");

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        try{
            ResponseEntity<MovieAux> responseEntity = restTemplate.exchange("https://api.themoviedb.org/3/discover/movie?language=es-PER&page=1&primary_release_year=2024", HttpMethod.GET, entity, MovieAux.class);
            MovieAux listaObtenida = listarPeliculasActuales();
            Movie movie = new Movie();
            boolean validacion = false;

            for(results pelicula:listaObtenida.getResults()){

                if(pelicula.getTitle().equals(title)){
                    validacion = true;
                    movie.setTitle(pelicula.getTitle());
                    movie.setOverview(pelicula.getOverview());
                    movie.setPopularity(pelicula.getPopularity());
                    movie.setReleaseDate(pelicula.getRelease_date());
                }
            }
            if(validacion){
                return movie;
            }else{
                return null;
            }

        }catch (HttpClientErrorException.NotFound ex){
            return null;
        }

    }


}
