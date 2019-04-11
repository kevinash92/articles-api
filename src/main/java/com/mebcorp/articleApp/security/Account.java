package com.mebcorp.articleApp.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.mebcorp.articleApp.entities.AbstractEntity;

@Entity
@Table(name="account")
public class Account extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name="login")
	private String login;
	@Column(name="password")
	private String password;
	@Email
	@Column(name="email")
	private String email;
	
	public Account() {
	}

	/**
	 * 
	 * @param login
	 * @param password sera directement encodé avec l'algorithme Bcrypt
	 * @param email   
	 */
	public Account(String login, String password, String email) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * 
	 * @param password sera directement encodé avec l'algorithme Bcrypt
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Account [login=" + login + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
