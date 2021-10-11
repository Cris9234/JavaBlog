package com.example.JavaBlog.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.JavaBlog.Models.Comment;
import com.example.JavaBlog.Repository.CommentRepo;

@Service
public class CommentServiceImpl implements CommentService{
	
	public static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	
	@Autowired
	CommentRepo repo;

	@Override
	public Comment addComment(Comment c) {
		try {
			return repo.save(c);
		} catch (Exception e) {
			log.error("comment not added.");
			return null;
		}
	}

	@Override
	public Comment getComment(long id) {
		try {
			return repo.findById(id).orElseThrow();
		} catch (Exception e) {
			log.error("comment not found.");
			return null;
		}
	}

	@Override
	public Comment deleteComment(Long id) {
		try {
			Comment commentToDelete = repo.findById(id).orElseThrow();
			repo.delete(commentToDelete);
			return commentToDelete;
		} catch (Exception e) {
			log.error("comment not deleted");
			return null;
		}	
	}

	@Override
	public Page<Comment> getAllComments() {
		try {
			return repo.findAll(Pageable.unpaged());
		} catch (Exception e) {
			log.error("comments not found.");
			return null;
		}
	}

}
