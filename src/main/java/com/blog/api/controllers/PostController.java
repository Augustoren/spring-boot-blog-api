package com.blog.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.entities.Post;
import com.blog.api.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping
	public List<Post> list(){
		return postService.getAllPosts();
	}
	
	@GetMapping("/{id}")
	public Optional<Post> getById(@PathVariable("id") Long id) {
		return postService.getPostById(id);
	}
}
