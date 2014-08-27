<%@page contentType="text/html;charset=UTF-8"  language="java" import="java.sql.*" errorPage=""%>
<%
   Integer sign=Integer.valueOf(request.getParameter("sign"));
   if(sign==0){
       session.setAttribute("form",request.getAttribute("form"));
	   session.setAttribute("instructor",request.getAttribute("instructor"));
	    out.println("<script language=javascript>window.location.href='instructor_viewOwner.jsp';</script>");
   }
  
%>
