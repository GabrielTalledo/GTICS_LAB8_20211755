package com.example.lab8_20211755.Dao;

import com.example.lab8_20211755.Entity.MovieAux;
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
            ResponseEntity<MovieAux> responseEntity = restTemplate.exchange("https://api.themoviedb.org/3/movie/now_playing", HttpMethod.GET, entity, MovieAux.class);
            return responseEntity.getBody();
        }catch (HttpClientErrorException.NotFound ex){
            return null;
        }

    }
}
