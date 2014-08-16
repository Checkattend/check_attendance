package com.gdpi.attendance.form;

/**
 * RoleJurId entity. @author MyEclipse Persistence Tools
 */

public class RoleJurId implements java.io.Serializable {

	// Fields

	private Role role;
	private Juris juris;

	// Constructors

	/** default constructor */
	public RoleJurId() {
	}

	/** full constructor */
	public RoleJurId(Role role, Juris juris) {
		this.role = role;
		this.juris = juris;
	}

	// Property accessors

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Juris getJuris() {
		return this.juris;
	}

	public void setJuris(Juris juris) {
		this.juris = juris;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoleJurId))
			return false;
		RoleJurId castOther = (RoleJurId) other;

		return ((this.getRole() == castOther.getRole()) || (this.getRole() != null
				&& castOther.getRole() != null && this.getRole().equals(
				castOther.getRole())))
				&& ((this.getJuris() == castOther.getJuris()) || (this
						.getJuris() != null
						&& castOther.getJuris() != null && this.getJuris()
						.equals(castOther.getJuris())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRole() == null ? 0 : this.getRole().hashCode());
		result = 37 * result
				+ (getJuris() == null ? 0 : this.getJuris().hashCode());
		return result;
	}

}