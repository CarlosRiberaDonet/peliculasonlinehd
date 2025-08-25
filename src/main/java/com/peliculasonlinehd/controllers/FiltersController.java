package com.peliculasonlinehd.controllers;

import com.peliculasonlinehd.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("filters")
public class FiltersController {

    private final MovieService movieService;

    // Spring inyecta automáticamente la dependencia
    public FiltersController(MovieService movieService) {
        this.movieService = movieService;
    }

   /* @PostMapping("/filmFilters")
    public MovieResponse getFilteredMovies(int page,Filters filters){

        // Delegar la lógica al servicio
        return movieService.getMoviesByFilters(page, filters);
    }*/
}