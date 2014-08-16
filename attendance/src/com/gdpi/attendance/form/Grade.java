package com.gdpi.attendance.form;

import java.util.HashSet;
import java.util.Set;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */

public class Grade implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer gradename;
	private String des;
	private Set clases = new HashSet(0);

	// Constructors

	/** default constructor */
	public Grade() {
	}

	/** minimal constructor */
	public Grade(Integer gradename) {
		this.gradename = gradename;
	}

	/** full constructor */
	public Grade(Integer gradename, String des, Set clases) {
		this.gradename = gradename;
		this.des = des;
		this.clases = clases;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGradename() {
		return this.gradename;
	}

	public void setGradename(Integer gradename) {
		this.gradename = gradename;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Set getClases() {
		return this.clases;
	}

	public void setClases(Set clases) {
		this.clases = clases;
	}

}