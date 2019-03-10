package com.detroitlabs.moviesearch.controller;

import com.detroitlabs.moviesearch.model.MovieDetails;
import com.detroitlabs.moviesearch.model.Movie;
import com.detroitlabs.moviesearch.service.MovieService;
import com.detroitlabs.moviesearch.service.MovieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    MovieDetailsService movieService;

    @ResponseBody
    @RequestMapping("/")
    public String displayListOfMovies() {
        Movie allMovies = movieService.getAllMovies();
        return allMovies.getSearch().toString();
    }

    @ResponseBody
    @RequestMapping("/movie/{name}")
    public String displayMovieDetails(@PathVariable String name, ModelMap modelMap) {
        MovieDetails movieDetails = movieService.fetchMovieDetails();
        return movieDetails.toString();
    }

}
