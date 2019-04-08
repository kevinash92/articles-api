package com.mebcorp.articleApp.security;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mebcorp.articleApp.entities.AbstractEntity;

@Entity
@Table(name="account_role")
public class AccountRole extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="id_account")
	private Account account;
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;	
	
	public AccountRole() {
	}

	public AccountRole(Account account, Role role) {
		super();
		this.account = account;
		this.role = role;
	}

	public Account getAccount() {
		return account;
	}

	public Role getRole() {
		return role;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
