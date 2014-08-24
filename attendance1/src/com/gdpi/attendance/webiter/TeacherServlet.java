package com.gdpi.attendance.webiter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gdpi.attendance.dao.TeacherDao;
import com.gdpi.attendance.form.GraMajClaTeacForm;
import com.gdpi.attendance.form.SubAttendanceComForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.Chinese;

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
		if (method == 2) {
			this.checkAttendance(request, response);// 查看班级考勤
		}
		if (method == 3) {
			this.commit(request, response);// 确认考勤
		}
	}

	/**
	 * commit method
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void commit(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException
			{
		request.setCharacterEncoding("utf-8");
		System.out.println("commit method");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
				.getAttribute("form");
		//String check=Chinese.toChinese;
		int SubId=Integer.parseInt(request.getParameter("SubId"));
		String check="已确认";
		Chinese.toChinese(check);
		//System.out.println(check);
		
		teacherDao = new TeacherDao();
		teacherDao.ToCommit(check,SubId);
		request.setAttribute("form", teacherForm);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/TeacherDealwith.jsp");
		requestDispatcher.forward(request, response);
			}
	/**
	 * checkAttendance method
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkAttendance(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("checkAttendance method");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
				.getAttribute("form");
		int teacher_id = teacherForm.getId();
		teacherDao = new TeacherDao();
		List<SubAttendanceComForm> subAttendance = new ArrayList();
		// 查看班级考勤
		subAttendance = teacherDao.getsSubAttendance(teacher_id);
		request.setAttribute("subAttendance",subAttendance);
		request.setAttribute("form", teacherForm);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/TeacherDealwith.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * findClass method
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
		String teachername = teacherForm.getTeachername();

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
	 * 查看个人信息 findOwner method
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findOwner(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// HttpSession session=request.getSession();
		System.out.println("findOwner");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
				.getAttribute("form");
		String account = teacherForm.getAccount();
		// session.setAttribute("account1", account);
		// String account1=(String)session.getAttribute("account1");
		System.out.println("findOwner method " + account);
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
