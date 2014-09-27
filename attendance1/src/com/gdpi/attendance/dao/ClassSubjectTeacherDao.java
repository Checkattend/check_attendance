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
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;


public class ClassSubjectTeacherDao  {
	  private  JDBConnection connection=null;
	   private TeacherForm teacherForm = null;
	   private Instructor_gradeForm instructor_gradeForm = null;
	   private Class_teacherForm class_teacherForm =null;
	   private SubjectForm subjectForm = null;
	   private Class_subject_teacherForm class_subject_teacherForm = null;
	   public ClassSubjectTeacherDao()
	   {
		   connection=new JDBConnection();
	   }
	   //查询所有的专业课本
	   public List getAllSubject()
	   {
		   List<SubjectForm> list = new ArrayList();
		   String sql = "select * from subject";
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
	   //按班级id获取班级-专业课-任课老师列表 
	   public List getAllClassSubjectTeacherForm(String classId)
	   {
		   List<Class_subject_teacherForm> list = new ArrayList();
		   String sql = "select clas.id,clas.classname,grade.gradename,major.majorname,subject.id,subject.subjectname,teacher.id,teacher.teachername,teacher.account from sub_class,clas,grade,major,subject,teacher_sub,teacher where  sub_class.class_id =clas.id and sub_class.subject_id = subject.id and clas.id ='"+classId+"' and teacher_sub.teacher_id =teacher.id and sub_class.subject_id = teacher_sub.subject_id and clas.grade_id=grade.id and clas.major_id = major.id";
			try {
				ResultSet rs = connection.executeQuery(sql);
		      while (rs.next()) {
		    	  class_subject_teacherForm = new Class_subject_teacherForm();
		    	  class_subject_teacherForm.setClasId(Integer.valueOf(rs.getString(1)));
		    	  class_subject_teacherForm.setClasname(rs.getString(2));
		    	  class_subject_teacherForm.setGradename(Integer.valueOf(rs.getString(3)));
		    	  class_subject_teacherForm.setMajorname(rs.getString(4));
		    	  class_subject_teacherForm.setSubjectid(Integer.valueOf(rs.getString(5)));
		    	  class_subject_teacherForm.setSubjectname(rs.getString(6));
		    	  class_subject_teacherForm.setTeacherid(Integer.valueOf(rs.getString(7)));
		    	  class_subject_teacherForm.setTeachername(rs.getString(8));
		    	  class_subject_teacherForm.setAccount(rs.getString(9));
				  list.add(class_subject_teacherForm);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		   return list;
	   }
		//指定班级对应专业课
		public int  addSpecifyClassSubject(String clasid,String subjectid)
		{
			int i=0;
			String sql2="insert into sub_class(sub_class.class_id,sub_class.subject_id) values('"+clasid+"','"+subjectid+"')";
			i=connection.executeUpdate(sql2);
			return i;
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
		 * 删除指定班级对应专业课及任课老师
		 * 
		 * @param classid
		 * @return
		 */
		public int deleteSpecifyClassSubject(String clasid,String subjectid) {
			int flag=0;
			String sql2 = "delete from sub_class where sub_class.class_id ='"+clasid+"' and sub_class.subject_id ='"+subjectid+"'";
			flag=connection.executeUpdate(sql2);//删除attendance

			return flag;
		}
		
		//修改指定班级对应专业课及任课老师
		public int  modifySpecifyClassSubject(String clasOld,String subjectOld,String clasNow,String subjectNow)
		{
			int i=0;
			String sql = "select *from sub_class where sub_class.class_id ='"+clasNow+"' and sub_class.subject_id='"+subjectNow+"'  group by sub_class.class_id";
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
			String sql2="update sub_class set sub_class.class_id = '"+clasNow+"',sub_class.subject_id='"+subjectNow+"' where sub_class.class_id = '"+clasOld+"' and sub_class.subject_id = '"+subjectOld+"'";
			i=connection.executeUpdate(sql2);
			return i;
		}
		//获取班级所学专业课及任课老师
		public Class_subject_teacherForm returnClass_subject_teacherForm(String clasid,String teacherid,String subjectid) {

			String sql = "select clas.id,clas.classname,grade.gradename,major.majorname,subject.id,subject.subjectname,teacher.id,teacher.teachername,teacher.account " +
					"from sub_class,clas,grade,major,subject,teacher_sub,teacher where  sub_class.class_id =clas.id and sub_class.subject_id = subject.id and clas.id ='"+clasid+"' " +
							"and subject.id='"+subjectid+"' and teacher.id='"+teacherid+"' and teacher_sub.teacher_id =teacher.id and sub_class.subject_id = teacher_sub.subject_id " +
									"and clas.grade_id=grade.id and clas.major_id = major.id";
			try {
				ResultSet rs = connection.executeQuery(sql);
		      while (rs.next()) {
		    	  class_subject_teacherForm = new Class_subject_teacherForm();
		    	  class_subject_teacherForm.setClasId(Integer.valueOf(rs.getString(1)));
		    	  class_subject_teacherForm.setClasname(rs.getString(2));
		    	  class_subject_teacherForm.setGradename(Integer.valueOf(rs.getString(3)));
		    	  class_subject_teacherForm.setMajorname(rs.getString(4));
		    	  class_subject_teacherForm.setSubjectid(Integer.valueOf(rs.getString(5)));
		    	  class_subject_teacherForm.setSubjectname(rs.getString(6));
		    	  class_subject_teacherForm.setTeacherid(Integer.valueOf(rs.getString(7)));
		    	  class_subject_teacherForm.setTeachername(rs.getString(8));
		    	  class_subject_teacherForm.setAccount(rs.getString(9));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return class_subject_teacherForm;
		}
		
		//查询所有的专业课本及任课老师
		   public List getAllSubjectSpecifyTeacher()
		   {
			   List<Class_subject_teacherForm> list = new ArrayList();
			   String sql = "select subject.id,subject.subjectname,teacher.id,teacher.teachername,teacher.account from teacher_sub,teacher,subject where teacher_sub.teacher_id = teacher.id and teacher_sub.subject_id = subject.id group by subject.subjectname";
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
		//返回一个本班没选的专业课及任课老师
		public List getNotSpecifyClassSubject(String clasid)
		{
			List<Class_subject_teacherForm> list = new ArrayList();
			String sql = "select clas.id,clas.classname,grade.gradename,major.majorname,subject.id,subject.subjectname,teacher.id,teacher.teachername,teacher.account from sub_class,clas,grade,major,subject,teacher_sub,teacher where  sub_class.class_id =clas.id and sub_class.subject_id = subject.id and clas.id !='"+clasid+"' and teacher_sub.teacher_id =teacher.id and sub_class.subject_id = teacher_sub.subject_id and clas.grade_id=grade.id and clas.major_id = major.id";
			try {
				ResultSet rs = connection.executeQuery(sql);
		      while (rs.next()) {
		    	  class_subject_teacherForm = new Class_subject_teacherForm();
		    	  class_subject_teacherForm.setClasId(Integer.valueOf(rs.getString(1)));
		    	  class_subject_teacherForm.setClasname(rs.getString(2));
		    	  class_subject_teacherForm.setGradename(Integer.valueOf(rs.getString(3)));
		    	  class_subject_teacherForm.setMajorname(rs.getString(4));
		    	  class_subject_teacherForm.setSubjectid(Integer.valueOf(rs.getString(5)));
		    	  class_subject_teacherForm.setSubjectname(rs.getString(6));
		    	  class_subject_teacherForm.setTeacherid(Integer.valueOf(rs.getString(7)));
		    	  class_subject_teacherForm.setTeachername(rs.getString(8));
		    	  class_subject_teacherForm.setAccount(rs.getString(9));
				  list.add(class_subject_teacherForm);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
}
