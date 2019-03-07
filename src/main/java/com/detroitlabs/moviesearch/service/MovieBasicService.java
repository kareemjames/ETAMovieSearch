package com.detroitlabs.moviesearch.service;

import com.detroitlabs.moviesearch.model.MovieBasic;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieBasicService {

    public MovieBasic getAllMovies() {

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://www.omdbapi.com/?s=batman&apikey=ea8e0e57", MovieBasic.class);
    }
}
