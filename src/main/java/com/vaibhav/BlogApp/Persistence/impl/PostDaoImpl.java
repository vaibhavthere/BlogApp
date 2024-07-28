package com.vaibhav.BlogApp.Persistence.impl;

import com.vaibhav.BlogApp.Persistence.interfaces.PostDaoInterface;
import com.vaibhav.BlogApp.dto.request.PostModel;
import com.vaibhav.BlogApp.entity.PostEntity;
import com.vaibhav.BlogApp.exception.ResourseNotFoundException;
import com.vaibhav.BlogApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PostDaoImpl implements PostDaoInterface
{
    @Autowired
    private PostRepository postRepository;

    public PostDaoImpl(PostRepository postRepository)
    {
        this.postRepository = postRepository;
    }

    @Override
    public PostEntity createPost(PostEntity postEntity)
    {
        postRepository.save(postEntity);

        return postEntity;
    }

    @Override
    public List<PostEntity> getAllPost() {

        List<PostEntity> allPostEntity = postRepository.findAll();

        return allPostEntity;
    }

    @Override
    public PostEntity getPostById(Long id) {

        Optional<PostEntity> byId = postRepository.findById(id);

        if(byId.isPresent()){
            return byId.get();
        }else {
            throw new ResourseNotFoundException("Record Not found", "id", id);
        }


    }


}
