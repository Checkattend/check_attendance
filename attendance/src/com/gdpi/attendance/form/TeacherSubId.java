package com.gdpi.attendance.form;

/**
 * TeacherSubId entity. @author MyEclipse Persistence Tools
 */

public class TeacherSubId implements java.io.Serializable {

	// Fields

	private Teacher teacher;
	private Subject subject;

	// Constructors

	/** default constructor */
	public TeacherSubId() {
	}

	/** full constructor */
	public TeacherSubId(Teacher teacher, Subject subject) {
		this.teacher = teacher;
		this.subject = subject;
	}

	// Property accessors

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TeacherSubId))
			return false;
		TeacherSubId castOther = (TeacherSubId) other;

		return ((this.getTeacher() == castOther.getTeacher()) || (this
				.getTeacher() != null
				&& castOther.getTeacher() != null && this.getTeacher().equals(
				castOther.getTeacher())))
				&& ((this.getSubject() == castOther.getSubject()) || (this
						.getSubject() != null
						&& castOther.getSubject() != null && this.getSubject()
						.equals(castOther.getSubject())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTeacher() == null ? 0 : this.getTeacher().hashCode());
		result = 37 * result
				+ (getSubject() == null ? 0 : this.getSubject().hashCode());
		return result;
	}

}