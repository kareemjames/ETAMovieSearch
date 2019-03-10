package com.detroitlabs.moviesearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieBasic {

    private String title;
    private String year;
    private String imdbID;
    private String type;
    private String poster;

    @Override
    public String toString() {
        return "MovieBasic " +
                " Title: " + title +
                " Year: " + year +
                " ImdbID: " + imdbID +
                " Type: " + type +
                " Poster: " + poster;
    }

    public List<MovieBasic> sortMoviesByYear(List<MovieBasic> movieBasicList) {
        Comparator.comparing(MovieBasic::getYear).thenComparing(MovieBasic::getYear);
        Collections.sort(movieBasicList, Comparator.comparing(MovieBasic::getYear));
        return movieBasicList;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Year")
    public String getYear() {
        return year;
    }

    @JsonProperty("Year")
    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("Poster")
    public String getPoster() {
        return poster;
    }

    @JsonProperty("Poster")
    public void setPoster(String poster) {
        this.poster = poster;
    }
}
