package com.gdpi.attendance.webiter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gdpi.attendance.dao.StudentDao;

import com.gdpi.attendance.dao.TeacherDao;
import com.gdpi.attendance.form.StudentForm;
import com.gdpi.attendance.form.TeacherForm;

//import com.gdpi.attendance.tool.Chinese;

public class LoginServlet extends HttpServlet {
	private TeacherDao teacherDao = null;
	private StudentDao studentDao = null;
	private int method;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			check(request, response);// 登录
		}
	}

	public void check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String account = request.getParameter("account");
		String userType = request.getParameter("userType");
		// out.print(userType);测试传过来的用户类型
		// 普通用户登录
		if (userType.equals("0")) {
			studentDao = new StudentDao();
			StudentForm studentForm = studentDao.getStudentForm(account);
			if (studentForm == null
					|| !studentForm.getAccount().equals(
							request.getParameter("account"))) {
				request.setAttribute("information",
						"The user not exist, Please Login Again!!");
			} else if (!studentForm.getPassword().equals(
					request.getParameter("password"))) {
				request.setAttribute("information",
						"Password error,Please Login Again");
			} else if (!studentForm.getRoleId().equals(
					Integer.valueOf(userType))) {
				request.setAttribute("information",
						"Role error,Please Login Again");
			} else {
				request.setAttribute("form", studentForm);
			}
		}
		// 任课老师登录
		if (userType.equals("2")) {
			teacherDao = new TeacherDao();
			TeacherForm teacherForm = teacherDao.getTeacherForm(account);

			if (teacherForm == null
					|| !teacherForm.getAccount().equals(
							request.getParameter("account"))) {
				request.setAttribute("information",
						"The user not exist, Please Login Again!!");
			} else if (!teacherForm.getPassword().equals(
					request.getParameter("password"))) {
				request.setAttribute("information",
						"Password error,Please Login Again");
			} 
			else if (!teacherForm.getRoleId().equals(
					Integer.valueOf(userType))) {
				request.setAttribute("information",
						"Role error,Please Login Again");
			}
			else {
				request.setAttribute("form", teacherForm);
			}
		}
		// 管理员登录
		if (userType.equals("4")) {
			teacherDao = new TeacherDao();
			TeacherForm teacherForm = teacherDao.getTeacherForm(account);
			if (teacherForm == null
					&& !teacherForm.getAccount().equals(account)) {
				request.setAttribute("information",
						"The user not exist, Please Login Again!!");

			} else if (!teacherForm.getPassword().equals(
					request.getParameter("password"))) {
				request.setAttribute("information",
						"Password error,Please Login Again");
			}else if (!teacherForm.getRoleId().equals(
					Integer.valueOf(userType)))
			{
				request.setAttribute("information",
				"Role error,Please Login Again");
			}else {
				request.setAttribute("form", teacherForm);
			}

		}
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/dealwith.jsp");
		requestDispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
