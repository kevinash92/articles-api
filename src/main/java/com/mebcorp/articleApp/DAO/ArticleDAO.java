package com.mebcorp.articleApp.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mebcorp.articleApp.entities.Article;
import com.mebcorp.articleApp.entities.Author;

public interface ArticleDAO extends CrudRepository<Article, Long>{
	@Query("select art.author from Article art where art.id=?1")
	Author findArticleAuthor(Long id);
}
