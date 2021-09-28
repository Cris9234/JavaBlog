package com.example.JavaBlog.Repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.JavaBlog.Models.User;

public interface UserRepo extends PagingAndSortingRepository<User, Long>{

	Optional<User> findByUsername(String username);
}
