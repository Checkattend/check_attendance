package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.GraMajClaTeacForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.SubAttendanceComForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;

public class InstructorDao {
	private JDBConnection connection = null;
	private TeacherForm teacherForm = null;
	private GradeForm gradeForm=null;
	private ClasForm clasForm=null;
	private SubjectForm subjectForm=null;
	private SubAttendanceComForm SubAttComForm=null;
	public InstructorDao()
	{
		connection = new JDBConnection();
	}
	//获得按时间查询得到的数据
	public List ToViewSubAttendance(String grade,String clas,String time1,String time2)
	{
		List<SubAttendanceComForm> list=new ArrayList();
		String sql="select grade.gradename,subattendance.formname,clas.classname,`subject`.subjectname,teacher.teachername,thedate,`leave`,truancy,late,leaveEarly,`check`,number from subattendance,clas,`subject`,teacher,grade where   grade.id=clas.grade_id and subattendance.class_id=clas.id and `subject`.id=subattendance.subject_id and teacher.id=subattendance.teacher_id and grade.gradename='"+grade+"' and clas.classname='"+clas+"' and  (substr(date(subattendance.thedate),1,7) BETWEEN '"+time1+"' AND '"+time2+"')";
		try {
			ResultSet rs = connection.executeQuery(sql);

			while (rs.next()) {
				SubAttComForm = new SubAttendanceComForm();
				SubAttComForm.setGradename(Integer.valueOf(rs.getString(1)));
				SubAttComForm.setFormname(rs.getString(2));
				SubAttComForm.setClassname(rs.getString(3));
				SubAttComForm.setSubjectname(rs.getString(4));
				SubAttComForm.setTeachername(rs.getString(5));
				SubAttComForm.setThedate(rs.getString(6));
				SubAttComForm.setLeave(Integer.valueOf(rs.getString(7)));
				SubAttComForm.setTruancy(Integer.valueOf(rs.getString(8)));
				SubAttComForm.setLate(Integer.valueOf(rs.getString(9)));
				SubAttComForm.setLeaveEarly(Integer.valueOf(rs.getString(10)));
				SubAttComForm.setCheck(rs.getString(11));
				list.add(SubAttComForm);	
			}
          } catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;
	}
	//获得考勤表中的时间
	public List getAttendanceTime(int instructorId)
	{
		List<SubAttendanceComForm> list=new ArrayList();	
		String sql="select DISTINCT  left(thedate,7) as thedate from subattendance,clas,`subject`,teacher,grade where   grade.id=clas.grade_id and subattendance.class_id=clas.id and `subject`.id=subattendance.subject_id and teacher.id=subattendance.teacher_id and grade.gradename in( select gradename from grade,instructor_grade,teacher where instructor_grade.instructor_id='"+instructorId+"' and instructor_grade.instructor_id=teacher.id and instructor_grade.grade_id=grade.id) ORDER BY thedate ASC";
		try {
			ResultSet rs = connection.executeQuery(sql);

			while (rs.next()) {
				SubAttComForm = new SubAttendanceComForm();
				SubAttComForm.setThedate(rs.getString(1));
				list.add(SubAttComForm);	
			}
          } catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;
	}
	//获得按单科查询得到的数据
	public List ToView_SubAttendance(String grade,String clas,String subject)
	{
		List<SubAttendanceComForm> list=new ArrayList();
		String sql="select grade.gradename,subattendance.formname,clas.classname,`subject`.subjectname,teacher.teachername,thedate,`leave`,truancy,late,leaveEarly,`check`,number from subattendance,clas,`subject`,teacher,grade where   grade.id=clas.grade_id and subattendance.class_id=clas.id and `subject`.id=subattendance.subject_id and teacher.id=subattendance.teacher_id and grade.gradename='"+grade+"' and clas.classname='"+clas+"' and `subject`.subjectname='"+subject+"'";
		try {
			ResultSet rs = connection.executeQuery(sql);

			while (rs.next()) {
				SubAttComForm = new SubAttendanceComForm();
				SubAttComForm.setGradename(Integer.valueOf(rs.getString(1)));
				SubAttComForm.setFormname(rs.getString(2));
				SubAttComForm.setClassname(rs.getString(3));
				SubAttComForm.setSubjectname(rs.getString(4));
				SubAttComForm.setTeachername(rs.getString(5));
				SubAttComForm.setThedate(rs.getString(6));
				SubAttComForm.setLeave(Integer.valueOf(rs.getString(7)));
				SubAttComForm.setTruancy(Integer.valueOf(rs.getString(8)));
				SubAttComForm.setLate(Integer.valueOf(rs.getString(9)));
				SubAttComForm.setLeaveEarly(Integer.valueOf(rs.getString(10)));
				SubAttComForm.setCheck(rs.getString(11));
				list.add(SubAttComForm);	
			}
          } catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;
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

			while(rs.next()) {
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
