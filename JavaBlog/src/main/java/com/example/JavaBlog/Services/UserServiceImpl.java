package com.example.JavaBlog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.JavaBlog.Models.User;
import com.example.JavaBlog.Repository.UserRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService{
	
	public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepo repo;

	@Override
	public User addUser(User u) {
		try {
			return repo.save(u);
		} catch (Exception e) {
			logger.error("user not entered.");
		}
		return null;
	}

	@Override
	public User getUser(long id) {
		try {
			return repo.findById(id).orElseThrow();
		} catch (Exception e) {
			logger.error("user not found.");
		}
		return null;
	}

	@Override
	public Page<User> getAllUser(Pageable pageable) {
		try {
			return repo.findAll(Pageable.unpaged());
		} catch (Exception e) {
			logger.error("users not found.");
		}
		return null;
	}

	@Override
	public User deleteUser(long id) {
		try {
			User userToDelete = repo.findById(id).orElseThrow();
			repo.delete(userToDelete);
		} catch (Exception e) {
			logger.error("user not delated.");
		}
		return null;
	}

}
