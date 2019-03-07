package com.detroitlabs.moviesearch.service;

import com.detroitlabs.moviesearch.model.MovieDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieDetailsService {
    public MovieDetails fetchMovieDetails() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://www.omdbapi.com/?t=batman&apikey=ea8e0e57", MovieDetails.class);
    }
}
