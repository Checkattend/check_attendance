package com.gdpi.attendance.form;

public class StudentCheckForm {
	private Integer id;
	private String account;
	private String studentName;
	private String teacherName;
	private String subjectName;
	private Integer classHour;
	private Integer leave;
	private Integer truancy;
	private Integer late;
	private Integer leaveEarly;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getClassHour() {
		return classHour;
	}

	public void setClassHour(Integer classHour) {
		this.classHour = classHour;
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

}
