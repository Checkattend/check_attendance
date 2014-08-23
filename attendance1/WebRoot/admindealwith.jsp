<%@page contentType="text/html;charset=UTF-8"  language="java" import="java.sql.*" errorPage=""%>
<%
   Integer sign=Integer.valueOf(request.getParameter("sign"));
   if(sign==0){
	   session.setAttribute("greadMajorClassForm",request.getAttribute("greadMajorClassForm"));
	   out.println("<script language=javascript>window.location.href='Gread-Major-class.jsp';</script>");
   }else if(sign==1)
   {
      if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Add Success!!');window.location.href='AdminServlet?method=0&sign=0';</script>");
	   }
   }
%>
