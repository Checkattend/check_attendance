package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.AllStudentForm;
import com.gdpi.attendance.form.GreadMajorClassForm;
import com.gdpi.attendance.form.MajorForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;


public class SubjectDao  {
	  private  JDBConnection connection=null;
      private SubjectForm subjectForm =null;
	   public SubjectDao()
	   {
		   connection=new JDBConnection();
	   }
	   
	  //查询课程表信息
	   public List getSubjectList()
	   {
		   List<SubjectForm> list = new ArrayList();
		   String sql = "select *from subject group by  subject.subjectname";
			try {
				ResultSet rs = connection.executeQuery(sql);
		      while (rs.next()) {
		    	    subjectForm = new SubjectForm();
		    	    subjectForm.setId(Integer.valueOf(rs.getString(1)));
		    	    subjectForm.setSubjectname(rs.getString(2));
		    	    subjectForm.setDes(rs.getString(3));
					list.add(subjectForm);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		   return list;
	   }
	   /**
		 * 添加专业课
		 * 
		 * @param classid
		 * @return
		 */
		public int addSubject(String name,String des)
		{
			int i=0;
			String sql = "select *from subject where subject.subjectname='"+name+"'";
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
			String sql1="insert into subject(subject.subjectname,subject.des) values('"+name+"','"+des+"')";
			i=connection.executeUpdate(sql1);
			return i;
		}
		//通过专业课id查询
		public SubjectForm getSubjectForm(String subjectid)
		{
			String sql = "select *from subject where subject.id = '"+subjectid+"'";
			ResultSet rs = connection.executeQuery(sql);
			
			try {
				while(rs.next()) {
					subjectForm = new SubjectForm();
					subjectForm.setId(Integer.valueOf(rs.getString(1)));
					subjectForm.setSubjectname(rs.getString(2));
					subjectForm.setDes(rs.getString(3));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return subjectForm;
		}
		/**
		 * 修改专业课
		 * 
		 * @param classid
		 * @return
		 */
		public int updateSubject(SubjectForm subjectForm) {
			int i=0;
			String sql = "update subject set subject.subjectname = '"+subjectForm.getSubjectname()+"',subject.des = '"+subjectForm.getDes()+"' where subject.id = '"+subjectForm.getId()+"'";
			i=connection.executeUpdate(sql);
			return i;
		}
		/**
		 * 删除专业课
		 * 
		 * @param classid
		 * @return
		 */
		public int deleteSubject(String subjectid) {
			int i =0;
			String sql = "delete from subject where subject.id='"+subjectid+"'";
			i = connection.executeUpdate(sql);
			
			return i;
		}
}
