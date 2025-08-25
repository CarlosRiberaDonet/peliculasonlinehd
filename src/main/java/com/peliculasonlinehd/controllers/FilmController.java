package com.peliculasonlinehd.controllers;

import com.peliculasonlinehd.dto.MovieResponse;
import com.peliculasonlinehd.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = "*")
public class FilmController {

    private final MovieService movieService;

    public FilmController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/upcoming")
    public MovieResponse proximasPeliculas(){
        return movieService.getUpcomingMovies();
    }

    @GetMapping("/playing")
    public MovieResponse carteleraPeliculas(){
        return movieService.getNowPlaying();
    }

    @GetMapping("/trendingDayMovies")
    public MovieResponse trendingDay(){
        return movieService.getTrendingDayMovies();
    }

    @GetMapping("/details/{id}")
    public MovieResponse detallesPelicula(@PathVariable ("id") int idPelicula){
        return movieService.getFilmDetails(idPelicula);
    }

    // Obtiene péliculas populares
    /*@GetMapping
    public MovieResponse listarPeliculas(@RequestParam(defaultValue = "1") int page) {
        Filters filters = new Filters(); // filtros vacíos
        return movieService.getMoviesByFilters(page, filters);
    }

    @PostMapping
    public MovieResponse listarPeliculas(@RequestParam int page, @RequestBody Filters filters) {
        return movieService.getMoviesByFilters(page, filters);
    }*/
}