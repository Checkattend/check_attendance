package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.GreadMajorClassForm;
import com.gdpi.attendance.form.Instructor_gradeForm;
import com.gdpi.attendance.form.MajorForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;


public class SpecifyCounselorDao  {
	  private  JDBConnection connection=null;
	   private TeacherForm teacherForm = null;
	   private Instructor_gradeForm instructor_gradeForm = null;
	   public SpecifyCounselorDao()
	   {
		   connection=new JDBConnection();
	   }
		//指定辅导员
		public int  SpecifyCounselor(String gradename,String Counselor)
		{
			int i=0;
			TeacherDao teacherDao = new TeacherDao();
			int gradeid = teacherDao.getgradeID(gradename);
			int Counselorid= getTeacherId(Counselor) ;
			String sql = "select *from instructor_grade where instructor_grade.grade_id='"+gradeid+"' and instructor_grade.instructor_id='"+Counselorid+"' group by instructor_grade.grade_id";
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
			String sql2="insert into instructor_grade(instructor_grade.grade_id,instructor_grade.instructor_id) values('"+gradeid+"','"+Counselorid+"')";
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
		//获取辅导员
		public List getCounselor() {

			List<TeacherForm> list = new ArrayList();
			String sql = "select *from teacher where teacher.role_id=3";
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
		//获取已安排好的辅导员与年纪
		public List getAllCounselor() {

			List<Instructor_gradeForm> list = new ArrayList();
			String sql = "select grade.id,grade.gradename,teacher.id,teacher.teachername,teacher.account from instructor_grade,grade,teacher where instructor_grade.grade_id = grade.id and instructor_grade.instructor_id = teacher.id ";
			try {
				ResultSet rs = connection.executeQuery(sql);
		      while (rs.next()) {
		    	  instructor_gradeForm = new Instructor_gradeForm();
		    	  instructor_gradeForm.setGradeId(Integer.valueOf(rs.getString(1)));
		    	  instructor_gradeForm.setGradename(Integer.valueOf(rs.getString(2)));
		    	  instructor_gradeForm.setId(Integer.valueOf(rs.getString(3)));
		    	  instructor_gradeForm.setTeachername(rs.getString(4));
		    	  instructor_gradeForm.setAccount(rs.getString(5));
				  list.add(instructor_gradeForm);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		/**
		 * 删除指定辅导员
		 * 
		 * @param classid
		 * @return
		 */
		public int deleteSpecifyCounselor(String gradeid,String teacherid) {
			int flag=0;
			String sql2 = "delete from instructor_grade where instructor_grade.grade_id = '"+gradeid+"' and instructor_grade.instructor_id = '"+teacherid+"'";
			flag=connection.executeUpdate(sql2);//删除attendance

			return flag;
		}
		//获取辅导员与年级
		public Instructor_gradeForm returnInstructor_gradeForm(String gradeid,String teacherid) {

			String sql = "select grade.id,grade.gradename,teacher.id,teacher.teachername,teacher.account from instructor_grade,grade,teacher where instructor_grade.grade_id = '"+gradeid+"' and instructor_grade.instructor_id = '"+teacherid+"' and instructor_grade.grade_id = grade.id and instructor_grade.instructor_id = teacher.id";
			try {
				ResultSet rs = connection.executeQuery(sql);
		      while (rs.next()) {
		    	  instructor_gradeForm = new Instructor_gradeForm();
		    	  instructor_gradeForm.setGradeId(Integer.valueOf(rs.getString(1)));
		    	  instructor_gradeForm.setGradename(Integer.valueOf(rs.getString(2)));
		    	  instructor_gradeForm.setId(Integer.valueOf(rs.getString(3)));
		    	  instructor_gradeForm.setTeachername(rs.getString(4));
		    	  instructor_gradeForm.setAccount(rs.getString(5));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return instructor_gradeForm;
		}
		
		//修改指定辅导员
		public int  modifySpecifyCounselor(Instructor_gradeForm instructor_gradeForm)
		{
			int i=0;
			TeacherDao teacherDao = new TeacherDao();
			int gradeid = teacherDao.getgradeID(String.valueOf(instructor_gradeForm.getGradename()));
			int Counselorid= getTeacherId(instructor_gradeForm.getTeachername()) ;
			String sql2="update instructor_grade set instructor_grade.grade_id = '"+gradeid+"' ,instructor_grade.instructor_id = '"+Counselorid+"' where  instructor_grade.grade_id = '"+instructor_gradeForm.getGradeId()+"' and instructor_grade.instructor_id = '"+instructor_gradeForm.getId()+"'";
			i=connection.executeUpdate(sql2);
			return i;
		}
}
