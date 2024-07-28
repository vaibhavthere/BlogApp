package com.vaibhav.BlogApp.service;

import com.vaibhav.BlogApp.Persistence.interfaces.PostDaoInterface;
import com.vaibhav.BlogApp.dto.request.PostByIdRequest;
import com.vaibhav.BlogApp.dto.request.PostModel;
import com.vaibhav.BlogApp.entity.PostEntity;
import com.vaibhav.BlogApp.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.vaibhav.BlogApp.Mapping.EntityToModel.postEntityToModel;
import static com.vaibhav.BlogApp.Mapping.ModelToEntity.postModelToEntity;

@Service
public class PostServiceImpl implements PostService
{
    @Autowired
    private PostDaoInterface postDaoInterface;

    public PostServiceImpl(PostDaoInterface postDaoInterface) {
        this.postDaoInterface = postDaoInterface;
    }

    @Override
    public PostModel createPost(PostModel postModel)
    {
        PostEntity postEntity = postModelToEntity(postModel);

        postDaoInterface.createPost(postEntity);

        PostModel postResponse = postEntityToModel(postEntity);

        return postResponse;
    }

    @Override
    public List<PostModel> getAllPosts()
    {
        List<PostEntity> postsEntities = postDaoInterface.getAllPost();

        List<PostModel> postsModels = postsEntities.stream()
               .map(postEntity -> postEntityToModel(postEntity)).toList();

        return postsModels;
    }

    @Override
    public PostModel getPostById(PostByIdRequest postByIdRequest)
    {
        PostEntity postById = postDaoInterface.getPostById(postByIdRequest.getId());

        PostModel postResponse = postEntityToModel(postById);

        return postResponse;
    }

    @Override
    public PostModel updatePostById(PostModel postModelRequest)
    {
        PostEntity postById = postDaoInterface.getPostById(postModelRequest.getId());

        postById.setContent(postModelRequest.getContent());
        postById.setTitle(postModelRequest.getTitle());
        postById.setDescription(postModelRequest.getDescription());

        PostEntity postEntity = postDaoInterface.updatePostById(postById);

        PostModel postModel = postEntityToModel(postEntity);

        return postModel;
    }

    @Override
    public void deletePost(PostByIdRequest postByIdRequest)
    {
        postDaoInterface.deletePostById(postByIdRequest.getId());
    }
}
