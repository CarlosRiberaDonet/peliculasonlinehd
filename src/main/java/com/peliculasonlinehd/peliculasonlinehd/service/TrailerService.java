package com.peliculasonlinehd.peliculasonlinehd.service;

import com.peliculasonlinehd.peliculasonlinehd.dao.ApiDAO;
import com.peliculasonlinehd.peliculasonlinehd.entity.Trailer;
import com.peliculasonlinehd.peliculasonlinehd.entity.TrailerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrailerService {

    private final ApiDAO apiDAO;
    //private final TrailerResponse trailerResponse;

    public TrailerService(ApiDAO apiDAO){
        this.apiDAO = apiDAO;
    }

    /*public TrailerService(TrailerResponse trailerResponse){
        this.trailerResponse = trailerResponse;
    }*/

    public String getTrailerById(int idPelicula){
        String urlTrailer = "";
        // Obtengo la lista de trailers en formato JSON mediante
        TrailerResponse trailerJson = apiDAO.getTrailer("https://api.themoviedb.org/3/movie/" + idPelicula + "/videos");

        // Extraigo la lista de trailers del JSON
        List<Trailer> trailerList = trailerJson.getTrailerList();

        // Valido que la lista no sea nula o esté vacía
        if(trailerList != null && !trailerList.isEmpty()){
            String key = trailerList.get(0).getKey();

            // Construyo la URL completa
            urlTrailer = "https://www.youtube.com/watch?v=" + key;
        }
        System.out.println("URL PELICULA: " + urlTrailer);
        return urlTrailer;
    }
}
