package com.example.blogtwo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/")
    public String home() {
        return  "Welcome home";
    }

    @GetMapping(value = "/private")
    public String privateArea() {
        return  "private";
    }
}
