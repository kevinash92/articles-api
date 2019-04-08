package com.mebcorp.articleApp.metier;

import java.util.List;

import com.mebcorp.articleApp.entities.Article;
import com.mebcorp.articleApp.entities.Author;

public interface IMetier {
	// Author abst
	public List<Author> getAllAuthors();
	public Author getAuthorById(Long idAuthor);
	public List<Article> getAuthorArticles(Long idAuthor);
	
	public List<Article> getAllArticles();
	public Article getArticleById(Long idArticle);
	public Author getArticleAuthor(Long idArticle);
	
	public void createAuthor(Author author);
	public void updateAuthor(Long idAuthor, Author value);
	public void deleteAuthor(Long idAuthor);
	
	public void createArticle(Long idAuthor, Article article);
	public void updateArticle(Long idArticle, Article article);
	public void deleteArticle(Long idArticle);
}
