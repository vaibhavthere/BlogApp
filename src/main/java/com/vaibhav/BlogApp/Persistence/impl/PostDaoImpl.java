package com.vaibhav.BlogApp.Persistence.impl;

import com.vaibhav.BlogApp.Persistence.interfaces.PostDaoInterface;
import com.vaibhav.BlogApp.entity.PostEntity;
import com.vaibhav.BlogApp.exception.ResourseNotFoundException;
import com.vaibhav.BlogApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<PostEntity> getAllPost(Pageable pageable) {

        Page<PostEntity> allPostEntity = postRepository.findAll(pageable);

        return allPostEntity;
    }

    @Override
    public PostEntity getPostById(Long id)
    {
        Optional<PostEntity> byId = postRepository.findById(id);

        if(byId.isPresent()){
            return byId.get();
        }else {
            throw new ResourseNotFoundException("Record Not found", "id", id);
        }

    }

    @Override
    public PostEntity updatePostById(PostEntity postEntityRequest)
    {
        PostEntity postEntity = postRepository.save(postEntityRequest);
        return postEntity;
    }

    @Override
    public void deletePostById(Long id)
    {
        postRepository.deleteById(id);
    }
}
