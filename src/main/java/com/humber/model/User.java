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
<<<<<<< HEAD

	@Column(name = "password")
    private String password;
	
	@Column(name = "confirmPassword")
    private String confirmPassword;
=======
	
    @Column(name = "password")
    private String password;
>>>>>>> 8b92d078c04b02e1c979ce768c0c988830e7d989
 
    public User() {
    }

<<<<<<< HEAD
	public User(Integer id, String name, String email, String password, String confirmPassword) {
=======
	public User(Integer id, String name, String email, String password) {
>>>>>>> 8b92d078c04b02e1c979ce768c0c988830e7d989
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
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

	public String getPassword() {
		return password;
	}
<<<<<<< HEAD
	
=======

>>>>>>> 8b92d078c04b02e1c979ce768c0c988830e7d989
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}