package com.example.JavaBlog.UserTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.JavaBlog.Models.User;
import com.example.JavaBlog.Services.UserServiceImpl;

@SpringBootTest
public class DeleteUserTest {

	@Autowired
	UserServiceImpl userserviceimpl;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testDeleteUser() {
		Page<User> users = userserviceimpl.getAllUser(null);
		User usertodelete = users.stream().findFirst().get();
		assertThat(userserviceimpl.deleteUser(usertodelete.getId()) == usertodelete);
	}
}
