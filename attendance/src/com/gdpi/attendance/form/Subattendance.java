package com.gdpi.attendance.form;

/**
 * Subattendance entity. @author MyEclipse Persistence Tools
 */

public class Subattendance implements java.io.Serializable {

	// Fields

	private Integer id;
	private Subject subject;
	private String formname;
	private Integer leave;
	private Integer truancy;
	private Integer late;
	private Integer leaveEarly;
	private String check;

	// Constructors

	/** default constructor */
	public Subattendance() {
	}

	/** full constructor */
	public Subattendance(Subject subject, String formname, Integer leave,
			Integer truancy, Integer late, Integer leaveEarly, String check) {
		this.subject = subject;
		this.formname = formname;
		this.leave = leave;
		this.truancy = truancy;
		this.late = late;
		this.leaveEarly = leaveEarly;
		this.check = check;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getFormname() {
		return this.formname;
	}

	public void setFormname(String formname) {
		this.formname = formname;
	}

	public Integer getLeave() {
		return this.leave;
	}

	public void setLeave(Integer leave) {
		this.leave = leave;
	}

	public Integer getTruancy() {
		return this.truancy;
	}

	public void setTruancy(Integer truancy) {
		this.truancy = truancy;
	}

	public Integer getLate() {
		return this.late;
	}

	public void setLate(Integer late) {
		this.late = late;
	}

	public Integer getLeaveEarly() {
		return this.leaveEarly;
	}

	public void setLeaveEarly(Integer leaveEarly) {
		this.leaveEarly = leaveEarly;
	}

	public String getCheck() {
		return this.check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

}