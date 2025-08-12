package com.peliculasonlinehd.peliculasonlinehd.controllers;

import com.peliculasonlinehd.peliculasonlinehd.dao.ApiDAO;
import com.peliculasonlinehd.peliculasonlinehd.dto.Filters;
import com.peliculasonlinehd.peliculasonlinehd.entity.MovieResponse;
import com.peliculasonlinehd.peliculasonlinehd.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peliculas")
public class FilmController {

    private final MovieService movieService;

    public FilmController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public MovieResponse listarPeliculas(@RequestParam(defaultValue = "1") int page) {
        Filters filters = new Filters(); // filtros vacíos
        return movieService.getMoviesByFilters(page, filters);
    }

    @PostMapping
    public MovieResponse listarPeliculas(@RequestParam int page, @RequestBody Filters filters) {
        return movieService.getMoviesByFilters(page, filters);
    }
}