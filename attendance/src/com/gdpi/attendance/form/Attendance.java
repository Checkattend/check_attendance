package com.gdpi.attendance.form;

/**
 * Attendance entity. @author MyEclipse Persistence Tools
 */

public class Attendance implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer leave;
	private Integer truancy;
	private Integer late;
	private Integer leaveEarly;
	private Integer studentId;
	private Integer classId;
	private Integer subjectId;
	private Integer teacherId;

	// Constructors

	/** default constructor */
	public Attendance() {
	}

	/** minimal constructor */
	public Attendance(Integer leave, Integer truancy, Integer late,
			Integer leaveEarly, Integer studentId) {
		this.leave = leave;
		this.truancy = truancy;
		this.late = late;
		this.leaveEarly = leaveEarly;
		this.studentId = studentId;
	}

	/** full constructor */
	public Attendance(Integer leave, Integer truancy, Integer late,
			Integer leaveEarly, Integer studentId, Integer classId,
			Integer subjectId, Integer teacherId) {
		this.leave = leave;
		this.truancy = truancy;
		this.late = late;
		this.leaveEarly = leaveEarly;
		this.studentId = studentId;
		this.classId = classId;
		this.subjectId = subjectId;
		this.teacherId = teacherId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

}