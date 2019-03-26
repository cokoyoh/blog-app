package com.example.blogtwo;

import com.example.blogtwo.config.CustomUserDetails;
import com.example.blogtwo.entities.Role;
import com.example.blogtwo.entities.User;
import com.example.blogtwo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import java.util.Arrays;

@SpringBootApplication
public class BlogTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogTwoApplication.class, args);
    }
}
