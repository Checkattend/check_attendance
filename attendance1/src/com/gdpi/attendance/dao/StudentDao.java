package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.gdpi.attendance.form.AttendanceForm;
import com.gdpi.attendance.form.StudentForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;
/*import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;*/

public class StudentDao  {
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
	 * 普通学生登录查询
	 * @param account
	 * @return
	 */
	public StudentForm getStudentForm(String account) {
		String sql = "select * from student where account='"+account+"'";
		try{
			   ResultSet rs=connection.executeQuery(sql);
			   
		   	      if(rs.next())
		   	{   
		   	    	  studentForm=new StudentForm();	
		   	    	  studentForm.setId(Integer.valueOf(rs.getString(1)));
		   	    	  studentForm.setStudentname(rs.getString(2));
		   	    	  studentForm.setAccount(rs.getString(3));
		   	    	  studentForm.setPassword(rs.getString(4));
		   	    	  studentForm.setRoleId(Integer.valueOf(rs.getString(5)));
		   	    	  studentForm.setClasId(Integer.valueOf(rs.getString(6)));
		   	   	}
		
		   }catch(SQLException e){
		   	e.printStackTrace();
		   }
		   return studentForm;
	}
	
	/**
	 * 查询该学生考勤情况
	 * 
	 * @param classid
	 * @return
	 */
	public void QueryNumberOfLTLL() {
		// String sql =
		// "select * from attendance where student_id='"+studentId+"' and class_id='"+classId+"'";
		System.out.println("sadhsajkldjlwas");
		/*Page<Record> userPage = Db
				.paginate(
						1,
						30,
						"select student.studentname,teacher.teachername,subject.subjectname,attendance.number,attendance.`leave`,attendance.truancy,attendance.late,attendance.leaveEarly",
						"from attendance,student,teacher,subject where attendance.student_id=1 and attendance.student_id=student.id and attendance.teacher_id=teacher.id and attendance.subject_id=subject.id");
		renderJson(userPage);*/
	}
}