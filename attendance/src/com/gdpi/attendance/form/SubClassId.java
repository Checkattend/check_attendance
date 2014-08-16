package com.gdpi.attendance.form;

/**
 * SubClassId entity. @author MyEclipse Persistence Tools
 */

public class SubClassId implements java.io.Serializable {

	// Fields

	private Subject subject;
	private Clas clas;

	// Constructors

	/** default constructor */
	public SubClassId() {
	}

	/** full constructor */
	public SubClassId(Subject subject, Clas clas) {
		this.subject = subject;
		this.clas = clas;
	}

	// Property accessors

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SubClassId))
			return false;
		SubClassId castOther = (SubClassId) other;

		return ((this.getSubject() == castOther.getSubject()) || (this
				.getSubject() != null
				&& castOther.getSubject() != null && this.getSubject().equals(
				castOther.getSubject())))
				&& ((this.getClas() == castOther.getClas()) || (this.getClas() != null
						&& castOther.getClas() != null && this.getClas()
						.equals(castOther.getClas())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSubject() == null ? 0 : this.getSubject().hashCode());
		result = 37 * result
				+ (getClas() == null ? 0 : this.getClas().hashCode());
		return result;
	}

}