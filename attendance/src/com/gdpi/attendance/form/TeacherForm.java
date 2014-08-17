package com.gdpi.attendance.form;

public class TeacherForm {
	private Integer id;
	private String username;
	private String account;
	private String password;
	private RoleForm roleForm;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public RoleForm getRoleForm() {
		return roleForm;
	}
	public void setRoleForm(RoleForm roleForm) {
		this.roleForm = roleForm;
	}
	
	
}
