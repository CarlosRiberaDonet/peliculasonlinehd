package com.peliculasonlinehd.peliculasonlinehd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class Filters {
    private boolean adult;
    @JsonProperty("genre_ids")
    private List<Integer> genreId;
    @JsonProperty("original_language")
    private String originalLanguage;
    private String language;
    @JsonProperty("original_title")
    private String originalTitle;
    private double popularity;
    @JsonProperty("release_date")
    private String releaseDate;
    private String title;
    @JsonProperty("vote_average")
    private double voteAverage;
    @JsonProperty("vote_count")
    private int voteCount;

    //CONSTRUCTOR

    public Filters(boolean adult, List<Integer> genreId, String originalLanguage, String language, String originalTitle, double popularity, String releaseDate, String title, double voteAverage, int voteCount) {
        this.adult = adult;
        this.genreId = genreId;
        this.originalLanguage = originalLanguage;
        this.language = language;
        this.originalTitle = originalTitle;
        this.popularity = popularity;
        this.releaseDate = releaseDate;
        this.title = title;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public Filters(boolean adult) {
        this.adult = adult;
    }

    public Filters(){

    }

    // GETTERS Y SETTERS

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public List<Integer> getGenreId() {
        return genreId;
    }

    public void setGenreId(List<Integer> genreId) {
        this.genreId = genreId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public String toString() {
        return "Filters{" +
                "adult=" + adult +
                ", genreId=" + genreId +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", popularity=" + popularity +
                ", releaseDate=" + releaseDate +
                ", title='" + title + '\'' +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}';
    }
}
