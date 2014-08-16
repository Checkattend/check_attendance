package com.gdpi.attendance.form;

/**
 * TeacherSub entity. @author MyEclipse Persistence Tools
 */

public class TeacherSub implements java.io.Serializable {

	// Fields

	private TeacherSubId id;
	private Subject subject;
	private Teacher teacher;

	// Constructors

	/** default constructor */
	public TeacherSub() {
	}

	/** full constructor */
	public TeacherSub(TeacherSubId id, Subject subject, Teacher teacher) {
		this.id = id;
		this.subject = subject;
		this.teacher = teacher;
	}

	// Property accessors

	public TeacherSubId getId() {
		return this.id;
	}

	public void setId(TeacherSubId id) {
		this.id = id;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}