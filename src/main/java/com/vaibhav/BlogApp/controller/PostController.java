package com.vaibhav.BlogApp.controller;

import com.vaibhav.BlogApp.dto.request.PostByIdRequest;
import com.vaibhav.BlogApp.dto.request.PostModel;
import com.vaibhav.BlogApp.response.PostResponse;
import com.vaibhav.BlogApp.service.interfaces.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostController
{
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(path = "/CreatePosts")
    public ResponseEntity<PostModel> createPost(@RequestBody PostModel postModel)
    {
        return new ResponseEntity<>(postService.createPost(postModel), HttpStatus.CREATED);
    }

    @GetMapping(path = "/getAllPost")
    public PostResponse getAllPost()
    {
        return postService.getAllPosts();
    }

    @PostMapping(path = "/getPostById")
    public ResponseEntity<PostModel> getPostById(@RequestBody PostByIdRequest postByIdRequest)
    {
        return new ResponseEntity<>(postService.getPostById(postByIdRequest), HttpStatus.OK);
    }

    @PutMapping(path = "/updatePostById")
    public ResponseEntity<PostModel> updatePostById(@RequestBody PostModel postModel)
    {
        return new ResponseEntity<>(postService.updatePostById(postModel), HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletePostById")
    public ResponseEntity<Void> deletePostById(@RequestBody PostByIdRequest updatePostById) {
        postService.deletePost(updatePostById);
        return ResponseEntity.ok().build();
    }
}
