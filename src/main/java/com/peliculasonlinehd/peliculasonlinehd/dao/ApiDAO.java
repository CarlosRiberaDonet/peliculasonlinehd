package com.peliculasonlinehd.peliculasonlinehd.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peliculasonlinehd.peliculasonlinehd.entity.MovieResponse;
import com.peliculasonlinehd.peliculasonlinehd.entity.Movie;
import com.peliculasonlinehd.peliculasonlinehd.entity.TrailerResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Repository
public class ApiDAO {

    // Cliente HTTP para realizar peticiones REST
    private final RestTemplate restTemplate = new RestTemplate();

    // Token Bearer de acceso para la API TMDB
    private final String BEARER_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5NmIyNGFiMmQzODIyNjFlYjRiYWI2ODk0OWQ0NDliMSIsIm5iZiI6MTc1NDYxMzE0My4wNDgsInN1YiI6IjY4OTU0NTk3N2I0ZGYyYjA0YjA3Yzg5ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.PPTJI_FGi5ApA8sY0T61ZvX--gONMVDhlVi_hTeEpvU";

    /**
     * Obtiene películas desde TMDB usando filtros y página en la query.
     * @return MovieResponse deserializado con resultados de películas
     */

    // Conexión a la API
    public <T> T connectAPI(String url, ParameterizedTypeReference<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("Authorization", "Bearer " + BEARER_TOKEN);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<T> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                responseType
        );

        return response.getBody();
    }

    // Obtiene catálogo de películas
    public MovieResponse getMovies(String url) {
        return connectAPI(url, new ParameterizedTypeReference<MovieResponse>() {});
    }

    // Conexión a la API para obtener el trailer de la película
    public TrailerResponse getTrailer(String url){
        return connectAPI(url, new ParameterizedTypeReference<TrailerResponse>() {});
    }


    // Deserializar JSON
    public List<Movie> deserializerJson(String jsonString){
        ObjectMapper mapper = new ObjectMapper();
        try{
            MovieResponse movieResponse = mapper.readValue(jsonString, MovieResponse.class);

        } catch (IOException e) {
            System.out.println("Error ApiDao -> deserializerJson");
            e.printStackTrace();
        }
        return null;
    }
}