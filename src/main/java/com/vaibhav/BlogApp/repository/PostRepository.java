package com.vaibhav.BlogApp.repository;

import com.vaibhav.BlogApp.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long>
{

}
