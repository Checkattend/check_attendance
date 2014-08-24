package com.gdpi.attendance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.attendance.form.AttendanceForm;
import com.gdpi.attendance.form.StudentCheckForm;
import com.gdpi.attendance.form.StudentForm;
import com.gdpi.attendance.form.SubAttendanceComForm;
import com.gdpi.attendance.form.SubAttendanceComIdForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.JDBConnection;


public class CommissionerDao {
	private JDBConnection connection = null;
	private SubAttendanceComForm subAC = null;
	private SubAttendanceComIdForm subACId = null;
	private StudentForm studentForm = null;
	private TeacherForm teacherForm = null;
	private SubjectForm subjectForm = null;
	private AttendanceForm attendanceForm = null;
	private StudentCheckForm studentCheckForm = null;
	
	/**
	 * 初始化
	 */
	public CommissionerDao() {
		connection = new JDBConnection();
	}
	
	/**
	 * 查看所有考勤表
	 * @param classId
	 * @return
	 */
	public List<SubAttendanceComForm> QueryNumberOfLTLL(Integer classId) {
		List<SubAttendanceComForm> list = new ArrayList();
		String sql = "select subattendance.formname,grade.gradename,clas.classname,subject.subjectname,teacher.teachername,subattendance.thedate,subattendance.`leave`,subattendance.truancy,subattendance.late,subattendance.leaveEarly,subattendance.`check`,subattendance.id from subattendance,grade,clas,subject,teacher where subattendance.class_id='"+classId+"' and clas.grade_id=grade.id and subattendance.class_id=clas.id and subattendance.subject_id=subject.id and subattendance.teacher_id=teacher.id order by subattendance.thedate";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				subAC = new SubAttendanceComForm();
				subAC.setFormname(rs.getString(1));
				subAC.setGradename(Integer.valueOf(rs.getString(2)));
				subAC.setClassname(rs.getString(3));
				subAC.setSubjectname(rs.getString(4));
				subAC.setTeachername(rs.getString(5));
				subAC.setThedate(rs.getString(6));
				subAC.setLeave(Integer.valueOf(rs.getString(7)));
				subAC.setTruancy(Integer.valueOf(rs.getString(8)));
				subAC.setLate(Integer.valueOf(rs.getString(9)));
				subAC.setLeaveEarly(Integer.valueOf(rs.getString(10)));
				subAC.setCheck(rs.getString(11));
				subAC.setId(Integer.valueOf(rs.getString(12)));
				list.add(subAC);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 查询学习委员所在班级的所有科目
	 * @param classId
	 * @return
	 */
	public List<SubjectForm> SelectSubject(Integer classId) {
		List<SubjectForm> list = new ArrayList();
		String sql = "select subject.id,subject.subjectname,subject.des from clas,subject,sub_class where clas.id='"+classId+"' and sub_class.subject_id=subject.id and sub_class.class_id=clas.id";
		ResultSet rs = connection.executeQuery(sql);
		try {
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
	 * 查询学习委员所在班级的所有任课老师
	 * @param classId
	 * @return
	 */
	public List<TeacherForm> SelectTeacher(Integer classId) {
		List<TeacherForm> list = new ArrayList();
		String sql = "select teacher.* from clas,teacher,class_teacher where clas.id='"+classId+"' and class_teacher.class_id=clas.id and class_teacher.teacher_id=teacher.id";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				teacherForm = new TeacherForm();
				teacherForm.setId(Integer.valueOf(rs.getString(1)));
				teacherForm.setTeachername(rs.getString(2));
				list.add(teacherForm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 查询学习委员所在班级的所有学生
	 * @param classId
	 * @return
	 */
	public List<StudentForm> SelectStudent(Integer classId) {
		List<StudentForm> list = new ArrayList();
		String sql = "select * from student where student.class_id='"+classId+"' order by student.account";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				studentForm = new StudentForm();
				studentForm.setId(Integer.valueOf(rs.getString(1)));
				studentForm.setStudentname(rs.getString(2));
				studentForm.setAccount(rs.getString(3));
				list.add(studentForm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 个人考勤登记
	 * @param list
	 */
	public void InsertAttendance(List<AttendanceForm> list) {
		for(int i = 0; i < list.size(); ++i) {
			attendanceForm = new AttendanceForm();
			attendanceForm = list.get(i);
			String sql = "insert into attendance(attendance.`leave`,truancy,late,leaveEarly,student_id,class_id,subject_id,teacher_id,number) values('"+attendanceForm.getLeave()+"','"+attendanceForm.getTruancy()+"','"+attendanceForm.getLate()+"','"+attendanceForm.getLeaveEarly()+"','"+attendanceForm.getStudentId()+"','"+attendanceForm.getClasId()+"','"+attendanceForm.getSubjectId()+"','"+attendanceForm.getTeacherId()+"','"+attendanceForm.getNumber()+"')";
			connection.executeUpdate(sql);
		}
	}
	
	/**
	 * 考勤表总信息登记
	 * @param subACId
	 */
	public void InsertSubAttendance(SubAttendanceComIdForm subACId) {
			String sql = "insert into subattendance(formname,class_id,subject_id,teacher_id,thedate,subattendance.`leave`,truancy,late,leaveEarly,subattendance.`check`,number) values('"+subACId.getFormname()+"','"+subACId.getClassId()+"','"+subACId.getSubjectId()+"','"+subACId.getTeacherId()+"',now(),'"+subACId.getLeave()+"','"+subACId.getTruancy()+"','"+subACId.getLate()+"','"+subACId.getLeaveEarly()+"','"+subACId.getCheck()+"','"+subACId.getNumber()+"')";
			connection.executeUpdate(sql);
	}
	
	/**
	 * 查询考勤表的课程id，和课时
	 * @param SubId
	 * @return
	 */
	public SubAttendanceComIdForm SelectSubAC(Integer SubId) {
		subACId = new SubAttendanceComIdForm();
		String sql = "select subject_id,number,subattendance.id from subattendance where subattendance.id='"+SubId+"'";
		ResultSet rs = connection.executeQuery(sql);
		try {
			if(rs.next()) {
				subACId.setSubjectId(Integer.valueOf(rs.getString(1)));
				subACId.setNumber(Integer.valueOf(rs.getString(2)));
				subACId.setId(Integer.valueOf(rs.getString(3)));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return subACId;
	}
	
	/**
	 * 查询单课程考勤情况
	 * @param classId
	 * @param subjectId
	 * @param number
	 * @return
	 */
	public List<StudentCheckForm> QueryNumberOfLTLL(Integer classId, Integer subjectId, Integer number) {
		List<StudentCheckForm> list = new ArrayList();
		String sql = "select attendance.id,student.account,student.studentname,teacher.teachername,subject.subjectname,attendance.number,attendance.`leave`,attendance.truancy,attendance.late,attendance.leaveEarly from attendance,student,teacher,subject where attendance.class_id='"+classId+"' and attendance.subject_id='"+subjectId+"' and attendance.number='"+number+"' and attendance.student_id=student.id and attendance.teacher_id=teacher.id and attendance.subject_id=subject.id";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while(rs.next()) {
				studentCheckForm = new StudentCheckForm();
				studentCheckForm.setId(Integer.valueOf(rs.getString(1)));
				studentCheckForm.setAccount(rs.getString(2));
				studentCheckForm.setStudentName(rs.getString(3));
				studentCheckForm.setTeacherName(rs.getString(4));
				studentCheckForm.setSubjectName(rs.getString(5));
				studentCheckForm.setClassHour(Integer.valueOf(rs.getString(6)));
				studentCheckForm.setLeave(Integer.valueOf(rs.getString(7)));
				studentCheckForm.setTruancy(Integer.valueOf(rs.getString(8)));
				studentCheckForm.setLate(Integer.valueOf(rs.getString(9)));
				studentCheckForm.setLeaveEarly(Integer.valueOf(rs.getString(10)));
				list.add(studentCheckForm);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 个人考勤修改
	 * @param list
	 */
	public void UpdateAttendance(List<AttendanceForm> list) {
		for(int i = 0; i < list.size(); ++i) {
			attendanceForm = new AttendanceForm();
			attendanceForm = list.get(i);
			String sql = "update attendance set attendance.`leave`='"+attendanceForm.getLeave()+"',truancy='"+attendanceForm.getTruancy()+"',late='"+attendanceForm.getLate()+"',leaveEarly='"+attendanceForm.getLeaveEarly()+"' where attendance.id='"+attendanceForm.getId()+"'";
			connection.executeUpdate(sql);
		}
	}
	
	/**
	 * 考勤表总信息修改
	 * @param subACId
	 */
	public void UpdateSubAttendance(SubAttendanceComIdForm subACId) {
			String sql = "update subattendance set subattendance.`leave`='"+subACId.getLeave()+"',truancy='"+subACId.getTruancy()+"',late='"+subACId.getLate()+"',leaveEarly='"+subACId.getLeaveEarly()+"',thedate=now(),subattendance.`check`='"+subACId.getCheck()+"' where subattendance.id='"+subACId.getId()+"'";
			connection.executeUpdate(sql);
	}
}
