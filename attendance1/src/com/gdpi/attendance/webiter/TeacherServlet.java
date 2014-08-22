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
import javax.servlet.http.HttpSession;

import com.gdpi.attendance.dao.TeacherDao;
import com.gdpi.attendance.form.GraMajClaTeacForm;
import com.gdpi.attendance.form.TeacherForm;

public class TeacherServlet extends HttpServlet {
	private int method;

	private TeacherDao teacherDao = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("32131");
		this.method = Integer.parseInt(request.getParameter("method"));
		System.out.println("32131");
		if (method == 0) {
			this.findClass(request, response);// 查找授课班级
		}
		if (method == 1) {
			this.findOwner(request, response);// 查看个人信息
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findClass(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// PrintWriter out = response.getWriter();
		System.out.println("findClass");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
				.getAttribute("form");
		System.out.println(teacherForm.getTeachername());
        String teachername=teacherForm.getTeachername();
		
		
		teacherDao = new TeacherDao();
		List<GraMajClaTeacForm> gmcTeacherlist = new ArrayList();
		// 查询授课班级
		gmcTeacherlist = teacherDao.getTeachClass(teachername);
		request.setAttribute("gmcTeacherlist", gmcTeacherlist);
		request.setAttribute("form", teacherForm);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/TeacherDealwith.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * 查看个人信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findOwner(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//HttpSession session=request.getSession();
		 System.out.println("findOwner");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
				.getAttribute("form");
		String account =teacherForm.getAccount();
		//session.setAttribute("account1", account);
		//String account1=(String)session.getAttribute("account1");
		System.out.println("findOwner method "+account);
		// 查询个人信息
			teacherDao = new TeacherDao();
		TeacherForm TFormgmc = teacherDao.getTeacherForm(account);
		request.setAttribute("TFormgmc", TFormgmc);
		request.setAttribute("form", teacherForm);
	    RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/TeacherDealwith.jsp");
		requestDispatcher.forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
