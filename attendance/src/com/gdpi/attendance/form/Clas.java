package com.gdpi.attendance.form;

import java.util.HashSet;
import java.util.Set;

/**
 * Clas entity. @author MyEclipse Persistence Tools
 */

public class Clas implements java.io.Serializable {

	// Fields

	private Integer id;
	private Major major;
	private Grade grade;
	private String classname;
	private Set students = new HashSet(0);
	private Set subClasses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Clas() {
	}

	/** minimal constructor */
	public Clas(Major major, Grade grade, String classname) {
		this.major = major;
		this.grade = grade;
		this.classname = classname;
	}

	/** full constructor */
	public Clas(Major major, Grade grade, String classname, Set students,
			Set subClasses) {
		this.major = major;
		this.grade = grade;
		this.classname = classname;
		this.students = students;
		this.subClasses = subClasses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getSubClasses() {
		return this.subClasses;
	}

	public void setSubClasses(Set subClasses) {
		this.subClasses = subClasses;
	}

}