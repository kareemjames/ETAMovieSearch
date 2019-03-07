package com.detroitlabs.moviesearch.controller;

import com.detroitlabs.moviesearch.model.MovieDetails;
import com.detroitlabs.moviesearch.service.MovieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MovieController {

    @Autowired
    MovieDetailsService movieService;

    @ResponseBody
    @RequestMapping("/")
    public String displayMovie() {
        MovieDetails movie = movieService.fetchMovieDetails();
        return "This is the movie " + movie;

    }
}
