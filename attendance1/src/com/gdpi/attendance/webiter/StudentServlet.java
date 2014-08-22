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

import com.gdpi.attendance.dao.StudentDao;
import com.gdpi.attendance.form.StudentCheckForm;
import com.gdpi.attendance.form.StudentForm;
import com.gdpi.attendance.form.StudentMsgForm;
import com.gdpi.attendance.form.SubjectForm;

public class StudentServlet extends HttpServlet {
	private int method;
	private StudentDao studentDao = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			this.Select(request, response);
		} else if (method == 1) {
			this.SelectBySubject(request, response);
		} else if (method == 2) {
			this.StudentMsg(request, response);
		}
	}
	
	/**
	 * 查询个人信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void StudentMsg(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		StudentForm studentForm = (StudentForm) request.getSession()
				.getAttribute("form");
		Integer studentId = studentForm.getId();
		studentDao = new StudentDao();
		StudentMsgForm studentMsgForm = new StudentMsgForm();
		studentMsgForm = studentDao.getStudentMsgForm(studentId);
		request.setAttribute("studentMsgForm", studentMsgForm);
		request.setAttribute("form", studentForm);

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/studentdealwith.jsp");
		requestDispatcher.forward(request, response);
	}
	
	/**
	 * 根据科目信息查询显示
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void SelectBySubject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		StudentForm studentForm = (StudentForm) request.getSession()
				.getAttribute("form");
		Integer studentId = studentForm.getId();
		Integer subjectId = Integer.valueOf(request.getParameter("subject"));
		studentDao = new StudentDao();
		List<StudentCheckForm> studentChecklist = new ArrayList(); // 学生本学期所有考勤情况
		List<SubjectForm> studentSubjectlist = new ArrayList(); // 学生的学科目录
		studentChecklist = studentDao.QueryNumberOfLTLL(studentId,
				subjectId);
		request.setAttribute("studentChecklist", studentChecklist);
		studentSubjectlist = studentDao.QuerySubject(studentForm.getClasId());
		request.setAttribute("studentSubjectlist", studentSubjectlist);
		request.setAttribute("form", studentForm);

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/studentdealwith.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * MineAttendance页面初始显示
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void Select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		StudentForm studentForm = (StudentForm) request.getSession()
				.getAttribute("form");
		Integer studentId = studentForm.getId();
		studentDao = new StudentDao();
		List<StudentCheckForm> studentChecklist = new ArrayList(); // 学生本学期所有考勤情况
		List<SubjectForm> studentSubjectlist = new ArrayList(); // 学生的学科目录
		studentChecklist = studentDao.QueryNumberOfLTLL(studentId);
		request.setAttribute("studentChecklist", studentChecklist);
		studentSubjectlist = studentDao.QuerySubject(studentForm.getClasId());
		request.setAttribute("studentSubjectlist", studentSubjectlist);
		request.setAttribute("form", studentForm);

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/studentdealwith.jsp");
		requestDispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
