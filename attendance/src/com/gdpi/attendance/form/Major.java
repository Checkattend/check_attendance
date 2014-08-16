package com.gdpi.attendance.form;

import java.util.HashSet;
import java.util.Set;

/**
 * Major entity. @author MyEclipse Persistence Tools
 */

public class Major implements java.io.Serializable {

	// Fields

	private Integer id;
	private String majorname;
	private String des;
	private Set clases = new HashSet(0);

	// Constructors

	/** default constructor */
	public Major() {
	}

	/** minimal constructor */
	public Major(String majorname) {
		this.majorname = majorname;
	}

	/** full constructor */
	public Major(String majorname, String des, Set clases) {
		this.majorname = majorname;
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

	public String getMajorname() {
		return this.majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
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