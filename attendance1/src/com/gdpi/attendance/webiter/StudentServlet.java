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
import com.gdpi.attendance.form.SubjectForm;

public class StudentServlet extends HttpServlet {
	private int method;
	private StudentDao studentDao = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			this.Select(request, response);
		}
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
		studentDao = new StudentDao();
		List<StudentCheckForm> studentChecklist = new ArrayList(); // 学生本学期所有考勤情况
		List<SubjectForm> studentSubjectlist = new ArrayList(); // 学生的学科目录
		studentChecklist = studentDao.QueryNumberOfLTLL(studentForm.getId());
		request.setAttribute("studentChecklist", studentChecklist);
		studentSubjectlist = studentDao.QuerySubject(studentForm.getClasId());
		request.setAttribute("studentSubjectlist", studentSubjectlist);

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/studentdealwith.jsp");
		requestDispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
