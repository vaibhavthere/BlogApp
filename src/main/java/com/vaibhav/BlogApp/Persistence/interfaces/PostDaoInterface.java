package com.vaibhav.BlogApp.Persistence.interfaces;

import com.vaibhav.BlogApp.dto.request.PostModel;
import com.vaibhav.BlogApp.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostDaoInterface
{
    PostEntity createPost(PostEntity postEntity);

    Page<PostEntity> getAllPost(Pageable pageable);

    PostEntity getPostById(Long id);

   PostEntity updatePostById(PostEntity postEntity);

   void deletePostById(Long id);
}
