package com.detroitlabs.moviesearch.service;

import com.detroitlabs.moviesearch.model.Movie;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class MovieService {

    private String searchTerm;

    public Movie getAllMovies() {

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://www.omdbapi.com/?s=" + searchTerm + "&apikey=ea8e0e57", Movie.class);
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
}
