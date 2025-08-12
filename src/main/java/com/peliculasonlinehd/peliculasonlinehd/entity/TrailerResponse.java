package com.peliculasonlinehd.peliculasonlinehd.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TrailerResponse {

    private int id; // Id de la película
    @JsonProperty("results")
    private List<Trailer> trailerList;

    // CONSTRUCTOR
    public TrailerResponse(){

    }

    // GETTERS Y SETTERS

    public List<Trailer> getTrailerList() {
        return trailerList;
    }

    public void setTrailerList(List<Trailer> trailerList) {
        this.trailerList = trailerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
