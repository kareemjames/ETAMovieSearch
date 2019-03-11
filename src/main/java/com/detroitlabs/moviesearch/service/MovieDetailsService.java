package com.detroitlabs.moviesearch.service;

import com.detroitlabs.moviesearch.model.MovieDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieDetailsService {

    private String imdbID;

    public MovieDetails fetchMovieDetails() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://www.omdbapi.com/?i=" + imdbID + "&apikey=ea8e0e57", MovieDetails.class);
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
}
