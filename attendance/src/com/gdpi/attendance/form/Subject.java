package com.gdpi.attendance.form;

import java.util.HashSet;
import java.util.Set;

/**
 * Subject entity. @author MyEclipse Persistence Tools
 */

public class Subject implements java.io.Serializable {

	// Fields

	private Integer id;
	private String subjectname;
	private String des;
	private Set teacherSubs = new HashSet(0);
	private Set subClasses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Subject() {
	}

	/** minimal constructor */
	public Subject(String subjectname) {
		this.subjectname = subjectname;
	}

	/** full constructor */
	public Subject(String subjectname, String des, Set teacherSubs,
			Set subClasses) {
		this.subjectname = subjectname;
		this.des = des;
		this.teacherSubs = teacherSubs;
		this.subClasses = subClasses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubjectname() {
		return this.subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Set getTeacherSubs() {
		return this.teacherSubs;
	}

	public void setTeacherSubs(Set teacherSubs) {
		this.teacherSubs = teacherSubs;
	}

	public Set getSubClasses() {
		return this.subClasses;
	}

	public void setSubClasses(Set subClasses) {
		this.subClasses = subClasses;
	}

}