package com.example.blogtwo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String home() {
        return  "welcome.html";
    }

    @GetMapping(value = "/private")
    public String privateArea() {
        return  "private";
    }
}
