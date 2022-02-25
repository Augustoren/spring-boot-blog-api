package com.blog.api.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.blog.api.entities.User;
import com.blog.api.repositories.UserRepository;
import com.blog.api.services.exceptions.DatabaseException;
import com.blog.api.services.exceptions.UserAlreadyExistsException;
import com.blog.api.services.exceptions.UserNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new UserNotFoundException());
	}

	public User createUser(User user) {
		User usr = userRepository.findUserByEmail(user.getEmail());
		if (user.equals(usr)) {
			throw new UserAlreadyExistsException();
		} else {
			return userRepository.save(user);
		}
	}
	
	public User updateUser(Long id, User user) {
		User usr;
		try {
			usr = findUserById(id);
			usr.setFistName(user.getFistName());
			usr.setLastName(user.getLastName());
			usr.setEmail(user.getEmail());
			return userRepository.save(usr);
		} catch(EntityNotFoundException e) {
			throw new UserNotFoundException();
		}
	}
	
	public void deleteUser(Long id) {
		try {
			User user = findUserById(id);
			userRepository.delete(user);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("It is not possible to delete users who have associations");
		}
	}
}
