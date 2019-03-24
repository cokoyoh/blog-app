package com.example.blogtwo.service;

import com.example.blogtwo.entities.Post;
import com.example.blogtwo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    };

    public void store(Post post) {
        postRepository.save(post);
    }
}
