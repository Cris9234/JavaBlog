package com.example.JavaBlog.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.JavaBlog.Models.Article;

public interface ArticleService {

	public Article addArticle(Article article);
	public Article getArticle(long id);
	public Article deleteArticle(long id);
	public Page<Article> getAllArticle(Pageable pageable);
	public Page<Article> getAllArticleById(Long id, Pageable pageable);
}
