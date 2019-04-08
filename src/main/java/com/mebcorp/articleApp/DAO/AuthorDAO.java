package com.mebcorp.articleApp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mebcorp.articleApp.entities.Article;
import com.mebcorp.articleApp.entities.Author;

public interface AuthorDAO extends CrudRepository<Author, Long> {
	@Query("select aut.articles from Author aut where aut.id=?1")
	List<Article> findAuthorArticles(Long idAuthor);
}
