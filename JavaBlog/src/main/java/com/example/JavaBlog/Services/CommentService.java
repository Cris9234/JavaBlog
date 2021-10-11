package com.example.JavaBlog.Services;

import org.springframework.data.domain.Page;

import com.example.JavaBlog.Models.Comment;

public interface CommentService {

	public Comment addComment(Comment c);
	public Comment getComment(long id);
	public Comment deleteComment(Long id);
	public Page<Comment> getAllComments();
}
