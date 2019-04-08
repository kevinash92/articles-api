package com.mebcorp.articleApp.metier;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mebcorp.articleApp.DAO.ArticleDAO;
import com.mebcorp.articleApp.DAO.AuthorDAO;
import com.mebcorp.articleApp.entities.Article;
import com.mebcorp.articleApp.entities.Author;

@Service("metier")
public class Metier implements IMetier {
	@Autowired
	private AuthorDAO authorDAO;
	@Autowired
	private ArticleDAO articleDAO;

	@Override
	public List<Author> getAllAuthors() {
		return Lists.newArrayList(authorDAO.findAll());
	}

	@Override
	public Author getAuthorById(Long idAuthor) {
		return authorDAO.findById(idAuthor).get();
	}

	@Override
	public List<Article> getAuthorArticles(Long idAuthor) {
		return authorDAO.findAuthorArticles(idAuthor);
	}

	@Override
	public List<Article> getAllArticles() {
		return Lists.newArrayList(articleDAO.findAll());
	}

	@Override
	public Article getArticleById(Long idArticle) {
		return articleDAO.findById(idArticle).get();
	}

	@Override
	public Author getArticleAuthor(Long idArticle) {
		return articleDAO.findArticleAuthor(idArticle);
	}

	@Override
	public void createAuthor(Author author) {
		authorDAO.save(author);
	}

	@Override
	public void updateAuthor(Long idAuthor, Author value) {
		Author author = getAuthorById(idAuthor);
		
		author.setFirstname(value.getFirstname());
		author.setLastname(value.getLastname());
		author.setAddress(value.getAddress());
		author.setBirthday(value.getBirthday());
		author.setSex(value.getSex());
		
		authorDAO.save(author);
	}

	@Override
	public void deleteAuthor(Long idAuthor) {
		authorDAO.delete(getAuthorById(idAuthor));;
	}

	@Override/***/
	public void createArticle(Long idAuthor, Article article) {
		Author author = getAuthorById(idAuthor);
		article.setAuthor(author);
		articleDAO.save(article);
	}

	@Override
	public void updateArticle(Long idArticle, Article value) {
		Article article = getArticleById(idArticle);
		article.setContent(value.getContent());
		article.setPhoto(value.getPhoto());
		article.setTitle(value.getTitle());		
		articleDAO.save(article);
	}

	@Override
	@Transactional
	public void deleteArticle(Long idArticle) {
		Article article = getArticleById(idArticle);
		articleDAO.delete(article);
	}

}
