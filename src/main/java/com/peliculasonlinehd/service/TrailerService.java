package com.peliculasonlinehd.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peliculasonlinehd.dao.ApiDAO;
import com.peliculasonlinehd.dto.TrailerResponse;
import org.springframework.stereotype.Service;

@Service
public class TrailerService {

    private final ApiDAO apiDAO;
    private final ObjectMapper mapper = new ObjectMapper();

    public TrailerService(ApiDAO apiDAO){
        this.apiDAO = apiDAO;
    }

    public String getTrailerById(int idPelicula){
        String urlTrailer = "https://api.themoviedb.org/3/movie/" + idPelicula + "/videos";
        try{
            // Obtengo el JSON del API
            String json = apiDAO.getFromApi(urlTrailer);

            // Deserialize a TrailerResponse
            TrailerResponse trailerResponse = mapper.readValue(json, TrailerResponse.class);

            // Valido que la lista no sea nula o esté vacía
            if(trailerResponse.getTrailerList() != null && !trailerResponse.getTrailerList().isEmpty()){
                String key = trailerResponse.getTrailerList().get(0).getKey();

                // Construyo la URL completa de YouTube
                urlTrailer = "https://www.youtube.com/watch?v=" + key;
            }

            System.out.println("URL PELICULA: " + urlTrailer);
            return urlTrailer;

        }catch (Exception e){
            System.out.println("Error al obtener el trailer desde getTrailerById");
            e.printStackTrace();
        }

        return null;
    }
}
