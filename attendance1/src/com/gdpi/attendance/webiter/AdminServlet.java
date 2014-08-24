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

import com.gdpi.attendance.dao.GreadMajorClassDao;
import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.GreadMajorClassForm;
import com.gdpi.attendance.form.MajorForm;
import com.gdpi.attendance.form.StudentForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.tool.Chinese;

public class AdminServlet extends HttpServlet {
	private int method;
	private GreadMajorClassDao greadMajorClassDao = null;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			this.SelectGreadMajorClass(request, response);//查询
		}else if(method == 1)
		{
			this.AddGreadMajorClass(request, response);//添加
		}else if(method==2)
		{
			ModifyGreadMajorClass(request, response);//修改
			
		}else if(method==3)
		{
			deleteGreadMajorClass(request, response);//删除
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
	public void SelectGreadMajorClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
				greadMajorClassDao = new GreadMajorClassDao();
		List<GreadMajorClassForm> greadMajorClassForm = new ArrayList(); // 查询本系全部年级、专业、班级表		List<SubjectForm> studentSubjectlist = new ArrayList(); // 学生的学科目录
		greadMajorClassForm = greadMajorClassDao.QueryNumberOfLTLL();
		request.setAttribute("greadMajorClassForm", greadMajorClassForm);

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/admindealwith.jsp");
		requestDispatcher.forward(request, response);
	}
	/**
	 * MineAttendan添加年级-专业-班级
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void AddGreadMajorClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		greadMajorClassDao = new GreadMajorClassDao();
		GradeForm gradeForm=new GradeForm();
		MajorForm majorForm=new MajorForm();
		ClasForm clasForm=new ClasForm();
		
		String add=request.getParameter("add");
		if(add.equals("1")||add.equals("3"))
		{
			gradeForm.setGradename(Integer.valueOf(request.getParameter("Grade")));
			gradeForm.setDes(request.getParameter("GradeDes"));
			clasForm.setClasname(request.getParameter("Clas"));
		}	
		majorForm.setMajorname(request.getParameter("Major"));
		majorForm.setDes(request.getParameter("MajorDes"));
		int i=greadMajorClassDao.addGreadMajorClassForm(gradeForm,majorForm,clasForm,add);
		if(i==0)
		{
		  request.setAttribute(" information ","添加失败");
		}
		
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/admindealwith.jsp");
		requestDispatcher.forward(request, response);
	}
	/**
	 * MineAttendan修改年级-专业-班级
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void ModifyGreadMajorClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String modify=request.getParameter("modify");
		greadMajorClassDao = new GreadMajorClassDao();
		GreadMajorClassForm greadMajorClassForm =new GreadMajorClassForm();
		greadMajorClassForm.setClasId(Integer.valueOf(Chinese.toChinese(request.getParameter("clasId"))));
		greadMajorClassForm.setGradeId(Integer.valueOf(Chinese.toChinese(request.getParameter("gradeId"))));
		greadMajorClassForm.setMajorId(Integer.valueOf(Chinese.toChinese(request.getParameter("majorId"))));
		if(modify.equals("1"))
		{
			greadMajorClassForm = greadMajorClassDao.GreadMajorClassForm(greadMajorClassForm);
			request.setAttribute("greadMajorClassForm", greadMajorClassForm);
		}
		if(modify.equals("2"))
		{			
			greadMajorClassForm.setClasname(request.getParameter("Clas"));
			greadMajorClassForm.setGradename(Integer.valueOf(Chinese.toChinese(request.getParameter("Grade"))));
			greadMajorClassForm.setMajorname(request.getParameter("Major"));
			greadMajorClassForm.setGradeDes(request.getParameter("gradeDes"));
			greadMajorClassForm.setMajorDes(request.getParameter("majorDes"));

				int i=greadMajorClassDao.updateGreadMajorClassForm(greadMajorClassForm);
				if(i==0)
				{
					 request.setAttribute(" information ","修改失败");
				}
			
		}
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	/**
	 * MineAttendan删除年级-专业-班级
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteGreadMajorClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		System.out.println(request.getParameter("clasId"));
				int i=greadMajorClassDao.deleteGreadMajorClassForm(request.getParameter("clasId"));
				if(i==0)
				{
					 request.setAttribute(" information ","删除失败");
				}
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);	}
}
