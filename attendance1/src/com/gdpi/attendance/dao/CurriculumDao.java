package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.AllStudentForm;
import com.gdpi.attendance.form.AllattendanceForm;
import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.CurriculumForm;
import com.gdpi.attendance.form.GraMajClaTeacForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.GreadMajorClassForm;
import com.gdpi.attendance.form.SubAttendanceComForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;

public class CurriculumDao {
	private JDBConnection connection = null;
    private CurriculumForm curriculumForm = null;
    private SubjectForm subjectForm=null;
    private TeacherForm teacherForm = null;
	public CurriculumDao() {
		connection = new JDBConnection();
	}
    //获取整个课程表   
	public List getCurriculumForm(int clasId) {
		List<CurriculumForm> list = new ArrayList();
		String sql = "select * from curriculum,week,weekday,number,subject,teacher,building,class_teacher,teacher_sub where curriculum.subject_id in(select sub_class.subject_id from sub_class where sub_class.class_id='"+clasId+"') and curriculum.week_id=week.id and curriculum.weekday_id=weekday.id and curriculum.number_id=number.id and curriculum.subject_id=subject.id and curriculum.building_id=building.id and  class_teacher.teacher_id = teacher.id and  class_teacher.class_id = '"+clasId+"' and teacher_sub.teacher_id = teacher.id and subject.id = teacher_sub.subject_id";
		try {
			ResultSet rs = connection.executeQuery(sql);
	      while (rs.next()) {
	    	  curriculumForm = new CurriculumForm();
	    	  curriculumForm.setCurriculumid(Integer.valueOf(rs.getString(1)));
	    	  curriculumForm.setWeekid(Integer.valueOf(rs.getString(2)));
	    	  curriculumForm.setWeekdayid(Integer.valueOf(rs.getString(3)));
	    	  curriculumForm.setNumberid(Integer.valueOf(rs.getString(4)));
	    	  curriculumForm.setBuildingid(Integer.valueOf(rs.getString(5)));
	    	  
	    	  curriculumForm.setWeekname(rs.getString(8));
	    	  curriculumForm.setWeekdes(rs.getString(9));
	    	  
	    	  curriculumForm.setWeekdayname(rs.getString(11));
	    	  curriculumForm.setWeekdaydes(rs.getString(12));
	    	  
	    	  curriculumForm.setNumbername(Integer.valueOf(rs.getString(14)));
	    	  curriculumForm.setNumberdes(rs.getString(15));
	    	  
	    	  curriculumForm.setSubjeckname(rs.getString(17));
	    	  curriculumForm.setSubjeckdes(rs.getString(18));
	    	  
	    	  curriculumForm.setTeachername(rs.getString(20));
	    	  curriculumForm.setPlace(rs.getString(25));
			  list.add(curriculumForm);
			}
		} catch (SQLException e) {
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
		String sql = "select grade.gradename,major.majorname,clas.classname,grade.des,major.des,clas.id,grade.id,major.id  from clas,grade,major where clas.classname='"+greadMajorClassForm.getClasname()+"' and clas.grade_id in(select grade.id from grade where grade.gradename='"+greadMajorClassForm.getGradename()+"') and clas.major_id in(select major.id from major where major.majorname='"+greadMajorClassForm.getMajorname()+"') and clas.grade_id=grade.id and clas.major_id=major.id";
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
	
	//获取整个专业课表
	public List getSubjectForm() {
		List<SubjectForm> list = new ArrayList();
		String sql = "select *from subject";
		ResultSet rs = connection.executeQuery(sql);
		
		try {
			while(rs.next()) {
				subjectForm = new SubjectForm();
				subjectForm.setId(Integer.valueOf(rs.getString(1)));
				subjectForm.setSubjectname(rs.getString(2));
				subjectForm.setDes(rs.getString(3));
				list.add(subjectForm);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//获取整个专业课表
	public List getTeacherForm() {
		List<TeacherForm> list = new ArrayList();
		String sql = "select *from teacher where teacher.role_id=2";
		ResultSet rs = connection.executeQuery(sql);
		
		try {
			while(rs.next()) {
				teacherForm = new TeacherForm();
				teacherForm.setId(Integer.valueOf(rs.getString(1)));
				teacherForm.setTeachername(rs.getString(2));
				teacherForm.setAccount(rs.getString(3));
				teacherForm.setPassword(rs.getString(4));
				teacherForm.setRoleId(Integer.valueOf(rs.getString(5)));
				list.add(teacherForm);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
