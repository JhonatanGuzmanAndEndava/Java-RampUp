package com.endava.bod.challenge.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @RequestMapping(path = "/greetings", method = RequestMethod.GET)
    public String hello() {
        return "Greetings from Spring Boot!";
    }
}
