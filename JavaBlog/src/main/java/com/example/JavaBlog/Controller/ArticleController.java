package com.example.JavaBlog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JavaBlog.Models.Article;
import com.example.JavaBlog.Services.ArticleServiceImpl;
import com.example.JavaBlog.Services.UserServiceImpl;

@RestController
@RequestMapping("/javablog/article")
public class ArticleController {

	@Autowired
	ArticleServiceImpl articleService;
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/get/{id}")
	public Article getArticle(@PathVariable long id) {
		return articleService.getArticle(id);
	}
	
	@GetMapping("/all")
	public Page<Article> getAllArticles(){
		return articleService.getAllArticle(PageRequest.of(0, 5));
	}
	
	@GetMapping("/user/{id}")
	public Page<Article> getArticleByUserId(@PathVariable long id) {
		return articleService.getAllArticleById(id, PageRequest.of(0, 5));
	}
	
	@PostMapping("/add")
	public Article addArticle(@RequestBody Article article) {
		var user = userService.getAllUser(Pageable.unpaged()).getContent().get(0);
		article.setUser(user);
		return articleService.addArticle(article);
	}
	
	@DeleteMapping("/delete/{id}")
	public Article deleteArticle(@PathVariable long id) {
		return articleService.deleteArticle(id);
	}
}
