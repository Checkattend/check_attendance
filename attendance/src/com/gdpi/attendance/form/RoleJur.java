package com.gdpi.attendance.form;

/**
 * RoleJur entity. @author MyEclipse Persistence Tools
 */

public class RoleJur implements java.io.Serializable {

	// Fields

	private RoleJurId id;
	private Juris juris;
	private Role role;

	// Constructors

	/** default constructor */
	public RoleJur() {
	}

	/** full constructor */
	public RoleJur(RoleJurId id, Juris juris, Role role) {
		this.id = id;
		this.juris = juris;
		this.role = role;
	}

	// Property accessors

	public RoleJurId getId() {
		return this.id;
	}

	public void setId(RoleJurId id) {
		this.id = id;
	}

	public Juris getJuris() {
		return this.juris;
	}

	public void setJuris(Juris juris) {
		this.juris = juris;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}