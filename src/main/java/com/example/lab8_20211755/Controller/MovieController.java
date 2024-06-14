package com.example.lab8_20211755.Controller;

import com.example.lab8_20211755.Dao.MovieDao;
import com.example.lab8_20211755.Entity.Movie;
import com.example.lab8_20211755.Entity.MovieAux;
import com.example.lab8_20211755.Entity.User;
import com.example.lab8_20211755.Entity.results;
import com.example.lab8_20211755.Repository.MovieRepository;
import com.example.lab8_20211755.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MovieController {

    private final MovieDao movieDao;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public MovieController(MovieDao movieDao,
                           UserRepository userRepository, MovieRepository movieRepository) {
        this.movieDao = movieDao;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
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

    @PostMapping("guardarFavorito")
    public ResponseEntity<HashMap<String,Object>> guardarPeliculaFavorita(@RequestParam(value = "titulo",required = false)String titulo,
                                                                   Authentication authentication){
        HashMap<String, Object> response = new HashMap<>();

        if(titulo==null|| titulo.isEmpty()){
            response.put("Estado","Error!");
            response.put("Película","Debe ingresar el título de la película que desee guardar como favorita.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Movie movie = movieDao.obtenerPeliculaPorTitulo(titulo);

        if(movie==null){
            response.put("Estado","No encontrado!");
            response.put("Película","No se encontró la película. Por favor, ingrese de manera correcta el título.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else{
            User user = userRepository.findByUsername(authentication.getName());
            movie.setUser(user);
            movieRepository.save(movie);
            response.put("Usuario",authentication.getName());
            response.put("Estado","Éxito!");
            response.put("Mensaje","Se guardó su película como favorita.");

            HashMap<String,Object>informacionPelicula=new HashMap<>();
            informacionPelicula.put("Título",movie.getTitle());
            informacionPelicula.put("Descripción",movie.getOverview());
            informacionPelicula.put("Popularidad",movie.getPopularity());
            informacionPelicula.put("Fecha de Lanzamiento",movie.getReleaseDate());

            response.put("Película",informacionPelicula);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
    }



}
