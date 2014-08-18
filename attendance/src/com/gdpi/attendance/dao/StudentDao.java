package com.gdpi.attendance.dao;

import com.gdpi.attendance.form.AttendanceForm;
import com.gdpi.attendance.form.StudentForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class StudentDao extends Controller {
	private JDBConnection connection = null;
	private StudentForm studentForm = null;
	private TeacherForm teacherForm = null;
	private SubjectForm subjectForm = null;
	private AttendanceForm attendanceForm = null;

	/**
	 * 初始化
	 */
	public StudentDao() {
		connection = new JDBConnection();
	}

	/**
	 * 查询该学生考勤情况
	 * 
	 * @param classid
	 * @return
	 */
	public void QueryNumberOfLTLL(Integer studentId, Integer classId) {
		// String sql =
		// "select * from attendance where student_id='"+studentId+"' and class_id='"+classId+"'";
		Page<Record> userPage = Db
				.paginate(
						1,
						30,
						"select student.studentname,teacher.teachername,subject.subjectname,attendance.number,attendance.`leave`,attendance.truancy,attendance.late,attendance.leaveEarly",
						"from attendance,student,teacher,subject where attendance.student_id=1 attendance.student_id=student.id and attendance.teacher_id=teacher.id and attendance.subject_id=subject.id");
		renderJson(userPage);
	}
}