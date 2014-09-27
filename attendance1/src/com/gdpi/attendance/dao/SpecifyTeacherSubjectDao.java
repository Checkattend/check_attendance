package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.Class_subject_teacherForm;
import com.gdpi.attendance.form.Class_teacherForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.GreadMajorClassForm;
import com.gdpi.attendance.form.Instructor_gradeForm;
import com.gdpi.attendance.form.MajorForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;


public class SpecifyTeacherSubjectDao  {
	  private  JDBConnection connection=null;
	   private TeacherForm teacherForm = null;
	   private Instructor_gradeForm instructor_gradeForm = null;
	   private Class_teacherForm class_teacherForm =null;
	   private Class_subject_teacherForm class_subject_teacherForm = null;
	   public SpecifyTeacherSubjectDao()
	   {
		   connection=new JDBConnection();
	   }
		//指定教师所教专业课
		public int  specifyTeacherSubject(String subjectid,String teacherid)
		{
			int i=0;
			String sql = "select *from teacher_sub where teacher_sub.subject_id ='"+subjectid+"' and teacher_sub.teacher_id= '"+teacherid+"' group by teacher_sub.teacher_id";
			ResultSet rs = connection.executeQuery(sql);
			try {
				if(rs.next())
				{
				    return i;	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql2="insert into teacher_sub(teacher_sub.subject_id,teacher_sub.teacher_id) values('"+subjectid+"','"+teacherid+"')";
			i=connection.executeUpdate(sql2);
			return i;
		}
		
		//获取已安排好教师所教专业课
		public List getSpecifyTeacherSubject() {

			List<Class_subject_teacherForm> list = new ArrayList();
			String sql = "select subject.id,subject.subjectname,teacher.id,teacher.teachername,teacher.account from teacher_sub,subject,teacher where teacher_sub.teacher_id =teacher.id and teacher_sub.subject_id = subject.id group by teacher.teachername ";
			try {
				ResultSet rs = connection.executeQuery(sql);
		      while (rs.next()) {
		    	  class_subject_teacherForm = new Class_subject_teacherForm(); 
		    	  class_subject_teacherForm.setSubjectid(Integer.valueOf(rs.getString(1)));
		    	  class_subject_teacherForm.setSubjectname(rs.getString(2));
		    	  class_subject_teacherForm.setTeacherid(Integer.valueOf(rs.getString(3)));
		    	  class_subject_teacherForm.setTeachername(rs.getString(4));
		    	  class_subject_teacherForm.setAccount(rs.getString(5));
				  list.add(class_subject_teacherForm);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		/**
		 * 删除指定教师所教班级
		 * 
		 * @param classid
		 * @return
		 */
		public int deleteSpecifyTeacherSubject(String subjectid,String teacherid) {
			int flag=0;
			String sql2 = "delete from teacher_sub where teacher_sub.subject_id = '"+subjectid+"' and teacher_sub.teacher_id = '"+teacherid+"'";
			flag=connection.executeUpdate(sql2);//删除attendance

			return flag;
		}
		
		//修改教师所教专业课
		public int  modifySpecifyCounselor(String subjectOld,String teacherOld,String subjectNow,String teacherNow)
		{
			int i=0;
			String sql = "select *from teacher_sub where teacher_sub.subject_id ='"+subjectNow+"' and teacher_sub.teacher_id= '"+teacherNow+"' group by teacher_sub.teacher_id";
			ResultSet rs = connection.executeQuery(sql);
			try {
				if(rs.next())
				{
				    return -1;	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql2="update teacher_sub set teacher_sub.subject_id = '"+subjectNow+"',teacher_sub.teacher_id='"+teacherNow+"' where teacher_sub.subject_id = '"+subjectOld+"' and teacher_sub.teacher_id = '"+teacherOld+"'";
			i=connection.executeUpdate(sql2);
			return i;
		}
		//获取教师所教专业课
		public Class_subject_teacherForm returnSubject_teacherForm(String subjectid,String teacherid) {

			String sql = "select subject.id,subject.subjectname,teacher.id,teacher.teachername,teacher.account from teacher_sub,subject,teacher where teacher_sub.teacher_id =teacher.id and teacher_sub.subject_id = subject.id and teacher_sub.subject_id ='"+subjectid+"' and teacher_sub.teacher_id = '"+teacherid+"'";
			try {
				ResultSet rs = connection.executeQuery(sql);
		      while (rs.next()) {
		    	  class_subject_teacherForm = new Class_subject_teacherForm(); 
		    	  class_subject_teacherForm.setSubjectid(Integer.valueOf(rs.getString(1)));
		    	  class_subject_teacherForm.setSubjectname(rs.getString(2));
		    	  class_subject_teacherForm.setTeacherid(Integer.valueOf(rs.getString(3)));
		    	  class_subject_teacherForm.setTeachername(rs.getString(4));
		    	  class_subject_teacherForm.setAccount(rs.getString(5));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return class_subject_teacherForm;
		}
}
