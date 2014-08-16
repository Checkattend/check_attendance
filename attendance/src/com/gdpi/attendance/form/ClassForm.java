package com.gdpi.attendance.form;

public class ClassForm {
	private Integer id;
	private String classname;
	private GradeForm gradeForm;
	private MajorForm majorForm;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public GradeForm getGradeForm() {
		return gradeForm;
	}
	public void setGradeForm(GradeForm gradeForm) {
		this.gradeForm = gradeForm;
	}
	public MajorForm getMajorForm() {
		return majorForm;
	}
	public void setMajorForm(MajorForm majorForm) {
		this.majorForm = majorForm;
	}
	
	
}
