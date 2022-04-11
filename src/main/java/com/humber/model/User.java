package com.humber.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "password")
    private float password;
 
    public User() {
    }

	public User(Integer id, String name, String email, float password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getPassword() {
		return password;
	}

	public void setPassword(float password) {
		this.password = password;
	}
}