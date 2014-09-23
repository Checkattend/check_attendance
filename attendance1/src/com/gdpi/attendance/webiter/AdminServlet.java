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
import com.gdpi.attendance.dao.GreadMajorClassDao;
import com.gdpi.attendance.dao.SpecifyClassTeacherDao;
import com.gdpi.attendance.dao.SpecifyCounselorDao;
import com.gdpi.attendance.dao.TeacherDao;
import com.gdpi.attendance.form.AllStudentForm;
import com.gdpi.attendance.form.ClasForm;
import com.gdpi.attendance.form.Class_teacherForm;
import com.gdpi.attendance.form.GradeForm;
import com.gdpi.attendance.form.GreadMajorClassForm;
import com.gdpi.attendance.form.Instructor_gradeForm;
import com.gdpi.attendance.form.MajorForm;
import com.gdpi.attendance.form.StudentForm;
import com.gdpi.attendance.form.SubjectForm;
import com.gdpi.attendance.form.TeacherForm;
import com.gdpi.attendance.tool.Chinese;

public class AdminServlet extends HttpServlet {
	private int method;
	private GreadMajorClassDao greadMajorClassDao = null;
	private AllStudentDao allStudentDao = null;
	private TeacherForm teacherForm=null;
	private Instructor_gradeForm instructor_gradeForm = null;
	private Class_teacherForm class_teacherForm = null;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			this.SelectGreadMajorClass(request, response);//管理年级、专业、班级查询
		}else if(method == 1)
		{
			this.AddGreadMajorClass(request, response);//管理年级、专业、班级添加
		}else if(method==2)
		{
			ModifyGreadMajorClass(request, response);//管理年级、专业、班级修改
			
		}else if(method==3)
		{
			deleteGreadMajorClass(request, response);//管理年级、专业、班级删除
		}else if(method==4)
		{
			SelectAllStudent(request, response);//查询所有学生的信息
		}else if(method==5)
		{
			addNewStudent(request, response);//添加新生信息
		}else if(method==6)
		{
			modifyStudent(request, response);//修改学生信息
		}else if(method==7)
		{
			deleteStudent(request, response);//删除学生信息
		}else if(method==8)
		{
			selectAllTeachers(request, response);//查看所有
		}else if(method==9)
		{
			addNewTeachers(request, response);//新增一个教师
		}else if(method==10)
		{
			modifyTeacher(request, response);//修改一个教师
		}else if(method==11)
		{
			deleteTeacher(request, response);//删除一个教师
		}else if(method==12)
		{
			SpecifyCounselor(request, response);//指定的辅导员
		}else if(method==13)
		{
			modifySpecifyCounselor(request, response);//修改一个指定的辅导员
		}else if(method==14)
		{
			deleteSpecifyCounselor(request, response);//删除一个指定的辅导员
		}else if(method==15)
		{
			SpecifyClassTeacher(request, response);//指定的教师所教班级
		}else if(method==16)
		{
			modifySpecifyClassTeacher(request, response);//修改一个指定教师所教班级
		}else if(method==17)
		{
			deleteSpecifyClassTeacher(request, response);//删除一个指定的教师所教班级
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
			clasForm.setClasname(request.getParameter("Clas"));
			majorForm.setMajorname(request.getParameter("Major"));
		}
	    if(add.equals("2"))
		{
			majorForm.setMajorname(request.getParameter("Major"));
			majorForm.setDes(request.getParameter("MajorDes"));
		}
	    if(add.equals("4"))
		{
	    	gradeForm.setGradename(Integer.valueOf(request.getParameter("Grade")));
	    	gradeForm.setDes(request.getParameter("GradeDes"));
		}
		int i=greadMajorClassDao.addGreadMajorClassForm(gradeForm,majorForm,clasForm,add);
		if(i==0)
		{
			request.setAttribute("information",
			"addGreadMajorClassForm error");
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
			greadMajorClassForm.setGradeId(Integer.valueOf(Chinese.toChinese(request.getParameter("Grade"))));
			greadMajorClassForm.setMajorId(Integer.valueOf(request.getParameter("Major")));
			greadMajorClassForm.setGradeDes(request.getParameter("gradeDes"));
			greadMajorClassForm.setMajorDes(request.getParameter("majorDes"));

				int i=greadMajorClassDao.updateGreadMajorClassForm(greadMajorClassForm);
				if(i==0)
				{
					request.setAttribute("information",
					"modifyGreadMajorClassForm error");
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
				int i=greadMajorClassDao.deleteGreadMajorClassForm(request.getParameter("clasId"));
				if(i==0)
				{
					request.setAttribute("information",
					"deleteGreadMajorClassForm error");
				}
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	
	/**
	 * MineAttendan查询所有学生
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void SelectAllStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String Grade=request.getParameter("Grade");
		String Major=request.getParameter("Major");
		String Clas=request.getParameter("Clas");
		
		allStudentDao = new AllStudentDao();
		List<AllStudentForm> allStudentForm = new ArrayList(); // 查询本系全部学生表
		allStudentForm = allStudentDao.QueryAllStudent(Grade,Major,Clas);
		request.setAttribute("allStudentForm", allStudentForm);
		
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	
	/**
	 * MineAttendan添加新生
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addNewStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		AllStudentDao allStudentDao=new AllStudentDao();
		AllStudentForm allStudentForm=new AllStudentForm();
		
		allStudentForm.setGradename(request.getParameter("Grade"));
		allStudentForm.setMajorname(request.getParameter("Major"));
		allStudentForm.setClassname(request.getParameter("Clas"));
		allStudentForm.setRolename(request.getParameter("rolename"));
		allStudentForm.setStudentname(request.getParameter("studentname"));
		allStudentForm.setAccount(request.getParameter("studentaccount"));
		allStudentForm.setPassword(request.getParameter("studentpassword"));

		
		int i=allStudentDao.addStudent(allStudentForm);
		
		if(i==0)
		{
			request.setAttribute("information",
			"addstudent error");
		}
		
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	/**
	 * MineAttendan修改学生信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modifyStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
        String modify=request.getParameter("modify");
		AllStudentDao allStudentDao=new AllStudentDao();
		AllStudentForm allStudentForm=null;
		if(modify.equals("1"))
		{
			String studentId=request.getParameter("studentId");
		    allStudentForm=allStudentDao.getstudentForm(studentId);
			request.setAttribute("allStudentForm", allStudentForm);
		}
		if(modify.equals("2"))
		{
			allStudentForm=new AllStudentForm();
			allStudentForm.setGradename(request.getParameter("Grade"));
			allStudentForm.setMajorname(request.getParameter("Major"));
			allStudentForm.setClassname(request.getParameter("Clas"));
			allStudentForm.setRolename(request.getParameter("rolename"));
			allStudentForm.setStudentname(request.getParameter("studentname"));
			allStudentForm.setId(Integer.valueOf(request.getParameter("studentid")));
			allStudentForm.setAccount(request.getParameter("studentaccount"));
			allStudentForm.setPassword(request.getParameter("studentpassword"));
			int i=allStudentDao.updateStudentForm(allStudentForm);		
			if(i==0)
			{
				request.setAttribute("information",
				"updateStudentForm error");
			}			
			
		}
			
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	/**
	 * MineAttendan删除学生信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		AllStudentDao allStudentDao=new AllStudentDao();
		int i=allStudentDao.deleteStudent(request.getParameter("studentId"));
		if(i==0)
		{
			request.setAttribute("information",
			"deleteStudentForm error");
		}
		
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	/**
	 * MineAttendan查询所有教师
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectAllTeachers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		TeacherDao teacherDao=new TeacherDao();
		List<TeacherForm> teacherForm = new ArrayList();
		teacherForm=teacherDao.selectAllTeachers();
		request.setAttribute("teacherForm", teacherForm);
		
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
        
	}
	/**
	 * MineAttendan新增教师
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addNewTeachers(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			TeacherDao teacherDao=new TeacherDao();
			teacherForm=new TeacherForm();
			teacherForm.setRolename(request.getParameter("rolename"));
			teacherForm.setTeachername(request.getParameter("teachername"));
			teacherForm.setAccount(request.getParameter("teacheraccount"));
			teacherForm.setPassword(request.getParameter("teacherpassword"));
			int i=teacherDao.addNewTeacher(teacherForm);
			if(i==0)
			{
				request.setAttribute("information",
				"add new teacher error");
			}
			
			RequestDispatcher requestDispatcher = request
			             .getRequestDispatcher("/admindealwith.jsp");
			requestDispatcher.forward(request, response);

}
	/**
	 * MineAttendan修改教师
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modifyTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String modify=request.getParameter("modify");
		TeacherDao teacherDao=new TeacherDao();
		teacherForm=new TeacherForm();
		if(modify.equals("1"))
		{
			String teacherAccount=request.getParameter("teacherAccount");
			teacherForm=teacherDao.getTeacherForm(teacherAccount);
			request.setAttribute("teacherForm", teacherForm);
		}
		if(modify.equals("2"))
		{
			teacherForm.setId(Integer.valueOf(request.getParameter("teacherId")));
			teacherForm.setRolename(request.getParameter("rolename"));
			teacherForm.setTeachername(request.getParameter("teachername"));
			teacherForm.setAccount(request.getParameter("teacheraccount"));
			teacherForm.setPassword(request.getParameter("teacherpassword"));
			int i=teacherDao.modifyTeacher(teacherForm);
			if(i==0)
			{
				request.setAttribute("information",
				"modify teacher error");
			}
		}
	
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	/**
	 * MineAttendan删除教师信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		TeacherDao teacherDao=new TeacherDao();
		int i=teacherDao.deleteTeacherForm(request.getParameter("teacherId"));
		if(i==0)
		{
			request.setAttribute("information",
			"deleteStudentForm error");
		}
		
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	
	/**
	 * MineAtten指定辅导员
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void SpecifyCounselor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		SpecifyCounselorDao specifyCounselorDao=new SpecifyCounselorDao();
		int i = specifyCounselorDao.SpecifyCounselor(request.getParameter("Grade"), request.getParameter("Counselor"));
		if(i==0)
		{
			request.setAttribute("information",
			"This is existing");
		}
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	/**
	 * MineAttendan修改指定辅导员
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modifySpecifyCounselor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String modify=request.getParameter("modify");
		SpecifyCounselorDao specifyCounselorDao = new SpecifyCounselorDao();
		instructor_gradeForm = new Instructor_gradeForm();
		if(modify.equals("1"))
		{
			instructor_gradeForm = specifyCounselorDao.returnInstructor_gradeForm(request.getParameter("gradeId"), request.getParameter("teacherId"));
			request.setAttribute("instructor_gradeForm", instructor_gradeForm);
		}
		if(modify.equals("2"))
		{
			//System.out.println(request.getParameter("gradeid")+request.getParameter("teacherid"));
			instructor_gradeForm.setGradename(Integer.valueOf(request.getParameter("Grade")));
			instructor_gradeForm.setTeachername(request.getParameter("Counselor"));
			instructor_gradeForm.setGradeId(Integer.valueOf(request.getParameter("gradeid")));
			instructor_gradeForm.setId(Integer.valueOf(request.getParameter("teacherid")));
			int i=specifyCounselorDao.modifySpecifyCounselor(instructor_gradeForm);
			if(i==0)
			{
				request.setAttribute("information",
				"modify modifySpecifyCounselor error");
			}
		}
	
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	/**
	 * MineAtten删除指定辅导员
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteSpecifyCounselor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		SpecifyCounselorDao specifyCounselorDao=new SpecifyCounselorDao();
		int i = specifyCounselorDao.deleteSpecifyCounselor(request.getParameter("gradeId"), request.getParameter("teacherId"));
		if(i==0)
		{
			request.setAttribute("information",
			"delete SpecifyCounselor error");
		}
		
		
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	/**
	 * MineAtten指定教师所教班级
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void SpecifyClassTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		SpecifyClassTeacherDao specifyClassTeacherDao=new SpecifyClassTeacherDao();
		int i = specifyClassTeacherDao.specifyClassTeacherDao(request.getParameter("clas"), request.getParameter("teacher"));
		if(i==0)
		{
			request.setAttribute("information",
			"This is existing");
		}
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	/**
	 * MineAtten删除指定教师所教班级
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteSpecifyClassTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		SpecifyClassTeacherDao specifyClassTeacherDao=new SpecifyClassTeacherDao();
		int i = specifyClassTeacherDao.deleteSpecifyClassTeacher(request.getParameter("clasId"), request.getParameter("teacherId"));
		if(i==0)
		{
			request.setAttribute("information",
			"delete SpecifyCounselor error");
		}
		
		
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	/**
	 * MineAttendan修改教师所教班级
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modifySpecifyClassTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String modify=request.getParameter("modify");
		SpecifyClassTeacherDao specifyClassTeacherDao = new SpecifyClassTeacherDao();
		class_teacherForm = new Class_teacherForm();
		if(modify.equals("1"))
		{
			class_teacherForm = specifyClassTeacherDao.returnClass_teacherForm(request.getParameter("clasId"), request.getParameter("teacherId"));
			request.setAttribute("class_teacherForm", class_teacherForm);
		}
		if(modify.equals("2"))
		{
            System.out.println(request.getParameter("clasid")+request.getParameter("teacherid"));
            System.out.println(request.getParameter("clas")+request.getParameter("teacher"));
            String clasOld = request.getParameter("clasid");
            String teacherOld = request.getParameter("teacherid");
            String clasNow = request.getParameter("clas");
            String teacherNow =  request.getParameter("teacher");
			int i=specifyClassTeacherDao.modifySpecifyCounselor(clasOld,teacherOld,clasNow,teacherNow);
			if(i==0)
			{
				request.setAttribute("information",
				"modify SpecifyClassTeacher error");
			}
		}
	
		RequestDispatcher requestDispatcher = request
		             .getRequestDispatcher("/admindealwith.jsp");
        requestDispatcher.forward(request, response);
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);	}
}
