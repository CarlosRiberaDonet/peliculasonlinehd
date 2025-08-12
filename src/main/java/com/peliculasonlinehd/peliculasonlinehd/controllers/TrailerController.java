package com.peliculasonlinehd.peliculasonlinehd.controllers;

import com.peliculasonlinehd.peliculasonlinehd.entity.TrailerResponse;
import com.peliculasonlinehd.peliculasonlinehd.service.TrailerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trailer")
public class TrailerController {

    private final TrailerService trailerService;

    public TrailerController(TrailerService trailerService){
        this.trailerService = trailerService;
    }

    @GetMapping("/{idPelicula}")
    public String getTrailer(@PathVariable int idPelicula){
        System.out.println("ID PELICULA: " + idPelicula);

        return trailerService.getTrailerById(idPelicula);
    }
}
