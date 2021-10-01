package com.example.JavaBlog.Services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.JavaBlog.Models.Article;
import com.example.JavaBlog.Repository.ArticleRepo;


@Service
public class ArticleServiceImpl implements ArticleService{
	
	public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	ArticleRepo repo;

	@Override
	public Article addArticle(Article article) {
		try {
			return repo.save(article);
		} catch (Exception e) {
			logger.error("article not saved.");
			return null;
		}
	}

	@Override
	public Article getArticle(long id) {
		try {
			return repo.findById(id).orElseThrow();
		} catch (Exception e) {
			logger.error("article not found.");
			return null;
		}
	}

	@Override
	public Article deleteArticle(long id) {
		try {
			Article articletodelete = repo.findById(id).orElseThrow();
			repo.delete(articletodelete);
			return articletodelete;
		} catch (Exception e) {
			logger.error("article not deleted.");
			return null;
		}
	}

	@Override
	public Page<Article> getAllArticle(Pageable pageable) {
		try {
			return repo.findAll(pageable);
		} catch (Exception e) {
			logger.error("articles not found.");
			return null;
		}
	}

	@Override
	public Page<Article> getAllArticleById(Long id, Pageable pageable) {
		try {
			return repo.findByUserId(id, pageable);
		} catch (Exception e) {
			logger.error("articles not found");
			return null;
		}
	}

}
