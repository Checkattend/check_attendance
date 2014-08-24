package com.gdpi.attendance.webiter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdpi.attendance.dao.CommissionerDao;
import com.gdpi.attendance.form.AttendanceForm;
import com.gdpi.attendance.form.StudentCheckForm;
import com.gdpi.attendance.form.StudentForm;
import com.gdpi.attendance.form.SubAttendanceComForm;
import com.gdpi.attendance.form.SubAttendanceComIdForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.Chinese;

public class CommissionServlet extends HttpServlet {
	private int method;
	private CommissionerDao commissionerDao = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			this.selectClassAttendance(request, response);
		} else if (method == 1) {
			this.UpdateAttendance(request, response);
		} else if (method == 2) {
			this.selectAttendance(request, response);
		} else if (method == 3) {
			this.AddAttendanceForm(request, response);
		} else if (method == 4) {
			this.AddAttendance(request, response);
		}
	}
	
	/**
	 * 修改考勤表信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void UpdateAttendance(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		StudentForm studentForm = (StudentForm) request.getSession()
				.getAttribute("form");
		SubAttendanceComIdForm SubACId = (SubAttendanceComIdForm) request.getSession()
		.getAttribute("SubACId");
		Integer leaveA = 0;
		Integer truancyA = 0;
		Integer lateA = 0;
		Integer leaveEarlyA = 0;
		commissionerDao = new CommissionerDao();
		List<AttendanceForm> attendancelist = new ArrayList();
		/* 个人考勤表 */
		for (int i = 0;; ++i) {
			Integer leave = 0;
			Integer truancy = 0;
			Integer late = 0;
			Integer leaveEarly = 0;
			AttendanceForm attendanceForm = new AttendanceForm();
			String attd = request.getParameter("R" + i);
			if (attd == null)
				break;
			if (attd.equals("leave")) {
				++leaveA;
				leave = 1;
			} else if (attd.equals("truancy")) {
				++truancyA;
				truancy = 1;
			} else if (attd.equals("late")) {
				++lateA;
				late = 1;
			} else if (attd.equals("leaveEarly")) {
				++leaveEarlyA;
				leaveEarly = 1;
			}
			attendanceForm.setId(Integer.valueOf(request.getParameter("id"+i)));
			attendanceForm.setLeave(leave);
			attendanceForm.setTruancy(truancy);
			attendanceForm.setLate(late);
			attendanceForm.setLeaveEarly(leaveEarly);
			attendancelist.add(attendanceForm);
		}
		SubACId.setLeave(leaveA);
		SubACId.setTruancy(truancyA);
		SubACId.setLate(lateA);
		SubACId.setLeaveEarly(leaveEarlyA);
		SubACId.setCheck("未确认");
		
		commissionerDao.UpdateAttendance(attendancelist);
		commissionerDao.UpdateSubAttendance(SubACId);
		request.setAttribute("form", studentForm);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/commissiondealwith.jsp");
		requestDispatcher.forward(request, response);
	}
	
	/**
	 * 查询考勤表详细信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void selectAttendance(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		StudentForm studentForm = (StudentForm) request.getSession()
				.getAttribute("form");
		Integer SubId = Integer.valueOf(request.getParameter("SubId"));
		commissionerDao = new CommissionerDao();
		SubAttendanceComIdForm SubACId = new SubAttendanceComIdForm();
		List<StudentCheckForm> attendancelist = new ArrayList();
		SubACId = commissionerDao.SelectSubAC(SubId);
		attendancelist = commissionerDao.QueryNumberOfLTLL(studentForm
				.getClasId(), SubACId.getSubjectId(), SubACId.getNumber());
		request.setAttribute("SubACId", SubACId);
		request.setAttribute("attendancelist", attendancelist);
		request.setAttribute("form", studentForm);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/commissiondealwith.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * 添加考勤信息表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void AddAttendance(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		StudentForm studentForm = (StudentForm) request.getSession()
				.getAttribute("form");
		Integer leaveA = 0;
		Integer truancyA = 0;
		Integer lateA = 0;
		Integer leaveEarlyA = 0;
		commissionerDao = new CommissionerDao();
		List<AttendanceForm> attendancelist = new ArrayList();
		SubAttendanceComIdForm subACId = new SubAttendanceComIdForm();
		/* 个人考勤表 */
		for (int i = 0;; ++i) {
			Integer leave = 0;
			Integer truancy = 0;
			Integer late = 0;
			Integer leaveEarly = 0;
			AttendanceForm attendanceForm = new AttendanceForm();
			String attd = request.getParameter("R" + i);
			if (attd == null)
				break;
			if (attd.equals("leave")) {
				++leaveA;
				leave = 1;
			} else if (attd.equals("truancy")) {
				++truancyA;
				truancy = 1;
			} else if (attd.equals("late")) {
				++lateA;
				late = 1;
			} else if (attd.equals("leaveEarly")) {
				++leaveEarlyA;
				leaveEarly = 1;
			}
			attendanceForm.setLeave(leave);
			attendanceForm.setTruancy(truancy);
			attendanceForm.setLate(late);
			attendanceForm.setLeaveEarly(leaveEarly);
			attendanceForm.setStudentId(Integer.valueOf(request
					.getParameter("id" + i)));
			attendanceForm.setClasId(studentForm.getClasId());
			attendanceForm.setSubjectId(Integer.valueOf(request
					.getParameter("subject")));
			attendanceForm.setTeacherId(Integer.valueOf(request
					.getParameter("teacher")));
			attendanceForm.setNumber(Integer.valueOf(request
					.getParameter("number")));
			attendancelist.add(attendanceForm);
		}
		/* 考勤表 */
		String formname = request.getParameter("formname");
		subACId.setFormname(formname);
		subACId.setClassId(studentForm.getClasId());
		subACId.setSubjectId(Integer.valueOf(request.getParameter("subject")));
		subACId.setTeacherId(Integer.valueOf(request.getParameter("teacher")));
		subACId.setLeave(leaveA);
		subACId.setTruancy(truancyA);
		subACId.setLate(lateA);
		subACId.setLeaveEarly(leaveEarlyA);
		subACId.setCheck("未确认");
		subACId.setNumber(Integer.valueOf(request.getParameter("number")));

		commissionerDao.InsertAttendance(attendancelist);
		commissionerDao.InsertSubAttendance(subACId);
		request.setAttribute("form", studentForm);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/commissiondealwith.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * 查询该班级的科目，任课老师和学生
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void AddAttendanceForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		StudentForm studentForm = (StudentForm) request.getSession()
				.getAttribute("form");
		Integer classId = studentForm.getClasId();
		commissionerDao = new CommissionerDao();
		List<SubjectForm> subjectlist = new ArrayList();
		List<TeacherForm> teacherlist = new ArrayList();
		List<StudentForm> studentlist = new ArrayList();
		subjectlist = commissionerDao.SelectSubject(classId);
		teacherlist = commissionerDao.SelectTeacher(classId);
		studentlist = commissionerDao.SelectStudent(classId);
		request.setAttribute("subjectlist", subjectlist);
		request.setAttribute("teacherlist", teacherlist);
		request.setAttribute("studentlist", studentlist);
		request.setAttribute("form", studentForm);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/commissiondealwith.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * 查看本班的考勤总目录
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void selectClassAttendance(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		StudentForm studentForm = (StudentForm) request.getSession()
				.getAttribute("form");
		Integer classId = studentForm.getClasId();
		commissionerDao = new CommissionerDao();
		List<SubAttendanceComForm> SubAClist = new ArrayList();
		SubAClist = commissionerDao.QueryNumberOfLTLL(classId);
		request.setAttribute("SubAClist", SubAClist);
		request.setAttribute("form", studentForm);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/commissiondealwith.jsp");
		requestDispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
