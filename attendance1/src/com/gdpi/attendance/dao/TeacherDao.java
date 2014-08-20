package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;


public class TeacherDao  {
	  private  JDBConnection connection=null;
	   private  TeacherForm 	teacherForm=null;
	   private  GradeForm 	gradeForm=null;
	   private  ClasForm clasForm=null;
	   public TeacherDao()
	   {
		   connection=new JDBConnection();
	   }
	   public  TeacherForm getTeacherForm (String account)
	   {
		   String sql="select * from teacher where account='"+account+"'";  
		   try{
			   ResultSet rs=connection.executeQuery(sql);
			   
		   	      if(rs.next())
		   	{   
		   	    	  teacherForm=new TeacherForm();	
		   	    		teacherForm.setId(Integer.valueOf(rs.getString(1)));
		   	    		teacherForm.setTeachername(rs.getString(2));
		   	    	 	teacherForm.setAccount(rs.getString(3));
		   	    	 teacherForm.setPassword(rs.getString(4));
		   	    	 teacherForm.setRoleId(Integer.valueOf(rs.getString(5)));
		   	   	}
		
		   }catch(SQLException e){
		   	e.printStackTrace();
		   }
		  // connection.close();
		   return 	teacherForm;
		   
	   }
	   public List getTeachClass (String teachername)
	   {
		
	  List list = new ArrayList();
		   String sql="select classname,gradename from teacher,clas,grade where account='"+teachername+"' and teacher.id=class.id and grade.id=class.id";  
		   try{
			   ResultSet rs=connection.executeQuery(sql);
			   
		   	      if(rs.next())
		   	{   
		   	    	  teacherForm=new TeacherForm();	
		   	    		teacherForm.setId(Integer.valueOf(rs.getString(1)));
		   	    		teacherForm.setTeachername(rs.getString(2));
		   	    	 	teacherForm.setAccount(rs.getString(3));
		   	    	 teacherForm.setPassword(rs.getString(4));
		   	    	 teacherForm.setRoleId(Integer.valueOf(rs.getString(5)));
		   	    	list.add(teacherForm);
		   	   	}
		
		   }catch(SQLException e){
		   	e.printStackTrace();
		   }
		  // connection.close();
		   return 	list;
		   
	   }
}
