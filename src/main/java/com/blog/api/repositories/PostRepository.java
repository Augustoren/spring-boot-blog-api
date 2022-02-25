package com.blog.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.api.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
