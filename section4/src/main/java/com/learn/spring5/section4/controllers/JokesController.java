package com.learn.spring5.section4.controllers;

import com.learn.spring5.section4.services.JokeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

    private final JokeServiceImpl jokeServiceImpl;

    public JokesController(JokeServiceImpl jokeServiceImpl) {
        this.jokeServiceImpl = jokeServiceImpl;
    }

    @RequestMapping("/")
    public String getIndex(Model model){
        model.addAttribute("jokes", jokeServiceImpl.getJoke());
        return "index";
    }
}
