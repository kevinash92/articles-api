package com.mebcorp.articleApp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="author")
public class Author extends Person {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
	private List<Article> articles;

	public Author() {
		super();
	}

	public Author(String lastname, String firstname, String address, Date birthday, String sex) {
		super(lastname, firstname, address, birthday, sex);
	}

	@Override
	public String toString() {
		return String.format("Author [%s]", super.toString());
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	

}
