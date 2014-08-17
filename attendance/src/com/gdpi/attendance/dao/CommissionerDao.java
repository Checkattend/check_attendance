package com.gdpi.attendance.dao;

import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.AttendanceForm;
import com.gdpi.attendance.form.StudentForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;


public class CommissionerDao {
	private JDBConnection connection = null;
	private StudentForm studentForm = null;
	private TeacherForm teacherForm = null;
	private SubjectForm subjectForm = null;
	private AttendanceForm attendanceForm = null;
	
	/**
	 * 初始化
	 */
	public CommissionerDao() {
		connection = new JDBConnection();
	}
	
	/**
	 * 查询Attendance、Student、Subject、Teacher表
	 * @param classid
	 * @return
	 */
	public List QueryNumberOfLTLL(Integer classid) {
		List list = new ArrayList();
		return list;
	}
}
