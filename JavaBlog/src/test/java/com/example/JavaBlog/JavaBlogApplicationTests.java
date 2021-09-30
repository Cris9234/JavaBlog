package com.example.JavaBlog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.JavaBlog.Models.User;
import com.example.JavaBlog.Services.UserServiceImpl;

@SpringBootTest
class JavaBlogApplicationTests {
	
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
	
	@Test
	void testgetUser() {
		Page<User> users = userserviceimpl.getAllUser(null);
		User user = users.stream().findFirst().get();
		assertThat(userserviceimpl.getUser(user.getId()) == user);
	}
	
	@Test
	void testDeleteUser() {
		Page<User> users = userserviceimpl.getAllUser(null);
		User usertodelete = users.stream().findFirst().get();
		assertThat(userserviceimpl.deleteUser(usertodelete.getId()) == usertodelete);
	}

}
