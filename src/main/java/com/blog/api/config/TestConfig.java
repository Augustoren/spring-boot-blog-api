package com.blog.api.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.blog.api.entities.Post;
import com.blog.api.entities.User;
import com.blog.api.repositories.PostRepository;
import com.blog.api.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		User user1 = new User("Augusto", "Renan", "augusto@email.com", "augusto123");
		User user2 = new User("Laura", "Moura", "laura@email.com", "laura123");

		userRepository.saveAll(Arrays.asList(user1, user2));
		
		Post post1 = new Post(Instant.now(), "Guia definito HTTP", "Uma guia para voce virar expert no assunto HTTP e dominar a web", user1);
		Post post2 = new Post(Instant.now(), "S.O.L.I.D", "Domine a arquitetura de código limpo", user1);

		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
