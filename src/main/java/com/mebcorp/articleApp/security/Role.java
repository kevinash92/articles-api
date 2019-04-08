package com.mebcorp.articleApp.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mebcorp.articleApp.entities.AbstractEntity;

@Entity
@Table(name="role")
public class Role extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name="name")
	private String name;
	
	public Role() {
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + "]";
	}
	
}
