package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.GreadMajorClassForm;
import com.gdpi.attendance.form.MajorForm;
import com.gdpi.attendance.tool.JDBConnection;


public class GreadMajorClassDao  {
	  private  JDBConnection connection=null;
	   private  MajorForm	majorForm=null;
	   private  GradeForm 	gradeForm=null;
	   private  ClasForm clasForm=null;
	   private GreadMajorClassForm greadMajorClassForm = null;
	   public GreadMajorClassDao()
	   {
		   connection=new JDBConnection();
	   }
	   /**
		 * 查询本系全部年级、专业、班级表
		 * 
		 * @param classid
		 * @return
		 */
		public List<GreadMajorClassForm> QueryNumberOfLTLL() {
			List<GreadMajorClassForm> list = new ArrayList();
			String sql = "select grade.gradename,major.majorname,clas.classname,grade.des,major.des from grade,major,clas where clas.grade_id=grade.id and clas.major_id=major.id;";
			ResultSet rs = connection.executeQuery(sql);
			
			try {
				while(rs.next()) {
					greadMajorClassForm = new GreadMajorClassForm();
					greadMajorClassForm.setGradename(Integer.valueOf(rs.getString(1)));
					greadMajorClassForm.setMajorname(rs.getString(2));
					greadMajorClassForm.setClasname(rs.getString(3));
					greadMajorClassForm.setGradeDes(rs.getString(4));
					greadMajorClassForm.setMajorDes(rs.getString(5));
					list.add(greadMajorClassForm);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		 /**
		 * 按clasName查询本系年级、专业、班级表
		 * 
		 * @param classid
		 * @return
		 */
		public GreadMajorClassForm clasName(String clasName) {
			greadMajorClassForm = new GreadMajorClassForm();
			String sql = "select * from grade,major,clas where clas.grade_id=grade.id and clas.major_id=major.id and clas.classname='"+clasName+"'";
			ResultSet rs = connection.executeQuery(sql);
			
			try {
				while(rs.next()) {
					greadMajorClassForm = new GreadMajorClassForm();
					greadMajorClassForm.setGradename(Integer.valueOf(rs.getString(1)));
					greadMajorClassForm.setMajorname(rs.getString(2));
					greadMajorClassForm.setClasname(rs.getString(3));
					greadMajorClassForm.setGradeDes(rs.getString(4));
					greadMajorClassForm.setMajorDes(rs.getString(5));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return greadMajorClassForm;
		}
		/**
		 * 添加年级-专业-班级
		 * 
		 * @param classid
		 * @return
		 */
		public int addGreadMajorClassForm(GradeForm gradeForm,MajorForm majorForm,ClasForm clasForm,String add)
		{
			int i=0;
			if(add.equals("1"))
			{
				//添加班级
				if(getGradeForm(gradeForm.getGradename())==null)
				{
					String sql="insert into grade (gradename,des) values('"+gradeForm.getGradename()+"','"+gradeForm.getDes()+"')";
					i=connection.executeUpdate(sql);
				}
				String sql2="insert into clas (classname,grade_id,major_id) values('"+clasForm.getClasname()+"','"+getGradeForm(gradeForm.getGradename()).getId()+"','"+getMajorForm(majorForm.getMajorname()).getId()+"')";
				i=connection.executeUpdate(sql2);
				
			}
			if(add.equals("2"))
			{
				//添加专业
				String sql1="insert into major (majorname,des) values('"+majorForm.getMajorname()+"','"+majorForm.getDes()+"')";
				i=connection.executeUpdate(sql1);
			}
			if(add.equals("3"))
			{
				//添加一个新班级
				int grade_id=getGradeForm(gradeForm.getGradename()).getId();
				int major_id=getMajorForm(majorForm.getMajorname()).getId();
				if(getGradeForm(gradeForm.getGradename())==null)
				{
					String sql="insert into grade (gradename,des) values('"+gradeForm.getGradename()+"','"+gradeForm.getDes()+"')";
					i=connection.executeUpdate(sql);
				}
				String sql2="insert into clas (classname,grade_id,major_id) values('"+clasForm.getClasname()+"','"+grade_id+"','"+major_id+"')";
				i=connection.executeUpdate(sql2);
			}
			return i;
		}
		/**
		 * 按年级名查询本系全部年级表
		 * 
		 * @param classid
		 * @return
		 */
		public GradeForm getGradeForm(int gradename) {
			String sql = "select * from grade where grade.gradename="+gradename;
			ResultSet rs = connection.executeQuery(sql);
			
			try {
				while(rs.next()) {
					gradeForm = new GradeForm();
					gradeForm.setId(Integer.valueOf(rs.getString(1)));
					gradeForm.setGradename(Integer.valueOf(rs.getString(2)));
					gradeForm.setDes(rs.getString(3));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return gradeForm;
		}
		/**
		 * 按专业名查询专业表
		 * 
		 * @param classid
		 * @return
		 */
		public MajorForm getMajorForm(String majorname) {
			String sql = "select * from major where major.majorname='"+majorname+"';";
			ResultSet rs = connection.executeQuery(sql);
			
			try {
				while(rs.next()) {
					majorForm = new MajorForm();
					majorForm.setId(Integer.valueOf(rs.getString(1)));
					
					majorForm.setMajorname(rs.getString(2));
					majorForm.setDes(rs.getString(3));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return majorForm;
		}
		/**
		 * 查询专业表
		 * 
		 * @param classid
		 * @return
		 */
		public List<MajorForm> AllMajorForm() {
			List<MajorForm> list = new ArrayList();
			String sql = "select * from major";
			ResultSet rs = connection.executeQuery(sql);
			
			try {
				while(rs.next()) {
					majorForm = new MajorForm();
					majorForm.setId(Integer.valueOf(rs.getString(1)));				
					majorForm.setMajorname(rs.getString(2));
					majorForm.setDes(rs.getString(3));
					list.add(majorForm);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
}
