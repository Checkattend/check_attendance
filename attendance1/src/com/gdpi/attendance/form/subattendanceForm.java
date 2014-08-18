package com.gdpi.attendance.form;

public class subattendanceForm {
	private Integer id;
	private String formname;
	private Integer subjectId;
	private Integer leave;
	private Integer truancy;
	private Integer late;
	private Integer leaveEarly;
	private String check;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFormname() {
		return formname;
	}
	public void setFormname(String formname) {
		this.formname = formname;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public Integer getLeave() {
		return leave;
	}
	public void setLeave(Integer leave) {
		this.leave = leave;
	}
	public Integer getTruancy() {
		return truancy;
	}
	public void setTruancy(Integer truancy) {
		this.truancy = truancy;
	}
	public Integer getLate() {
		return late;
	}
	public void setLate(Integer late) {
		this.late = late;
	}
	public Integer getLeaveEarly() {
		return leaveEarly;
	}
	public void setLeaveEarly(Integer leaveEarly) {
		this.leaveEarly = leaveEarly;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	
}
