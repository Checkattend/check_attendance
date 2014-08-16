package com.gdpi.attendance.form;

/**
 * SubClass entity. @author MyEclipse Persistence Tools
 */

public class SubClass implements java.io.Serializable {

	// Fields

	private SubClassId id;
	private Subject subject;
	private Clas clas;

	// Constructors

	/** default constructor */
	public SubClass() {
	}

	/** full constructor */
	public SubClass(SubClassId id, Subject subject, Clas clas) {
		this.id = id;
		this.subject = subject;
		this.clas = clas;
	}

	// Property accessors

	public SubClassId getId() {
		return this.id;
	}

	public void setId(SubClassId id) {
		this.id = id;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Clas getClas() {
		return this.clas;
	}

	public void setClas(Clas clas) {
		this.clas = clas;
	}

}