package com.mebcorp.articleApp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="article")
public class Article extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name="title")
	private String title;
	@Column(name="photo")
	private String photo;
	@Column(name="content")
	private String content;
	@Column(name="createdate")
	@Temporal(TemporalType.DATE)
	private Date createDate;
	@Temporal(TemporalType.DATE)
	@Column(name="updatedate")
	private Date updateDate;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_author")
	Author author;
	
	public Article() {
	}
	
	public Article(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getPhoto() {
		return photo;
	}

	public String getContent() {
		return content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return String.format("Article [id=%d, title=%s]", super.id, this.title);
	}

}
