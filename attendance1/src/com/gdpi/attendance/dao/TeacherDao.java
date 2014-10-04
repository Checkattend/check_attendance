package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.AllStudentForm;
import com.gdpi.attendance.form.AllattendanceForm;
import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.GraMajClaTeacForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.SubAttendanceComForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;

public class TeacherDao {
	private JDBConnection connection = null;
	private TeacherForm teacherForm = null;
	private GraMajClaTeacForm gmctForm = null;
	private SubAttendanceComForm subAttendance = null;
	private GradeForm gradeForm=null;
    private SubjectForm subjectForm=null;
    private ClasForm classForm=null;
    private AllattendanceForm allattendanceForm=null;
    private AllStudentDao allStudentDao=null;
	public TeacherDao() {
		connection = new JDBConnection();
	}
     //获取个人信息
	public TeacherForm getTeacherForm(String account) {
		String sql = "select * from teacher ,role where teacher.role_id=role.id and account='" + account + "'";
		try {
			ResultSet rs = connection.executeQuery(sql);

			if (rs.next()) {
				teacherForm = new TeacherForm();
				teacherForm.setId(Integer.valueOf(rs.getString(1)));
				teacherForm.setTeachername(rs.getString(2));
				teacherForm.setAccount(rs.getString(3));
				teacherForm.setPassword(rs.getString(4));
				teacherForm.setRoleId(Integer.valueOf(rs.getString(5)));
				teacherForm.setRolename(rs.getString(7));
				teacherForm.setRoledes(rs.getString(8));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	      return teacherForm;
	}
    //获取年级
	public List getGrade() {

		List<GradeForm> list = new ArrayList();
		String sql = "select * from grade";
		try {
			ResultSet rs = connection.executeQuery(sql);
	      while (rs.next()) {
				gradeForm = new GradeForm();
				gradeForm.setId(Integer.valueOf(rs.getString(1)));
				gradeForm.setGradename(Integer.valueOf(rs.getString(2)));
				gradeForm.setDes(rs.getString(3));
				list.add(gradeForm);
				//System.out.println(gradeForm.getGradename()+"aa");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// connection.close();
		return list;
	}
     //获取所教课程
	public List getSubject(String teachername)
	{
		List<SubjectForm> list = new ArrayList();
		String sql="select `subject`.subjectname from `subject`,teacher,teacher_sub where teacher.teachername='"+teachername+"' and teacher_sub.subject_id=`subject`.id and teacher_sub.teacher_id=teacher.id ";
		try {
			ResultSet rs = connection.executeQuery(sql);
	      while (rs.next()) {
	    	  subjectForm = new SubjectForm();
	    	  subjectForm.setSubjectname(rs.getString(1));
				list.add(subjectForm);
				//System.out.println(gradeForm.getGradename()+"aa");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// connection.close();
		return list;
	}
	// 查询授课班级和课程
	public List getTeachClass(String teachername) {

		List<GraMajClaTeacForm> list = new ArrayList();
		String sql = "select grade.gradename ,major.majorname,clas.classname ,`subject`.subjectname from teacher,clas,major,grade,class_teacher,`subject` ,teacher_sub ,sub_class where teacher.teachername='"+teachername+"' and sub_class.class_id=clas.id and sub_class.subject_id=`subject`.id and teacher_sub.subject_id=`subject`.id and teacher_sub.teacher_id=teacher.id and teacher_sub.subject_id=`subject`.id and teacher.id= class_teacher.teacher_id and clas.id=class_teacher.class_id and clas.major_id=major.id and clas.grade_id=grade.id";
		try {
			ResultSet rs = connection.executeQuery(sql);

			while (rs.next()) {
				gmctForm = new GraMajClaTeacForm();
				gmctForm.setGradename(rs.getString(1));
				gmctForm.setMajorname(rs.getString(2));
				gmctForm.setClassname(rs.getString(3));
				gmctForm.setSubjectname(rs.getString(4));
				list.add(gmctForm);
				//System.out.println(gmctForm.getClassname());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// connection.close();
		return list;
	}
	//查询授课班级
	public List getTeachClas(String teachername) {

		List<GraMajClaTeacForm> list = new ArrayList();
		String sql = "select clas.classname from teacher,clas,major,grade,class_teacher,`subject` ,teacher_sub where teacher.teachername='"+teachername+"'  and teacher_sub.subject_id=`subject`.id and teacher_sub.teacher_id=teacher.id and teacher_sub.subject_id=`subject`.id and teacher.id= class_teacher.teacher_id and clas.id=class_teacher.class_id and clas.major_id=major.id and clas.grade_id=grade.id group by classname";
		try {
			ResultSet rs = connection.executeQuery(sql);

			while (rs.next()) {
				gmctForm = new GraMajClaTeacForm();
			    gmctForm.setClassname(rs.getString(1));
			    list.add(gmctForm);
				//System.out.println(gmctForm.getClassname());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// connection.close();
		return list;
	}
    // 查看班级考勤
	public List getsSubAttendance(int teacher_id) {
		List<SubAttendanceComForm> list = new ArrayList();
		String sql = "select grade.gradename,subattendance.formname,clas.classname," +
				"`subject`.subjectname,teacher.teachername,thedate,`leave`,truancy,late,leaveEarly," +
				"`check`,subattendance.id from subattendance,clas,`subject`,teacher,grade" +
				" where subattendance.teacher_id='"+teacher_id+"'and grade.id=clas.grade_id " +
						"and subattendance.class_id=clas.id and `subject`.id=subattendance.subject_id" +
						" and teacher.id=subattendance.teacher_id";
		try {
			ResultSet rs = connection.executeQuery(sql);

			while (rs.next()) {
				subAttendance = new SubAttendanceComForm();
				subAttendance.setGradename(Integer.valueOf(rs.getString(1)));
				subAttendance.setFormname(rs.getString(2));
				subAttendance.setClassname(rs.getString(3));
				subAttendance.setSubjectname(rs.getString(4));
				subAttendance.setTeachername(rs.getString(5));
				subAttendance.setThedate(rs.getString(6));
				subAttendance.setLeave(Integer.valueOf(rs.getString(7)));
				subAttendance.setTruancy(Integer.valueOf(rs.getString(8)));
				subAttendance.setLate(Integer.valueOf(rs.getString(9)));
				subAttendance.setLeaveEarly(Integer.valueOf(rs.getString(10)));
				subAttendance.setCheck(rs.getString(11));
				subAttendance.setId(Integer.valueOf(rs.getString(12)));
				list.add(subAttendance);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// connection.close();
		return list;
		}
	public void ToCommit(String check,int SubId)
	{
		String sql="update subattendance set `check`='"+check+"' where id='"+SubId+"' ";
	                  connection.executeUpdate(sql);
         }
	//获得gradeID
	public int getgradeID(String grade)
	{
	
		String sql="select id from grade where gradename='"+grade+"'";
		try {
			ResultSet rs = connection.executeQuery(sql);
	      if(rs.next()) {
				gradeForm = new GradeForm();
				gradeForm.setId(Integer.valueOf(rs.getString(1)));
			}
	   
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return   gradeForm.getId();
	}
//获得classID
	public int getclassID(String clas)
	{
		String sql="select id from clas where classname='"+clas+"'";
		try {
			ResultSet rs = connection.executeQuery(sql);
	      if (rs.next()) {
				classForm = new ClasForm();
				classForm.setId(Integer.valueOf(rs.getString(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classForm.getId();
	}
	
//获得subjectID
	public int  getsubjectID(String subject)
	{
		String sql="select id from subject where subjectname='"+subject+"'";
		try {
			ResultSet rs = connection.executeQuery(sql);
	      if (rs.next()) {
				subjectForm = new SubjectForm();
				subjectForm.setId(Integer.valueOf(rs.getString(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subjectForm.getId();
	}
	
	//查询学生总考勤
   public List selectAtt(int gradeID,int classID,int subjectID)
   {
	  List<AllattendanceForm> list = new ArrayList(); 
	  String sql="select attendance.id,student.account,student.studentname,teacher.teachername,subject.subjectname ,sum(attendance.`leave`),sum(attendance.truancy),sum(attendance.late),sum(attendance.leaveEarly) from attendance,student,teacher,subject,clas where attendance.class_id='"+classID+"'  and attendance.subject_id='"+subjectID+"' and clas.grade_id='"+gradeID+"' and clas.id=attendance.class_id and attendance.student_id=student.id and attendance.teacher_id=teacher.id and attendance.subject_id=subject.id  group by account";
	  try {
			ResultSet rs = connection.executeQuery(sql);
			while(rs.next())
			{
				allattendanceForm=new AllattendanceForm();
				allattendanceForm.setId(Integer.valueOf(rs.getString(1)));
				allattendanceForm.setAccount(rs.getString(2));
				allattendanceForm.setStudentname(rs.getString(3));
				allattendanceForm.setTeachername(rs.getString(4));
				allattendanceForm.setSubjectname(rs.getString(5));
				allattendanceForm.setLeave(Integer.valueOf(rs.getString(6)));
				allattendanceForm.setTruancy(Integer.valueOf(rs.getString(7)));
				allattendanceForm.setLate(Integer.valueOf(rs.getString(8)));
				allattendanceForm.setLeaveEarly(Integer.valueOf(rs.getString(9)));
			    list.add(allattendanceForm);
			
			}
	  }catch (SQLException e) {
			e.printStackTrace();
		}
	  return list;
   }
 //查询所有教师
   public List selectAllTeachers()
   {
	  List<TeacherForm> list = new ArrayList(); 
	  String sql="select teacher.id,teacher.teachername,teacher.account,teacher.password,teacher.role_id,role.rolename,role.des from teacher,role where teacher.role_id=role.id";
	  try {
			ResultSet rs = connection.executeQuery(sql);
			while(rs.next())
			{
				teacherForm=new TeacherForm();
				teacherForm.setId(Integer.valueOf(rs.getString(1)));
				teacherForm.setTeachername(rs.getString(2));
				teacherForm.setAccount(rs.getString(3));
				teacherForm.setPassword(rs.getString(4));
				teacherForm.setRoleId(Integer.valueOf(rs.getString(5)));
				teacherForm.setRolename(rs.getString(6));
				teacherForm.setRoledes(rs.getString(7));
			    list.add(teacherForm);
			
			}
	  }catch (SQLException e) {
			e.printStackTrace();
		}
	  return list;
   }
   /**
	 * 添加新教师
	 * 
	 * @param classid
	 * @return
	 */
	public int addNewTeacher(TeacherForm teacherForm)
	{
		int i=0;
		if(teacherForm.getTeachername()==null||teacherForm.getAccount()==null)
		{
			return i;
		}
		allStudentDao=new AllStudentDao();
		int role_id=allStudentDao.getroleForm(teacherForm.getRolename()).getId();
		String sql="insert into teacher(teachername,account,password,role_id) values('"+teacherForm.getTeachername()+"','"+teacherForm.getAccount()+"','"+teacherForm.getPassword()+"','"+role_id+"')";
		i=connection.executeUpdate(sql);
		return i;
	}
	 /**
	 * 修改教师信息
	 * 
	 * @param classid
	 * @return
	 */
	public int modifyTeacher(TeacherForm teacherForm)
	{
		int i=0;
		allStudentDao=new AllStudentDao();
		int role_id=allStudentDao.getroleForm(teacherForm.getRolename()).getId();
		String sql="update teacher set teacher.teachername='"+teacherForm.getTeachername()+"',teacher.account='"+teacherForm.getAccount()+"',teacher.password='"+teacherForm.getPassword()+"',teacher.role_id='"+role_id+"' where teacher.id='"+teacherForm.getId()+"'";
		i=connection.executeUpdate(sql);
		return i;
	}
	/**
	 * 删除教师信息
	 * 
	 * @param classid
	 * @return
	 */
	public int deleteTeacherForm(String teacherId) {
		int flag=0;
		String sql = "delete from attendance where attendance.teacher_id='"+teacherId+"'";
		int i=connection.executeUpdate(sql);//删除attendance
		String sql1 = "delete from class_teacher where class_teacher.teacher_id='"+teacherId+"'";
		int j=connection.executeUpdate(sql1);//删除class_teacher
		String sql2 = "delete from teacher_sub where teacher_sub.teacher_id='"+teacherId+"'";
		int k=connection.executeUpdate(sql2);//删除teacher_sub
		String sql3 = "delete from teacher where teacher.id='"+teacherId+"'";
		int l=connection.executeUpdate(sql3);//删除teacher

		if(i!=0||j!=0||k!=0||l!=0)
		{
			++flag;
		}	
		return flag;
	}
}
