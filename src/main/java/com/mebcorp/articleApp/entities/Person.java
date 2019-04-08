package com.mebcorp.articleApp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Person extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "address")
    private String address;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "sex")
    private String sex;
	
	public Person() {
	}

	public Person(String lastname, String firstname, String address, Date birthday, String sex) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.address = address;
		this.birthday = birthday;
		this.sex = sex;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getAddress() {
		return address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [lastname=" + lastname + ", firstname=" + firstname + ", address=" + address + ", birthday="
				+ birthday + ", sex=" + sex + "]";
	}
	
	
	
}
