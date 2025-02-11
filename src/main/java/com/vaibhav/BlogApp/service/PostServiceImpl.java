package com.vaibhav.BlogApp.service;

import com.vaibhav.BlogApp.Persistence.interfaces.PostDaoInterface;
import com.vaibhav.BlogApp.dto.request.PostByIdRequest;
import com.vaibhav.BlogApp.dto.request.PostModel;
import com.vaibhav.BlogApp.entity.PostEntity;
import com.vaibhav.BlogApp.response.PostResponse;
import com.vaibhav.BlogApp.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public PostResponse getAllPosts()
    {
        Pageable pageable = PageRequest.of(0,10);

        Page<PostEntity> postsEntities = postDaoInterface.getAllPost(pageable);

        List<PostModel> postsModels = postsEntities.stream()
               .map(postEntity -> postEntityToModel(postEntity)).toList();

        PostResponse postResponse = PostResponse.builder().build();
        postResponse.setBody(postsModels);
        postResponse.setPageNo(postsEntities.getNumber());
        postResponse.setPageSize(postsEntities.getSize());
        postResponse.setLast(postsEntities.isLast());
        postResponse.setTotalPages(postsEntities.getTotalPages());
        postResponse.setTotalElements(postsEntities.getTotalElements());
        

        return postResponse;
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
