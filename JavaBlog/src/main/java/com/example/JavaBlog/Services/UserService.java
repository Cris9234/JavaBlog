package com.example.JavaBlog.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.JavaBlog.Models.User;

public interface UserService {

	public User addUser(User u);
	public User getUser(long id);
	public Page<User> getAllUser(Pageable pageable);
	public User deleteUser(long id);
}
