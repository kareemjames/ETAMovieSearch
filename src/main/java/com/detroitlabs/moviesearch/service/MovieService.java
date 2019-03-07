package com.detroitlabs.moviesearch.service;

import com.detroitlabs.moviesearch.model.Movie;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieService {
    public Movie fetchMovieData() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://www.omdbapi.com/?t=batman&apikey=ea8e0e57", Movie.class);
    }
}
