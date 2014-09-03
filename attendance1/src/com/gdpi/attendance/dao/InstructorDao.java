package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.GraMajClaTeacForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;

public class InstructorDao {
	private JDBConnection connection = null;
	private TeacherForm teacherForm = null;
	private GradeForm gradeForm=null;
	private ClasForm clasForm=null;
	private SubjectForm subjectForm=null;
	public InstructorDao()
	{
		connection = new JDBConnection();
	}
	//获得所开设的课程
	public List getSubject(){
		List<SubjectForm> list=new ArrayList();
		String sql="select subjectname from subject";
		try {
			ResultSet rs = connection.executeQuery(sql);

			while (rs.next()) {
				subjectForm = new SubjectForm();
				subjectForm.setSubjectname(rs.getString(1));
				list.add(subjectForm);
				
			}
          } catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;
	}
	//获得辅导员所带的班级
	public List getClas(int instructorId)
	{
		List<ClasForm> list = new ArrayList();
		String sql=" select clas.classname from clas,grade ,instructor_grade,teacher where instructor_grade.instructor_id='"+instructorId+"' and grade.id=instructor_grade.grade_id and teacher.id=instructor_grade.instructor_id and clas.grade_id=grade.id";
		try {
			ResultSet rs = connection.executeQuery(sql);

			while (rs.next()) {
				clasForm = new ClasForm();
				clasForm.setClasname(rs.getString(1));
				list.add(clasForm);
				
			}
          } catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;
	}
	//获得辅导员所带的年级
	public List getGrade(int instructorId)
	{
		List<GradeForm> list = new ArrayList();
		String sql=" select gradename from grade,instructor_grade,teacher where instructor_grade.instructor_id='"+instructorId+"' and instructor_grade.instructor_id=teacher.id and instructor_grade.grade_id=grade.id ";
		try {
			ResultSet rs = connection.executeQuery(sql);

			while (rs.next()) {
				gradeForm = new GradeForm();
				gradeForm.setGradename(Integer.valueOf(rs.getString(1)));
				list.add(gradeForm);
			}
          } catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;
	}
	//获取辅导员个人信息
	public TeacherForm getInstructor(String account) {
		String sql = "select * from teacher where account='" + account + "'";
		try {
			ResultSet rs = connection.executeQuery(sql);

			if (rs.next()) {
				teacherForm = new TeacherForm();
				teacherForm.setId(Integer.valueOf(rs.getString(1)));
				teacherForm.setTeachername(rs.getString(2));
				teacherForm.setAccount(rs.getString(3));
				teacherForm.setPassword(rs.getString(4));
				teacherForm.setRoleId(Integer.valueOf(rs.getString(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// connection.close();
		return teacherForm;

	}
}
