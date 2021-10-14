package com.example.JavaBlog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JavaBlog.Models.User;
import com.example.JavaBlog.Services.UserService;

@RestController
@RequestMapping("javablog/user")
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("/get/{id}")
	public User getUser(@PathVariable long id) {
		return service.getUser(id);
	}
	
	@GetMapping("/all")
	public Page<User> getAllUser() {
		return service.getAllUser(PageRequest.of(0, 5));
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public User deleteUser(@PathVariable long id) {
		return service.deleteUser(id);
	}
}
