package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gdpi.attendance.form.GraMajClaTeacForm;
import com.gdpi.attendance.form.StudentCheckForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;


public class TeacherDao  {
	  private  JDBConnection connection=null;
	   private  TeacherForm 	teacherForm=null;
	  private GraMajClaTeacForm gmctForm=null;
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
	   //查询授课班级
	   public List getTeachClass (String teachername)
	   {
		
	  List<GraMajClaTeacForm> list = new ArrayList();
		   String sql="select grade.gradename ,major.majorname,clas.classname from teacher,clas,major,grade where teacher.teachername='"+teachername+"' and teacher.id=clas.id and clas.major_id=major.id and clas.grade_id=grade.id";  
		   try{
			   ResultSet rs=connection.executeQuery(sql);
			   
		   	      if(rs.next())
		   	{   
		   	    	gmctForm=new GraMajClaTeacForm();
		   	    	gmctForm.setGradename(rs.getString(1)); 
		   	    	gmctForm.setMajorname(rs.getString(2));
		   	    	gmctForm.setClassname(rs.getString(3));
		   	    	list.add(gmctForm);
		   	   	}
		
		   }catch(SQLException e){
		   	e.printStackTrace();
		   }
		  // connection.close();
		   return 	list;
		   
	   }
}
