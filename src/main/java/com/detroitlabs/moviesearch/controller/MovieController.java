package com.detroitlabs.moviesearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

    @RequestMapping("/")
    public String displayMovie() {
        return "temp-home";
    }
}
