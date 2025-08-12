package com.peliculasonlinehd.peliculasonlinehd.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieResponse {

    private int page;
    @JsonProperty("results") // El campo "results" del JSON mapea a peliculasList
    private List<Movie> peliculasList;

    // CONSTRUCTOR
    public MovieResponse(List<Movie> peliculasList){
        this.peliculasList = peliculasList;
    }

    public MovieResponse(){

    }

    // GETTERS Y SETTERS
    public int getPage(){
        return page;
    }

    public void setPage(int page){
        this.page = page;
    }

    public List<Movie> getPeliculasList(){
        return peliculasList;
    }

    public void setPeliculasList(List<Movie> peliculaList){
        this.peliculasList = peliculaList;
    }
}
