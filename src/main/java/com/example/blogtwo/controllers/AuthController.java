package com.example.blogtwo.controllers;

import com.example.blogtwo.entities.User;
import com.example.blogtwo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "logout", required = false) String logout) {
        return "login.html";
    }


    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String login() {
        return "register.html";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String login(User userRequest) {
        userRequest.setPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()));
        User user = userRepository.save(userRequest);
        return "register.html";
    }


}
