package com.example.JavaBlog.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.JavaBlog.Models.Article;

public interface ArticleRepo extends PagingAndSortingRepository<Article, Long>{
	
	public Page<Article> findByUserId(long id, Pageable pageable);

}
