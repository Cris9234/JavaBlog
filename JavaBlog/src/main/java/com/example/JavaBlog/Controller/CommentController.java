package com.example.JavaBlog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JavaBlog.Models.Comment;
import com.example.JavaBlog.Services.CommentServiceImpl;

@RestController
@RequestMapping("/javablog/comment")
public class CommentController {
	
	@Autowired
	CommentServiceImpl commentService;

	@GetMapping("/get/{id}")
	public Comment getComment(@PathVariable long id) {
		return commentService.getComment(id);
	}
	
	@GetMapping("/all")
	public Page<Comment> getAllComments(){
		return commentService.getAllComments();
	}
	
	@PostMapping("/add")
	public Comment addComment(@RequestBody Comment comment) {
		return commentService.addComment(comment);
	}
	
	@DeleteMapping("/delete/{}")
	public Comment deleteComment(@PathVariable long id) {
		return commentService.deleteComment(id);
	}
}
