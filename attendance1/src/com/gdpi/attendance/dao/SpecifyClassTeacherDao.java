package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.Class_teacherForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.GreadMajorClassForm;
import com.gdpi.attendance.form.Instructor_gradeForm;
import com.gdpi.attendance.form.MajorForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;


public class SpecifyClassTeacherDao  {
	  private  JDBConnection connection=null;
	   private TeacherForm teacherForm = null;
	   private Instructor_gradeForm instructor_gradeForm = null;
	   private Class_teacherForm class_teacherForm =null;
	   public SpecifyClassTeacherDao()
	   {
		   connection=new JDBConnection();
	   }
		//指定教师
		public int  specifyClassTeacherDao(String clasid,String teacher)
		{
			int i=0;
			TeacherDao teacherDao = new TeacherDao();
			int teacherid = getTeacherId(teacher) ;
			String sql = "select *from class_teacher where class_teacher.class_id ='"+clasid+"' and class_teacher.teacher_id= '"+teacherid+"' group by class_teacher.teacher_id";
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
			String sql2="insert into class_teacher(class_teacher.class_id,class_teacher.teacher_id) values('"+clasid+"','"+teacherid+"')";
			i=connection.executeUpdate(sql2);
			return i;
		}
		
		//获取个人信息
		public int getTeacherId(String teachername) {
			String sql = "select *from teacher where teacher.teachername='"+teachername+"'";
			try {
				ResultSet rs = connection.executeQuery(sql);

				if (rs.next()) {
					teacherForm = new TeacherForm();
					teacherForm.setId(Integer.valueOf(rs.getString(1)));			
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			// connection.close();
			return teacherForm.getId();

		}
		//获取教师
		public List getTeacher() {

			List<TeacherForm> list = new ArrayList();
			String sql = "select *from teacher where teacher.role_id=2";
			try {
				ResultSet rs = connection.executeQuery(sql);
		      while (rs.next()) {
		    	    teacherForm = new TeacherForm();
		    	    teacherForm.setId(Integer.valueOf(rs.getString(1)));
					teacherForm.setTeachername(rs.getString(2));
					teacherForm.setAccount(rs.getString(3));
					teacherForm.setPassword(rs.getString(4));
					teacherForm.setRoleId(Integer.valueOf(rs.getString(5)));
					list.add(teacherForm);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		//获取已安排好的教师所教班级
		public List getSpecifyClassTeacher() {

			List<Class_teacherForm> list = new ArrayList();
			String sql = "select clas.id,clas.classname,clas.grade_id,clas.major_id,teacher.id,teacher.teachername,teacher.account,teacher.role_id,grade.gradename,major.majorname from class_teacher,clas,teacher,grade,major where class_teacher.class_id =clas.id and class_teacher.teacher_id = teacher.id and clas.grade_id = grade.id and clas.major_id = major.id";
			try {
				ResultSet rs = connection.executeQuery(sql);
		      while (rs.next()) {
		    	  class_teacherForm = new Class_teacherForm();
		    	  class_teacherForm.setClasId(Integer.valueOf(rs.getString(1)));
		    	  class_teacherForm.setClasname(rs.getString(2));
		    	  class_teacherForm.setGradeId(Integer.valueOf(rs.getString(3)));
		    	  class_teacherForm.setMajorId(Integer.valueOf(rs.getString(4)));
		    	  class_teacherForm.setTeacherid(Integer.valueOf(rs.getString(5)));
		    	  class_teacherForm.setTeachername(rs.getString(6));
		    	  class_teacherForm.setAccount(rs.getString(7));
		    	  class_teacherForm.setRoleId(Integer.valueOf(rs.getString(8)));
		    	  class_teacherForm.setGradename(Integer.valueOf(rs.getString(9)));
		    	  class_teacherForm.setMajorname(rs.getString(10));
				  list.add(class_teacherForm);
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
		public int deleteSpecifyClassTeacher(String clasid,String teacherid) {
			int flag=0;
			String sql2 = "delete from class_teacher where class_teacher.class_id = '"+clasid+"' and class_teacher.teacher_id = '"+teacherid+"'";
			flag=connection.executeUpdate(sql2);//删除attendance

			return flag;
		}
		
		//修改指定辅导员
		public int  modifySpecifyCounselor(String clasOld,String teacherOld,String clasNow,String teacherNow)
		{
			int i=0;
			String sql2="update class_teacher set class_teacher.class_id = '"+clasNow+"',class_teacher.teacher_id='"+teacherNow+"' where class_teacher.class_id = '"+clasOld+"' and class_teacher.teacher_id = '"+teacherOld+"'";
			i=connection.executeUpdate(sql2);
			return i;
		}
		//获取教师所教班级
		public Class_teacherForm returnClass_teacherForm(String clasid,String teacherid) {

			String sql = "select clas.id,teacher.id,clas.classname,teacher.teachername,teacher.account,grade.gradename,major.majorname from class_teacher,clas,teacher,major,grade where class_teacher.class_id = clas.id and class_teacher.teacher_id = teacher.id and clas.grade_id = grade.id and clas.major_id = major.id and class_teacher.class_id ='"+clasid+"' and class_teacher.teacher_id = '"+teacherid+"' ";
			try {
				ResultSet rs = connection.executeQuery(sql);
		      while (rs.next()) {
		    	  class_teacherForm = new Class_teacherForm();
		    	  class_teacherForm.setClasId(Integer.valueOf(rs.getString(1)));
		    	  class_teacherForm.setTeacherid(Integer.valueOf(rs.getString(2)));
		    	  class_teacherForm.setClasname(rs.getString(3));
		    	  class_teacherForm.setTeachername(rs.getString(4));
		    	  class_teacherForm.setAccount(rs.getString(5));
		    	  class_teacherForm.setGradename(Integer.valueOf(rs.getString(6)));
		    	  class_teacherForm.setMajorname(rs.getString(7));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return class_teacherForm;
		}
}
