package com.gdpi.attendance.form;

public class AllattendanceForm {
    private int id;
    private String account=null;
    private String studentname=null;
    private String teachername=null;
    private String subjectname=null;
    private int number;
    private int leave;
    private int truancy;
    private int late;
    private int leaveEarly;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getLeave() {
		return leave;
	}
	public void setLeave(int leave) {
		this.leave = leave;
	}
	public int getTruancy() {
		return truancy;
	}
	public void setTruancy(int truancy) {
		this.truancy = truancy;
	}
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	public int getLeaveEarly() {
		return leaveEarly;
	}
	public void setLeaveEarly(int leaveEarly) {
		this.leaveEarly = leaveEarly;
	}
}
