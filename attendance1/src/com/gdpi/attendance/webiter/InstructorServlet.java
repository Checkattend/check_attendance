package com.gdpi.attendance.webiter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gdpi.attendance.dao.InstructorDao;
import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.SubAttendanceComForm;
import com.gdpi.attendance.form.SubjectForm;
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
		if (method == 1) {
			this.getSelect(request, response);// 得到查询条件
		}
		if (method == 2) {
			this.SelectWithSub(request, response);// 按单科查询
		}
		if (method == 3) {
			this.SelectByTime(request, response);// 按时间查询
		}
	}
	
	/**
	 * SelectByTime method
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void SelectByTime(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("SelectByTime method");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
				.getAttribute("form");
		String grade=request.getParameter("grade");
		String clas=request.getParameter("clas");
		String time1=request.getParameter("time1");
		String time2=request.getParameter("time2");
		 instructorDao = new InstructorDao();
		 //按时间查询考勤
		 List<SubAttendanceComForm> SubAttComForm=new ArrayList();
		 SubAttComForm=instructorDao.ToViewSubAttendance(grade,clas,time1,time2); 
		 request.setAttribute("SubAttComForm",  SubAttComForm);
			request.setAttribute("form", teacherForm);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/InstructorDealwith.jsp");
			requestDispatcher.forward(request, response);
	}
	
	/**
	 * SelectWithSub method
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void SelectWithSub(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("SelectWithSub method");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
				.getAttribute("form");
		String grade=request.getParameter("grade");
		String clas=request.getParameter("clas");
		String subject=request.getParameter("subject");
		 instructorDao = new InstructorDao();
		 //单科查询
		 List<SubAttendanceComForm> SubAttComForm=new ArrayList();
		 SubAttComForm=instructorDao.ToView_SubAttendance(grade,clas,subject);
		 request.setAttribute("SubAttComForm",  SubAttComForm);
			request.setAttribute("form", teacherForm);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/InstructorDealwith.jsp");
			requestDispatcher.forward(request, response);
	}
	/**
	 * findOwner method
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findOwner(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("findOwner method");
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
	/**
	 * getSelect  method
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getSelect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("getSelect method");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
				.getAttribute("form");
	   int instructorId=teacherForm.getId();
	   instructorDao = new InstructorDao();
	 //得到辅导员所带的年级
	   List<GradeForm>grade = new ArrayList();
	      grade=instructorDao.getGrade(instructorId);
	   //获得辅导员所带的班级
	   List<ClasForm> clas = new ArrayList();
	    clas=instructorDao.getClas(instructorId);
	    //获得所有开设的科目
	    List<SubjectForm> subject=new ArrayList();
	    subject=instructorDao.getSubject();
	    //获得辅导员所带的年级的课程表中的时间
	    List<SubAttendanceComForm> AttTime=new ArrayList();
	    AttTime=instructorDao.getAttendanceTime(instructorId);
	    request.setAttribute("AttTime", AttTime);
	   request.setAttribute("grade", grade);
	   request.setAttribute("clas", clas);
	   request.setAttribute("subject", subject);
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
