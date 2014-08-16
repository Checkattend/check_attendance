package com.gdpi.attendance.form;

public class AttendanceForm {
	private Integer id;
	private Integer leave;
	private Integer truancy;
	private Integer late;
	private Integer leaveEarly;
	private StudentForm studentForm;
	private ClassForm classForm;
	private SubjectForm subjectForm;
	private TeacherForm teacherForm;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public StudentForm getStudentForm() {
		return studentForm;
	}
	public void setStudentForm(StudentForm studentForm) {
		this.studentForm = studentForm;
	}
	public ClassForm getClassForm() {
		return classForm;
	}
	public void setClassForm(ClassForm classForm) {
		this.classForm = classForm;
	}
	public SubjectForm getSubjectForm() {
		return subjectForm;
	}
	public void setSubjectForm(SubjectForm subjectForm) {
		this.subjectForm = subjectForm;
	}
	public TeacherForm getTeacherForm() {
		return teacherForm;
	}
	public void setTeacherForm(TeacherForm teacherForm) {
		this.teacherForm = teacherForm;
	}
	
	
}
