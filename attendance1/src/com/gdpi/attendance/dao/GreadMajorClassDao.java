package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.GreadMajorClassForm;
import com.gdpi.attendance.form.MajorForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;


public class GreadMajorClassDao  {
	  private  JDBConnection connection=null;
	   private  MajorForm	majorForm=null;
	   private  GradeForm 	gradeForm=null;
	   private  ClasForm clasForm=null;
	   private GreadMajorClassForm greadMajorClassForm = null;
	   private TeacherForm teacherForm = null;
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
			String sql = "select grade.gradename,major.majorname,clas.classname,grade.des,major.des,clas.id,grade.id,major.id from grade,major,clas where clas.grade_id=grade.id and clas.major_id=major.id";
			ResultSet rs = connection.executeQuery(sql);
			
			try {
				while(rs.next()) {
					greadMajorClassForm = new GreadMajorClassForm();
					greadMajorClassForm.setGradename(Integer.valueOf(rs.getString(1)));
					greadMajorClassForm.setMajorname(rs.getString(2));
					greadMajorClassForm.setClasname(rs.getString(3));
					greadMajorClassForm.setGradeDes(rs.getString(4));
					greadMajorClassForm.setMajorDes(rs.getString(5));
					greadMajorClassForm.setClasId(Integer.valueOf(rs.getString(6)));
					greadMajorClassForm.setGradeId(Integer.valueOf(rs.getString(7)));
					greadMajorClassForm.setMajorId(Integer.valueOf(rs.getString(8)));
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
				String sql2="insert into clas (classname,grade_id,major_id) values('"+clasForm.getClasname()+"','"+grade_id+"','"+major_id+"')";
				i=connection.executeUpdate(sql2);
			}
			//添加年级
			if(add.equals("4"))
			{
				String sql="insert into grade (gradename,des) values('"+gradeForm.getGradename()+"','"+gradeForm.getDes()+"')";
				i=connection.executeUpdate(sql);
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
			String sql = "select * from major where major.majorname='"+majorname+"'";
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
		/**
		 * 按班级名-专业名-年级名查询整个表
		 * 
		 * @param classid
		 * @return
		 */
		public GreadMajorClassForm GreadMajorClassForm(GreadMajorClassForm greadMajorClassForm) {
			String sql = "select grade.gradename,major.majorname,clas.classname,grade.des,major.des,clas.id,grade.id,major.id  from clas,grade,major where clas.id='"+greadMajorClassForm.getClasId()+"' and grade.id='"+greadMajorClassForm.getGradeId()+"' and major.id='"+greadMajorClassForm.getMajorId()+"'and clas.grade_id=grade.id and clas.major_id=major.id";
			ResultSet rs = connection.executeQuery(sql);
			
			try {
				while(rs.next()) {
					greadMajorClassForm = new GreadMajorClassForm();
					greadMajorClassForm.setGradename(Integer.valueOf(rs.getString(1)));
					greadMajorClassForm.setMajorname(rs.getString(2));
					greadMajorClassForm.setClasname(rs.getString(3));
					greadMajorClassForm.setGradeDes(rs.getString(4));
					greadMajorClassForm.setMajorDes(rs.getString(5));
					greadMajorClassForm.setClasId(Integer.valueOf(rs.getString(6)));
					greadMajorClassForm.setGradeId(Integer.valueOf(rs.getString(7)));
					greadMajorClassForm.setMajorId(Integer.valueOf(rs.getString(8)));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return greadMajorClassForm;
		}
		
		/**
		 * 修改
		 * 
		 * @param classid
		 * @return
		 */
		public int updateGreadMajorClassForm(GreadMajorClassForm greadMajorClassForm) {
			int i=0;
			String sql = "update clas set clas.classname='"+greadMajorClassForm.getClasname()+"',clas.grade_id='"+greadMajorClassForm.getGradeId()+"',clas.major_id='"+greadMajorClassForm.getMajorId()+"' where clas.id = '"+greadMajorClassForm.getClasId()+"'";
			i=connection.executeUpdate(sql);
			return i;
		}
		/**
		 * 删除
		 * 
		 * @param classid
		 * @return
		 */
		public int deleteGreadMajorClassForm(String clasId) {
			int flag=0;
			String sql = "delete from sub_class where sub_class.class_id='"+clasId+"'";
			int i=connection.executeUpdate(sql);//删除sub_class
			String sql1 = "delete from class_teacher where class_teacher.class_id='"+clasId+"'";
			int j=connection.executeUpdate(sql1);//删除sub_class
			String sql2 = "delete from attendance where attendance.class_id='"+clasId+"'";
			int k=connection.executeUpdate(sql2);//删除attendance
			String sql3 = "delete from attendance where attendance.student_id in(select student.id from student where student.class_id='"+clasId+"')";
			int l=connection.executeUpdate(sql3);//删除attendance
			String sql4 = "delete from student where student.class_id='"+clasId+"'";
			int m=connection.executeUpdate(sql4);//删除student
			String sql5 = "delete from clas where clas.id='"+clasId+"'";
			int n=connection.executeUpdate(sql5);//删除clas
			if(i!=0||j!=0||k!=0||l!=0||m!=0||n!=0)
			{
				++flag;
			}
			
			return flag;
		}
		//按专业名获获取对应的班级
		public List getClas(String Majorname) {

			List<ClasForm> list = new ArrayList();
			String sql = "select clas.classname from clas where clas.major_id in(select major.id from major where major.majorname='"+Majorname+"')";
			try {
				ResultSet rs = connection.executeQuery(sql);
		      while (rs.next()) {
		    	    clasForm = new ClasForm();
		    	    clasForm.setClasname(rs.getString(2));
					list.add(clasForm);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			// connection.close();
			return list;
		}
		//获取所有班级
		public List getClasForm()
		{
			List<GreadMajorClassForm> list = new ArrayList();
			String sql = "select clas.id,clas.classname,grade.gradename,major.majorname from clas,grade,major where clas.grade_id = grade.id and clas.major_id = major.id group by clas.classname";
			try {
				ResultSet rs = connection.executeQuery(sql);
		      while (rs.next()) {
		    	    greadMajorClassForm = new GreadMajorClassForm();
		    	    greadMajorClassForm.setClasId(Integer.valueOf(rs.getString(1)));
		    	    greadMajorClassForm.setClasname(rs.getString(2));
		    	    greadMajorClassForm.setGradename(Integer.valueOf(rs.getString(3)));
		    	    greadMajorClassForm.setMajorname(rs.getString(4));
		    	    list.add(greadMajorClassForm);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
}
