package com.detroitlabs.moviesearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    private List<MovieBasic> search;

    @Override
    public String toString() {
        return "Movie{" +
                "search=" + search +
                '}';
    }

    @JsonProperty("Search")
    public List<MovieBasic> getSearch() {
        return search;
    }

    @JsonProperty("Search")
    public void setSearch(List<MovieBasic> search) {
        this.search = search;
    }

}
