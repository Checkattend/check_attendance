package com.gdpi.attendance.form;

import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer id;
	private Role role;
	private String username;
	private String account;
	private String password;
	private Set teacherSubs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Role role, String username, String account, String password) {
		this.role = role;
		this.username = username;
		this.account = account;
		this.password = password;
	}

	/** full constructor */
	public Teacher(Role role, String username, String account, String password,
			Set teacherSubs) {
		this.role = role;
		this.username = username;
		this.account = account;
		this.password = password;
		this.teacherSubs = teacherSubs;
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

	public Set getTeacherSubs() {
		return this.teacherSubs;
	}

	public void setTeacherSubs(Set teacherSubs) {
		this.teacherSubs = teacherSubs;
	}

}