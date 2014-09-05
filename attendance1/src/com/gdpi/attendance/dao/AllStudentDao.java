package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.AllStudentForm;
import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.GreadMajorClassForm;
import com.gdpi.attendance.form.RoleForm;
import com.gdpi.attendance.form.StudentForm;
import com.gdpi.attendance.tool.JDBConnection;

public class AllStudentDao {
	private JDBConnection connection = null;
	private AllStudentForm allStudentForm=null;
	private ClasForm clasForm=null;
	private RoleForm roleForm=null;

	/**
	 * 初始化
	 */
	public AllStudentDao() {
		connection = new JDBConnection();
	}
	
	 /**
	 * 查询本系全部学生表
	 * 
	 * @param classid
	 * @return
	 */
	public List<AllStudentForm> QueryAllStudent(String grade,String major,String clas) {
		List<AllStudentForm> list = new ArrayList();
		String sql = "select student.id,student.studentname,student.account,role.rolename,student.password,clas.classname,major.majorname,grade.gradename,role.des from student,role,clas,major,grade where  grade.gradename='"+grade+"' and major.majorname='"+major+"' and  clas.classname='"+clas+"' and student.role_id=role.id and student.class_id=clas.id and clas.major_id=major.id and clas.grade_id=grade.id";
		ResultSet rs = connection.executeQuery(sql);
		
		try {
			while(rs.next()) {
				allStudentForm = new AllStudentForm();
				allStudentForm.setId(Integer.valueOf(rs.getString(1)));
				allStudentForm.setStudentname(rs.getString(2));
				allStudentForm.setAccount(rs.getString(3));
				allStudentForm.setRolename(rs.getString(4));
				allStudentForm.setPassword(rs.getString(5));
				allStudentForm.setClassname(rs.getString(6));
				allStudentForm.setMajorname(rs.getString(7));
				allStudentForm.setGradename(rs.getString(8));
				allStudentForm.setRoleDes(rs.getString(9));
				list.add(allStudentForm);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 添加新生
	 * 
	 * @param classid
	 * @return
	 */
	public int addStudent(AllStudentForm allStudentForm)
	{
		int i=0;
		if(allStudentForm.getStudentname().equals("")||allStudentForm.getAccount()==null)
		{
			return i;
		}
		int role_id=getroleForm(allStudentForm.getRolename()).getId();
		int class_id=getclasForm(allStudentForm).getId();
		String sql="insert into student (studentname,account,password,role_id,class_id) values('"+allStudentForm.getStudentname()+"','"+allStudentForm.getAccount()+"','"+allStudentForm.getPassword()+"','"+role_id+"','"+class_id+"')";
		i=connection.executeUpdate(sql);
		return i;
	}
	/**
	 * 按年级-专业-班级查询整个班级
	 * 
	 * @param classid
	 * @return
	 */
	public ClasForm getclasForm(AllStudentForm allStudentForm)
	{
	    clasForm=new ClasForm();
		String sql = "select * from clas,grade,major where  clas.grade_id=grade.id and clas.major_id=major.id and clas.classname='"+allStudentForm.getClassname()+"' and grade.gradename='"+allStudentForm.getGradename()+"' and major.majorname='"+allStudentForm.getMajorname()+"'";
		ResultSet rs = connection.executeQuery(sql);
		
		try {
			while(rs.next()) {
			    clasForm=new ClasForm();
				clasForm.setId(Integer.valueOf(rs.getString(1)));
				clasForm.setClasname(rs.getString(2));
				clasForm.setGradeId(Integer.valueOf(rs.getString(3)));
				clasForm.setMajorId(Integer.valueOf(rs.getString(4)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return clasForm;
	}
	/**
	 * 按角色名查询整个角色表
	 * 
	 * @param classid
	 * @return
	 */
    public  RoleForm getroleForm(String rolename)
    {
    	roleForm=new RoleForm();
    	String sql = "select * from role where role.rolename='"+rolename+"'";
		ResultSet rs = connection.executeQuery(sql);
		
		try {
			while(rs.next()) {
			    roleForm=new RoleForm();
				roleForm.setId(Integer.valueOf(rs.getString(1)));
				roleForm.setRolename(rs.getString(2));
				roleForm.setDes(rs.getString(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	return roleForm;
    }
    /**
	 * 按学生Id查询整个学生表
	 * 
	 * @param classid
	 * @return
	 */
    public  AllStudentForm getstudentForm(String studentId)
    {
    	allStudentForm=new AllStudentForm();
    	String sql = "select student.id,student.studentname,student.account,role.rolename,student.password,clas.classname,major.majorname,grade.gradename,role.des from student,role,clas,major,grade where  student.role_id=role.id and student.class_id=clas.id and clas.major_id=major.id and clas.grade_id=grade.id and student.id='"+studentId+"'";
		ResultSet rs = connection.executeQuery(sql);
		
		try {
			while(rs.next()) {
				allStudentForm = new AllStudentForm();
				allStudentForm.setId(Integer.valueOf(rs.getString(1)));
				allStudentForm.setStudentname(rs.getString(2));
				allStudentForm.setAccount(rs.getString(3));
				allStudentForm.setRolename(rs.getString(4));
				allStudentForm.setPassword(rs.getString(5));
				allStudentForm.setClassname(rs.getString(6));
				allStudentForm.setMajorname(rs.getString(7));
				allStudentForm.setGradename(rs.getString(8));
				allStudentForm.setRoleDes(rs.getString(9));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	return allStudentForm;
    }
    /**
	 * 修改学生信息
	 * 
	 * @param classid
	 * @return
	 */
	public int updateStudentForm(AllStudentForm allStudentForm) {
		int i=0;
		int role_id=getroleForm(allStudentForm.getRolename()).getId();
		int class_id=getclasForm(allStudentForm).getId();
		String sql = "update student set student.studentname='"+allStudentForm.getStudentname()+"',student.account='"+allStudentForm.getAccount()+"',student.password='"+allStudentForm.getPassword()+"',student.role_id='"+ role_id+"',student.class_id='"+class_id+"' where student.id='"+allStudentForm.getId()+"'";	
		i=connection.executeUpdate(sql);
		return i;
	}
	/**
	 * 删除学生信息
	 * 
	 * @param classid
	 * @return
	 */
	public int deleteGreadMajorClassForm(String studentId) {
		int i=0;
		String sql = "delete  from student where student.id='"+studentId+"'";
	    i=connection.executeUpdate(sql);//删除student表
		return i;
	}
}