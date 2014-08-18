package com.gdpi.attendance.webiter;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gdpi.attendance.dao.TeacherDao;
import com.gdpi.attendance.form.TeacherForm;
//import com.gdpi.attendance.tool.Chinese;

public class LoginServlet extends HttpServlet {
	 private TeacherDao teacherDao=null;
     private int method;
     
public void doGet (HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
      method = Integer.parseInt(request.getParameter("method"));
          if(method==0)
      {    	 
      	check(request,response);//登录	 	 	 
      }    
}


public void check(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {	
	request.setCharacterEncoding("utf-8");
	String account =request.getParameter("account");
    String userType=request.getParameter("userType");
    
    if(userType=="2")
    {
	teacherDao=new TeacherDao();
	TeacherForm teacherForm=teacherDao.getTeacherForm(account);
	if(teacherForm==null)
	  {
	 request.setAttribute("information", "用户不存在，请重新输入");  
		}
	else if(!teacherForm.getPassword().equals(request.getParameter("password")))
	{
		request.setAttribute("information", "输入的密码有误，请重新输入"); 		
	}
	else {
		request.setAttribute("form", teacherForm);	
	
		}
	RequestDispatcher requestDispatcher=request.getRequestDispatcher("/dealwith.jsp");	
	requestDispatcher.forward(request, response);	
    }		
}

public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
   doGet(request,response);
}
}
