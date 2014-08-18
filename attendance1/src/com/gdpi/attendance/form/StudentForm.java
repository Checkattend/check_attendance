package com.gdpi.attendance.form;

public class StudentForm {
	private Integer id;
	private String studentname;
	private String account;
	private String password;
	private Integer roleId;
	private Integer clasId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getClasId() {
		return clasId;
	}
	public void setClasId(Integer clasId) {
		this.clasId = clasId;
	}
	
}
