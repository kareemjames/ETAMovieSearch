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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MovieController {

    MovieBasic movieBasic = new MovieBasic();

    @Autowired
    MovieService movieService;

    @Autowired
    MovieDetailsService movieDetailsService;

    @RequestMapping("/")
    public String displayListOfMovies(ModelMap modelMap) {

        Movie allMoviesObj = movieService.getAllMovies();
        List<MovieBasic> allMovies = allMoviesObj.getSearch();
        allMovies = movieBasic.sortMoviesByYear(allMovies);
        modelMap.put("allMovies", allMovies);
        return "index";
    }

    @RequestMapping("/movie/{imdbId}")
    public String displayMovieDetails(@PathVariable String imdbId, ModelMap modelMap) {
        movieDetailsService.setImdbID(imdbId);
        MovieDetails movie = movieDetailsService.fetchMovieDetails();
        modelMap.put("movie", movie);
        return "generic";
    }

    @RequestMapping("search")
    public String searchByMovieTitle(@RequestParam("q") String searchValue, ModelMap modelMap) {
        movieService.setSearchTerm(searchValue);
        Movie allMoviesObj = movieService.getAllMovies();
        List<MovieBasic> allMovies = allMoviesObj.getSearch();
        allMovies = movieBasic.sortMoviesByYear(allMovies);
        modelMap.put("allMovies", allMovies);
        return "index";
    }

}
