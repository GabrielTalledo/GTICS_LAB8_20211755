package com.example.lab8_20211755.Controller;

import com.example.lab8_20211755.Dao.MovieDao;
import com.example.lab8_20211755.Entity.MovieAux;
import com.example.lab8_20211755.Entity.results;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class MovieController {

    private final MovieDao movieDao;

    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @GetMapping("peliculasActuales")
    public ResponseEntity<HashMap<String, Object>> listarPeliculasActuales(Authentication authentication) {
        HashMap<String, Object> response = new HashMap<>();

        ArrayList<HashMap<String,Object>> listaPeliculas = new ArrayList<>();
        MovieAux listaObtenida = movieDao.listarPeliculasActuales();
        if(listaObtenida==null){
            response.put("Estado","Error!");
            response.put("Error","No hay peliculas por el momento.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        for(results pelicula:listaObtenida.getResults()){
            HashMap<String,Object>informacionPelicula=new HashMap<>();
            informacionPelicula.put("Título",pelicula.getTitle());
            informacionPelicula.put("Descripción",pelicula.getOverview());
            informacionPelicula.put("Popularidad",pelicula.getPopularity());
            informacionPelicula.put("Fecha de Lanzamiento",pelicula.getRelease_date());
            listaPeliculas.add(informacionPelicula);
        }
        response.put("Usuario",authentication.getName());
        response.put("Estado","Éxito!");
        response.put("Peliculas", listaPeliculas);
        return ResponseEntity.ok(response);
    }



}
