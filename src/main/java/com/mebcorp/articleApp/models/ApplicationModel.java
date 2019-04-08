package com.mebcorp.articleApp.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mebcorp.articleApp.entities.Article;
import com.mebcorp.articleApp.entities.Author;
import com.mebcorp.articleApp.metier.IMetier;
import com.mebcorp.articleApp.utils.Static;

@Component
public class ApplicationModel implements IMetier {

	@Autowired
	private IMetier metier;
	
	private List<String> messages;
	private List<Author> authors;
	private List<Article> articles;
	
	@PostConstruct
	public void init() {
		try {
			authors = metier.getAllAuthors();
			articles = metier.getAllArticles();
		} catch (Exception ex) {
			messages = Static.getErreursForException(ex);
		}
		
	}
	
	@Override
	public List<Author> getAllAuthors() {
		return metier.getAllAuthors();
	}

	@Override
	public Author getAuthorById(Long idAuthor) {
		return metier.getAuthorById(idAuthor);
	}

	@Override
	public List<Article> getAuthorArticles(Long idAuthor) {
		return metier.getAuthorArticles(idAuthor);
	}

	@Override
	public List<Article> getAllArticles() {
		return metier.getAllArticles();
	}

	@Override
	public Article getArticleById(Long idArticle) {
		return metier.getArticleById(idArticle);
	}

	@Override
	public Author getArticleAuthor(Long idArticle) {
		return metier.getArticleAuthor(idArticle);
	}

	@Override
	public void createAuthor(Author author) {
		metier.createAuthor(author);
	}

	@Override
	public void updateAuthor(Long idAuthor, Author value) {
		metier.updateAuthor(idAuthor, value);
	}

	@Override
	public void deleteAuthor(Long idAuthor) {
		metier.deleteAuthor(idAuthor);
	}

	@Override
	public void createArticle(Long idAuthor, Article article) {
		metier.createArticle(idAuthor, article);
	}

	@Override
	public void updateArticle(Long idArticle, Article article) {
		metier.updateArticle(idArticle, article);
	}

	@Override
	public void deleteArticle(Long idArticle) {
		metier.deleteArticle(idArticle);
	}

	public List<String> getMessages() {
		return messages;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	
}
