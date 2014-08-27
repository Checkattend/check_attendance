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
import com.gdpi.attendance.form.AllattendanceForm;
import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.GraMajClaTeacForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.StudentForm;
import com.gdpi.attendance.form.SubAttendanceComForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.Chinese;

public class TeacherServlet extends HttpServlet {
	private int method;

	private TeacherDao teacherDao = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		this.method = Integer.parseInt(request.getParameter("method"));
		
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
		if (method == 4) {
			this.back(request, response);// 退回考勤
		}
		if (method == 5) {
			this.Allattendance(request, response);// 按条件查询
		}
		if (method == 6) {
			this.selectAll(request, response);// 查询整个学期学生的考勤
		}
	}

	/**
	 * selectAll method
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("selectAll method");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
		.getAttribute("form");
     	String grade= request.getParameter("grade");
		String clas= request.getParameter("clas");
		String subject=request.getParameter("subject");
		teacherDao = new TeacherDao();
		GradeForm gradeform=new GradeForm();
		ClasForm classform=new ClasForm();
		SubjectForm subjectform=new SubjectForm();
		int gradeID=teacherDao.getgradeID(grade);
		int classID=teacherDao.getclassID(clas);
		int subjectID=teacherDao.getsubjectID(subject);
	    List<AllattendanceForm> list = new ArrayList();
		list=teacherDao.selectAtt(gradeID,classID,subjectID);
		request.setAttribute("list", list);
		request.setAttribute("form", teacherForm);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/TeacherDealwith.jsp");
		requestDispatcher.forward(request, response);
	}
	
	/**
	 *     Allattendance method
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void Allattendance(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("Allattendance method");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
				.getAttribute("form");
		String teachername = teacherForm.getTeachername();
		teacherDao = new TeacherDao();
		// 查询所有年级
		List<GradeForm> gradelist = new ArrayList();
		gradelist = teacherDao.getGrade();
		// 查询授课班级
		List<GraMajClaTeacForm> gmcTeacherlist = new ArrayList();
		gmcTeacherlist = teacherDao.getTeachClas(teachername);
		//查询所教课程
		List<SubjectForm> subjectlist=new ArrayList();
		subjectlist=teacherDao.getSubject(teachername);
		request.setAttribute("subjectlist", subjectlist);
		request.setAttribute("gradelist", gradelist);
		request.setAttribute("gmcTeacherlist", gmcTeacherlist);
		request.setAttribute("form", teacherForm);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/TeacherDealwith.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * back method
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void back(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("back method");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
				.getAttribute("form");
		int SubId = Integer.parseInt(request.getParameter("SubId"));
		String check = "退回";
		Chinese.toChinese(check);
		teacherDao = new TeacherDao();
		teacherDao.ToCommit(check, SubId);
		request.setAttribute("form", teacherForm);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/TeacherDealwith.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * commit method
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void commit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("commit method");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
				.getAttribute("form");
		int SubId = Integer.parseInt(request.getParameter("SubId"));
		String check = "已确认";
		Chinese.toChinese(check);
		teacherDao = new TeacherDao();
		teacherDao.ToCommit(check, SubId);
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
		request.setAttribute("subAttendance", subAttendance);
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
		System.out.println("findOwner");
		TeacherForm teacherForm = (TeacherForm) request.getSession()
				.getAttribute("form");
		String account = teacherForm.getAccount();
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
