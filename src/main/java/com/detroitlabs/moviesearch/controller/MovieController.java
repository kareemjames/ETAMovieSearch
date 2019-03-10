package com.detroitlabs.moviesearch.controller;

import com.detroitlabs.moviesearch.model.MovieBasic;
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

import java.util.List;


@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    MovieDetailsService movieDetailsService;

    @RequestMapping("/")
    public String displayListOfMovies(ModelMap modelMap) {
        Movie allMoviesObj = movieService.getAllMovies();
        List<MovieBasic> allMovies = allMoviesObj.getSearch();

        modelMap.put("allMovies", allMovies);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/movie/{name}")
    public String displayMovieDetails(@PathVariable String name, ModelMap modelMap) {
        MovieDetails movieDetails = movieDetailsService.fetchMovieDetails();
        return movieDetails.toString();
    }

}
