package com.detroitlabs.moviesearch.controller;

import com.detroitlabs.moviesearch.model.Movies;
import com.detroitlabs.moviesearch.service.MoviesService;
import com.detroitlabs.moviesearch.service.MovieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MovieController {

    @Autowired
    MoviesService moviesService;

    @Autowired
    MovieDetailsService movieService;

    @ResponseBody
    @RequestMapping("/")
    public String displayListOfMovies() {
        Movies allMovies = moviesService.getAllMovies();
        return "This is all the movies " + allMovies.getSearch().get(1).getTitle();
    }

}
