package com.gdpi.attendance.form;

public class SubAttendanceComForm {
	private String formname;
	private Integer gradename;
	private String classname;
	private String subjectname;
	private String teachername;
	private String thedate;
	private Integer leave;
	private Integer truancy;
	private Integer late;
	private Integer leaveEarly;
	private String check;
	private Integer id;
	
	public String getFormname() {
		return formname;
	}
	public void setFormname(String formname) {
		this.formname = formname;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getThedate() {
		return thedate;
	}
	public void setThedate(String thedate) {
		this.thedate = thedate;
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
	public Integer getGradename() {
		return gradename;
	}
	public void setGradename(Integer gradename) {
		this.gradename = gradename;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
