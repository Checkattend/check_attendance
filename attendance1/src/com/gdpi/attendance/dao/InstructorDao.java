package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;

public class InstructorDao {
	private JDBConnection connection = null;
	private TeacherForm teacherForm = null;
	public InstructorDao()
	{
		connection = new JDBConnection();
	}
	//获取辅导员个人信息
	public TeacherForm getInstructor(String account) {
		String sql = "select * from teacher where account='" + account + "'";
		try {
			ResultSet rs = connection.executeQuery(sql);

			if (rs.next()) {
				teacherForm = new TeacherForm();
				teacherForm.setId(Integer.valueOf(rs.getString(1)));
				teacherForm.setTeachername(rs.getString(2));
				teacherForm.setAccount(rs.getString(3));
				teacherForm.setPassword(rs.getString(4));
				teacherForm.setRoleId(Integer.valueOf(rs.getString(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// connection.close();
		return teacherForm;

	}
}
