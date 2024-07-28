package com.vaibhav.BlogApp.Mapping;

import com.vaibhav.BlogApp.dto.request.PostModel;
import com.vaibhav.BlogApp.entity.PostEntity;

public class ModelToEntity
{
    public static PostEntity postModelToEntity(PostModel postModel)
    {
        PostEntity postEntity = PostEntity.builder().build();
        postEntity.setTitle(postModel.getTitle());
        postEntity.setContent(postModel.getContent());
        postEntity.setDescription(postModel.getDescription());

        return postEntity;
    }
}
