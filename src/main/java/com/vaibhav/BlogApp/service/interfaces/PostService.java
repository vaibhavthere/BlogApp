package com.vaibhav.BlogApp.service.interfaces;

import com.vaibhav.BlogApp.dto.request.PostByIdRequest;
import com.vaibhav.BlogApp.dto.request.PostModel;
import com.vaibhav.BlogApp.response.PostResponse;

import java.util.List;

public interface PostService
{
     PostModel createPost(PostModel postDto);
     PostResponse getAllPosts();
     PostModel getPostById(PostByIdRequest postByIdRequest);
     PostModel updatePostById(PostModel postModel);
     void deletePost(PostByIdRequest postByIdRequest);
}
