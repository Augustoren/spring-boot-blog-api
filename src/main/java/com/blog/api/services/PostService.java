package com.blog.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.api.entities.Post;
import com.blog.api.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public List<Post> getAllPosts(){
		return postRepository.findAll();
	}
	
	public Optional<Post> getPostById(Long id) {
		return postRepository.findById(id);
	}
	
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

}
