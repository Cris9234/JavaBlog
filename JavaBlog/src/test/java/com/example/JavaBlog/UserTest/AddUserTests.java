package com.example.JavaBlog.UserTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.JavaBlog.Models.User;
import com.example.JavaBlog.Services.UserServiceImpl;

@SpringBootTest
class AddUserTests {
	
	@Autowired
	UserServiceImpl userserviceimpl;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testaddUser() {
		User newuser = new User();
		newuser.setUsername("user1");
		newuser.setPassword("pass1");
		newuser.setEmail("user1@gmail.com");
		assertThat(userserviceimpl.addUser(newuser) != null);
		assertThat(userserviceimpl.addUser(newuser) == null);
	}

}
