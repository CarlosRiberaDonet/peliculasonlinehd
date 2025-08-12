package com.peliculasonlinehd.peliculasonlinehd.controllers;

import com.peliculasonlinehd.peliculasonlinehd.dao.ApiDAO;
import com.peliculasonlinehd.peliculasonlinehd.dto.Filters;
import com.peliculasonlinehd.peliculasonlinehd.entity.MovieResponse;
import com.peliculasonlinehd.peliculasonlinehd.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("filters")
public class FiltersController {

    private final MovieService movieService;

    // Spring inyecta automáticamente la dependencia
    public FiltersController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/filmFilters")
    public MovieResponse getFilteredMovies(int page,Filters filters){

        // Delegar la lógica al servicio
        return movieService.getMoviesByFilters(page, filters);
    }
}