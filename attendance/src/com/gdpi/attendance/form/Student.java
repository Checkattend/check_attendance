package com.gdpi.attendance.form;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer id;
	private Role role;
	private Clas clas;
	private String username;
	private String account;
	private String password;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(Role role, Clas clas, String username, String account,
			String password) {
		this.role = role;
		this.clas = clas;
		this.username = username;
		this.account = account;
		this.password = password;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Clas getClas() {
		return this.clas;
	}

	public void setClas(Clas clas) {
		this.clas = clas;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}