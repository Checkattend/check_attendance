package com.gdpi.attendance.form;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	private String rolename;
	private String des;
	private Set students = new HashSet(0);
	private Set roleJurs = new HashSet(0);
	private Set teachers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String rolename) {
		this.rolename = rolename;
	}

	/** full constructor */
	public Role(String rolename, String des, Set students, Set roleJurs,
			Set teachers) {
		this.rolename = rolename;
		this.des = des;
		this.students = students;
		this.roleJurs = roleJurs;
		this.teachers = teachers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getRoleJurs() {
		return this.roleJurs;
	}

	public void setRoleJurs(Set roleJurs) {
		this.roleJurs = roleJurs;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

}