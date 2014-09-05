<%@page contentType="text/html;charset=UTF-8"  language="java" import="java.sql.*" errorPage=""%>
<%
   Integer sign=Integer.valueOf(request.getParameter("sign"));
   if(sign==0){//登陆进管理员主页面，跳转到Gread-Major-class.jsp
	   session.setAttribute("greadMajorClassForm",request.getAttribute("greadMajorClassForm"));
	   out.println("<script language=javascript>window.location.href='Gread-Major-class.jsp';</script>");
   }else if(sign==1)//添加新增年级-班级-班级信息，跳转到Gread-Major-class.jsp
   {
      if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Add Success!!');window.location.href='AdminServlet?method=0&sign=0';</script>");
	   }
   }else if(sign==2)//返回一个greadMajorClassForm对象到modifyGradeMajorClas.jsp
   {
       session.setAttribute("greadMajorClassForm",request.getAttribute("greadMajorClassForm"));
	   out.println("<script language=javascript>window.location.href='modifyGradeMajorClas.jsp';</script>");  
   }else if(sign==3)//修改完年级-班级-班级信息，跳转到Gread-Major-class.jsp
   {
      if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('modify Success!!');window.location.href='AdminServlet?method=0&sign=0';</script>");
	   }
   }else if(sign==4)//删除年级-班级-班级信息，跳转到Gread-Major-class.jsp
   {
      if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('delete Success!!');window.location.href='AdminServlet?method=0&sign=0';</script>");
	   }
   }else if(sign==5)//查询班级学生信息,跳转到Allstudents.jsp
   {
      session.setAttribute("allStudentForm",request.getAttribute("allStudentForm"));
	   out.println("<script language=javascript>window.location.href='Allstudents.jsp';</script>");
   }else if(sign==6)//添加学生信息，跳转到ManageAllStudents.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Add New Student Success!!');window.location.href='ManageAllStudents.jsp';</script>");
	   }
   }else if(sign==7)//返回一个allStudentForm对象到modifyStudent.jsp
   {
       session.setAttribute("allStudentForm",request.getAttribute("allStudentForm"));
	   out.println("<script language=javascript>window.location.href='modifyStudent.jsp';</script>"); 
   }else if(sign==8)//修改完学生信息,跳转到ManageAllStudents.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Modify Student Success!!');window.location.href='ManageAllStudents.jsp';</script>");
	   }
   }else if(sign==9)//删除学生信息,跳转到ManageAllStudents.jsp
   {
      if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Delete Student Success!!');window.location.href='ManageAllStudents.jsp';</script>");
	   }
   }else if(sign==10)//返回全部教师信息,跳转到Allteachers.jsp
   {
       session.setAttribute("teacherForm",request.getAttribute("teacherForm"));
	   out.println("<script language=javascript>window.location.href='Allteachers.jsp';</script>"); 
   }else if(sign==11)//新增教师，成功就跳转到Allteachers.jsp，否则停留在原页面
   {
       if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('add new teacher Success!!');window.location.href='AdminServlet?method=8&sign=10';</script>");
	   }
   }else if(sign==12)//返回一个teacherForm对象到modifyStudent.jsp
   {
       session.setAttribute("teacherForm",request.getAttribute("teacherForm"));
	   out.println("<script language=javascript>window.location.href='modifyTeacher.jsp';</script>"); 
   }else if(sign==13)//修改教师信息，成功返回到Allteachers.jsp
   {
      if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Modify Teacher Success!!');window.location.href='AdminServlet?method=8&sign=10';</script>");
	   }
   }else if(sign==14)//删除教师信息，成功返回到Allteachers.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Delete Teacher Success!!');window.location.href='AdminServlet?method=8&sign=10';</script>");
	   }
   }
%>
