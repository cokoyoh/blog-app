package com.example.blogtwo.controllers;

import com.example.blogtwo.entities.Post;
import com.example.blogtwo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index() {
        return "welcome home Charles ";
    }

    @RequestMapping(value = "/posts")
    public List<Post> posts () {
        return  postService.getAllPosts();
    }

    @PostMapping(value = "/posts")
    public void store(@RequestBody Post post) {
        if (post.getCreatedAt() == null) {
            post.setCreatedAt(new Date());
        }

        postService.store(post);
    }
}
