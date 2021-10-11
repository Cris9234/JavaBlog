package com.example.JavaBlog.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.JavaBlog.Models.Comment;

public interface CommentRepo extends PagingAndSortingRepository<Comment, Long>{

}
