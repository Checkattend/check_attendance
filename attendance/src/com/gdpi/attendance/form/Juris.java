package com.gdpi.attendance.form;

import java.util.HashSet;
import java.util.Set;

/**
 * Juris entity. @author MyEclipse Persistence Tools
 */

public class Juris implements java.io.Serializable {

	// Fields

	private Integer id;
	private String jurisname;
	private String des;
	private Set roleJurs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Juris() {
	}

	/** minimal constructor */
	public Juris(String jurisname) {
		this.jurisname = jurisname;
	}

	/** full constructor */
	public Juris(String jurisname, String des, Set roleJurs) {
		this.jurisname = jurisname;
		this.des = des;
		this.roleJurs = roleJurs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJurisname() {
		return this.jurisname;
	}

	public void setJurisname(String jurisname) {
		this.jurisname = jurisname;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Set getRoleJurs() {
		return this.roleJurs;
	}

	public void setRoleJurs(Set roleJurs) {
		this.roleJurs = roleJurs;
	}

}