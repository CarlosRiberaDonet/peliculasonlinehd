package com.peliculasonlinehd.peliculasonlinehd.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peliculasonlinehd.peliculasonlinehd.dao.ApiDAO;
import com.peliculasonlinehd.peliculasonlinehd.dto.Filters;

import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import com.peliculasonlinehd.peliculasonlinehd.entity.Movie;
import com.peliculasonlinehd.peliculasonlinehd.entity.MovieResponse;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class MovieService {

    private final ApiDAO apiDAO;
    private final ObjectMapper mapper = new ObjectMapper();

    public MovieService(ApiDAO apiDAO){
        this.apiDAO = apiDAO;
    }

    // Obtiene lista de próximos estrenos
    public MovieResponse getUpcomingMovies(){
        String upcomingMoviesUrl = "https://api.themoviedb.org/3/movie/upcoming";
        try{
            String json = apiDAO.getFromApi(upcomingMoviesUrl);
            return mapper.readValue(json, MovieResponse.class);
        }catch (Exception e){
            System.out.println("Error al obtener la lista de peliculas desde getUpcomingMovies");
            e.printStackTrace();
        }
        return null;
    }

    // Obtiene lista de películas en cartelera
    public MovieResponse getNowPlaying(){
        String nowPlayingUrl = "https://api.themoviedb.org/3/movie/now_playing";
        try{
            String json = apiDAO.getFromApi(nowPlayingUrl);
            return mapper.readValue(json, MovieResponse.class);
        }catch (Exception e){
            System.out.println("Error al obtener la lista de peliculas desde getNowPlaying");
            e.printStackTrace();
        }
        return null;
    }

    // Obtiene trending day de películas
    public MovieResponse getTrendingDayMovies(){
        String trendingDayMoviesUrl = "https://api.themoviedb.org/3/trending/movie/day?";
        try{
            String json = apiDAO.getFromApi(trendingDayMoviesUrl);
            return mapper.readValue(json, MovieResponse.class);
        }catch (Exception e){
            System.out.println("Error al obtener la lista de peliculas desde getTrendingDayMovies");
            e.printStackTrace();
        }
        return null;
    }

    /*public MovieResponse getMoviesByFilters(int page, Filters filters){
        String filtersUrl = buildUrlFilters(page, filters);
        return apiDAO.getMovies(filtersUrl);
    }

    public String buildUrlFilters(int page, Filters filters) {
        StringBuilder filtersUrl = new StringBuilder("https://api.themoviedb.org/3/" +
                "discover/movie?page=").append(page);

        if (filters.isAdult()) {
            filtersUrl.append("&include_adult=true");
        } else {
            filtersUrl.append("&include_adult=false");
        }

        if (filters.getOriginalLanguage() != null && !filters.getOriginalLanguage().isEmpty()) {
            filtersUrl.append("&language=").append(filters.getOriginalLanguage());
        }

        if (filters.getGenreId() != null && !filters.getGenreId().isEmpty()) {
            String genres = filters.getGenreId().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            filtersUrl.append("&with_genres=").append(genres);
        }

        if (filters.getOriginalTitle() != null && !filters.getOriginalTitle().isEmpty()) {
            filtersUrl.append("&query=").append(URLEncoder.encode(filters.getOriginalTitle(),
                    StandardCharsets.UTF_8));
        }

        if (filters.getPopularity() > 0) {
            // No existe parámetro directo para filtrar por popularidad exacta,
            // pero puedes ordenar o usar mínimo
            filtersUrl.append("&sort_by=popularity.desc");
        }

        if (filters.getReleaseDate() != null) {
            filtersUrl.append("&primary_release_date.gte=").append(filters.getReleaseDate().
                    toString());
        }

        if (filters.getVoteAverage() > 0) {
            filtersUrl.append("&vote_average.gte=").append(filters.getVoteAverage());
        }

        if (filters.getVoteCount() > 0) {
            filtersUrl.append("&vote_count.gte=").append(filters.getVoteCount());
        }
        System.out.println("URL CREADA: " + filtersUrl);
        return filtersUrl.toString();
    }*/
}

