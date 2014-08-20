package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.StudentCheckForm;
import com.gdpi.attendance.form.StudentForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.tool.JDBConnection;

public class StudentDao {
	private JDBConnection connection = null;
	private StudentForm studentForm = null;
	private StudentCheckForm studentCheckForm = null;
	private SubjectForm subjectForm = null;

	/**
	 * 初始化
	 */
	public StudentDao() {
		connection = new JDBConnection();
	}

	/**
	 * 普通学生登录查询
	 * 
	 * @param account
	 * @return
	 */
	public StudentForm getStudentForm(String account) {
		String sql = "select * from student where account='" + account + "'";
		try {
			ResultSet rs = connection.executeQuery(sql);

			if (rs.next()) {
				studentForm = new StudentForm();
				studentForm.setId(Integer.valueOf(rs.getString(1)));
				studentForm.setStudentname(rs.getString(2));
				studentForm.setAccount(rs.getString(3));
				studentForm.setPassword(rs.getString(4));
				studentForm.setRoleId(Integer.valueOf(rs.getString(5)));
				studentForm.setClasId(Integer.valueOf(rs.getString(6)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentForm;
	}

	/**
	 * 查询该学生本学期所有考勤情况
	 * 
	 * @param classid
	 * @return
	 */
	public List<StudentCheckForm> QueryNumberOfLTLL(Integer studentId) {
		List<StudentCheckForm> list = new ArrayList();
		String sql = "select student.studentname,teacher.teachername,subject.subjectname,attendance.number,attendance.`leave`,attendance.truancy,attendance.late,attendance.leaveEarly from attendance,student,teacher,subject where attendance.student_id='"+studentId+"' and attendance.student_id=student.id and attendance.teacher_id=teacher.id and attendance.subject_id=subject.id";
		ResultSet rs = connection.executeQuery(sql);
		
		try {
			while(rs.next()) {
				studentCheckForm = new StudentCheckForm();
				studentCheckForm.setStudentName(rs.getString(1));
				studentCheckForm.setTeacherName(rs.getString(2));
				studentCheckForm.setSubjectName(rs.getString(3));
				studentCheckForm.setClassHour(Integer.valueOf(rs.getString(4)));
				studentCheckForm.setLeave(Integer.valueOf(rs.getString(5)));
				studentCheckForm.setTruancy(Integer.valueOf(rs.getString(6)));
				studentCheckForm.setLate(Integer.valueOf(rs.getString(7)));
				studentCheckForm.setLeaveEarly(Integer.valueOf(rs.getString(8)));
				list.add(studentCheckForm);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据科目名查询本学期该科目的考情情况
	 * @param studentId
	 * @param subjectId
	 * @return
	 */
	public List<StudentCheckForm> QueryNumberOfLTLL(Integer studentId, Integer subjectId) {
		List<StudentCheckForm> list = new ArrayList();
		String sql = "select student.studentname,teacher.teachername,subject.subjectname,attendance.number,attendance.`leave`,attendance.truancy,attendance.late,attendance.leaveEarly from attendance,student,teacher,subject where attendance.student_id='"+studentId+"' and attendance.subject_id='"+subjectId+"' and attendance.student_id=student.id and attendance.teacher_id=teacher.id and attendance.subject_id=subject.id";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while(rs.next()) {
				studentCheckForm = new StudentCheckForm();
				studentCheckForm.setStudentName(rs.getString(1));
				studentCheckForm.setTeacherName(rs.getString(2));
				studentCheckForm.setSubjectName(rs.getString(3));
				studentCheckForm.setClassHour(Integer.valueOf(rs.getString(4)));
				studentCheckForm.setLeave(Integer.valueOf(rs.getString(5)));
				studentCheckForm.setTruancy(Integer.valueOf(rs.getString(6)));
				studentCheckForm.setLate(Integer.valueOf(rs.getString(7)));
				studentCheckForm.setLeaveEarly(Integer.valueOf(rs.getString(8)));
				list.add(studentCheckForm);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 查询学生所有学科
	 * @param clasId
	 * @return
	 */
	public List<SubjectForm> QuerySubject(Integer clasId) {
		List<SubjectForm> list = new ArrayList();
		String sql = "select subject.id,subject.subjectname,subject.des from subject,clas,sub_class where sub_class.class_id=1 and sub_class.class_id=clas.id and sub_class.subject_id=subject.id";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while(rs.next()) {
				subjectForm = new SubjectForm();
				subjectForm.setId(Integer.valueOf(rs.getString(1)));
				subjectForm.setSubjectname(rs.getString(2));
				subjectForm.setDes(rs.getString(3));
				list.add(subjectForm);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}