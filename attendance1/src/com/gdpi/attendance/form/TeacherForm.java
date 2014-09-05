package com.gdpi.attendance.form;

/*
 * [{id:"id",teachername:"name",account:"acc",password:"pd",roleId:"rid"},{id:"",teachername:""}]
 * 
 * */
public class TeacherForm  {
	private Integer id;
	private String teachername;
	private String account;
	private String password;
	private Integer roleId;
	private String rolename;
	private String roledes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
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
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRoledes() {
		return roledes;
	}
	public void setRoledes(String roledes) {
		this.roledes = roledes;
	}
	
}
