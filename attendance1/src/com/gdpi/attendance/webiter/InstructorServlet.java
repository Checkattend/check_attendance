package com.gdpi.attendance.webiter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gdpi.attendance.dao.InstructorDao;
import com.gdpi.attendance.form.TeacherForm;

public class InstructorServlet extends HttpServlet {
	private int method;
	private InstructorDao instructorDao=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			this.findOwner(request, response);// 查看个人信息
		}
	}
	
	public void findOwner(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("findOwner");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
				.getAttribute("form");
		String account = teacherForm.getAccount();
		System.out.println("findOwner method " + account);
		// 查询个人信息
		instructorDao = new InstructorDao();
		TeacherForm  instructor=instructorDao.getInstructor(account);
		request.setAttribute("instructor", instructor);
		request.setAttribute("form", teacherForm);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/InstructorDealwith.jsp");
		requestDispatcher.forward(request, response);

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
    this.doGet(request, response);
}
}
