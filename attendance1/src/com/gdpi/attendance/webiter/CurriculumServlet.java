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

import com.gdpi.attendance.dao.AllStudentDao;
import com.gdpi.attendance.dao.CurriculumDao;
import com.gdpi.attendance.dao.GreadMajorClassDao;
import com.gdpi.attendance.dao.TeacherDao;
import com.gdpi.attendance.form.AllStudentForm;
import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.CurriculumForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.GreadMajorClassForm;
import com.gdpi.attendance.form.MajorForm;
import com.gdpi.attendance.form.StudentForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.Chinese;

public class CurriculumServlet extends HttpServlet {
	private int method;
	private GreadMajorClassDao greadMajorClassDao = null;
	private GreadMajorClassForm greadMajorClassForm  = null;
	private CurriculumDao curriculumDao = null;
    private CurriculumForm curriculumForm = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			this.SelectCurriculum(request, response);//查看课程表
		}
	}

	/**
	 * MineAttendan查血全部的年级-专业-班级
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void SelectCurriculum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		curriculumDao = new CurriculumDao();
		greadMajorClassForm =new GreadMajorClassForm();
		List<CurriculumForm> curriculumForm = new ArrayList();

		greadMajorClassForm.setClasname(request.getParameter("Clas"));
		greadMajorClassForm.setGradename(Integer.valueOf(request.getParameter("Grade")));
		greadMajorClassForm.setMajorname(request.getParameter("Major"));
		greadMajorClassForm = curriculumDao.GreadMajorClassForm(greadMajorClassForm);
		
		curriculumForm = curriculumDao.getCurriculumForm(greadMajorClassForm.getClasId());
		request.setAttribute("curriculumForm", curriculumForm);

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/admindealwith.jsp");
		requestDispatcher.forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);	}
}
