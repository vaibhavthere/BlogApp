package com.vaibhav.BlogApp.Mapping;

import com.vaibhav.BlogApp.dto.request.PostModel;
import com.vaibhav.BlogApp.entity.PostEntity;

public class EntityToModel
{
    public static PostModel postEntityToModel(PostEntity postEntity)
    {

        PostModel postResponse = PostModel.builder().build();
        postResponse.setId(postEntity.getId());
        postResponse.setContent(postEntity.getContent());
        postResponse.setDescription(postEntity.getDescription());
        postResponse.setTitle(postEntity.getTitle());

        return postResponse;
    }
}
