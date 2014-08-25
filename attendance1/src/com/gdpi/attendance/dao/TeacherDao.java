package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.GraMajClaTeacForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.SubAttendanceComForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;

public class TeacherDao {
	private JDBConnection connection = null;
	private TeacherForm teacherForm = null;
	private GraMajClaTeacForm gmctForm = null;
	private SubAttendanceComForm subAttendance = null;
	private GradeForm gradeForm=null;

	public TeacherDao() {
		connection = new JDBConnection();
	}
     //获取个人信息
	public TeacherForm getTeacherForm(String account) {
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

	public List getGrade() {

		List<GradeForm> list = new ArrayList();
		String sql = "select * from grade";
		try {
			ResultSet rs = connection.executeQuery(sql);
	      while (rs.next()) {
				gradeForm = new GradeForm();
				gradeForm.setId(Integer.valueOf(rs.getString(1)));
				gradeForm.setGradename(Integer.valueOf(rs.getString(2)));
				gradeForm.setDes(rs.getString(3));
				list.add(gradeForm);
				//System.out.println(gradeForm.getGradename()+"aa");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// connection.close();
		return list;
	}

	// 查询授课班级
	public List getTeachClass(String teachername) {

		List<GraMajClaTeacForm> list = new ArrayList();
		String sql = "select grade.gradename ,major.majorname,clas.classname from teacher,clas,major,grade where teacher.teachername='"
				+ teachername
				+ "' and teacher.id=clas.id and clas.major_id=major.id and clas.grade_id=grade.id";
		try {
			ResultSet rs = connection.executeQuery(sql);

			while (rs.next()) {
				gmctForm = new GraMajClaTeacForm();
				gmctForm.setGradename(rs.getString(1));
				gmctForm.setMajorname(rs.getString(2));
				gmctForm.setClassname(rs.getString(3));
				list.add(gmctForm);
				System.out.println(gmctForm.getClassname());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// connection.close();
		return list;
	}

	// 查看班级考勤
	public List getsSubAttendance(int teacher_id) {
		List<SubAttendanceComForm> list = new ArrayList();
		String sql = "select grade.gradename,subattendance.formname,clas.classname,`subject`.subjectname,teacher.teachername,thedate,`leave`,truancy,late,leaveEarly,`check`,number from subattendance,clas,`subject`,teacher,grade where subattendance.teacher_id='"+teacher_id+"'and grade.id=clas.grade_id and subattendance.class_id=clas.id and `subject`.id=subattendance.subject_id and teacher.id=subattendance.teacher_id";
		try {
			ResultSet rs = connection.executeQuery(sql);

			while (rs.next()) {
				subAttendance = new SubAttendanceComForm();
				subAttendance.setGradename(Integer.valueOf(rs.getString(1)));
				subAttendance.setFormname(rs.getString(2));
				subAttendance.setClassname(rs.getString(3));
				subAttendance.setSubjectname(rs.getString(4));
				subAttendance.setTeachername(rs.getString(5));
				subAttendance.setThedate(rs.getString(6));
				subAttendance.setLeave(Integer.valueOf(rs.getString(7)));
				subAttendance.setTruancy(Integer.valueOf(rs.getString(8)));
				subAttendance.setLate(Integer.valueOf(rs.getString(9)));
				subAttendance.setLeaveEarly(Integer.valueOf(rs.getString(10)));
				subAttendance.setCheck(rs.getString(11));
				subAttendance.setId(Integer.valueOf(rs.getString(12)));
				list.add(subAttendance);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// connection.close();
		return list;
		}
	public void ToCommit(String check,int SubId)
	{
		String sql="update subattendance set `check`='"+check+"' where number='"+SubId+"' ";
	                  connection.executeUpdate(sql);
         }
	
}
