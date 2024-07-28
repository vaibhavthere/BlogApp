package com.vaibhav.BlogApp.Persistence.interfaces;

import com.vaibhav.BlogApp.dto.request.PostModel;
import com.vaibhav.BlogApp.entity.PostEntity;

import java.util.List;

public interface PostDaoInterface
{
    PostEntity createPost(PostEntity postEntity);

    List<PostEntity> getAllPost();

    PostEntity getPostById(Long id);

   PostEntity updatePostById(PostEntity postEntity);
}
