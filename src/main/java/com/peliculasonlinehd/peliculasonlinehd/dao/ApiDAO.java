package com.peliculasonlinehd.peliculasonlinehd.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peliculasonlinehd.peliculasonlinehd.entity.MovieResponse;
import com.peliculasonlinehd.peliculasonlinehd.entity.Movie;
import com.peliculasonlinehd.peliculasonlinehd.entity.PeopleResponse;
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
    private final String BEARER_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5NmIyNGFiMmQzODIyNjFlY" +
            "jRiYWI2ODk0OWQ0NDliMSIsIm5iZiI6MTc1NDYxMzE0My4wNDgsInN1YiI6IjY4OTU0NTk3N2I0ZGYyYjA" +
            "0YjA3Yzg5ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.PPTJI_FGi5ApA8sY0T61Zv" +
            "X--gONMVDhlVi_hTeEpvU";

    // Conexión a la API → devuelve siempre JSON en String
    public String getFromApi(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("Authorization", "Bearer " + BEARER_TOKEN);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
        return response.getBody();
    }
}
