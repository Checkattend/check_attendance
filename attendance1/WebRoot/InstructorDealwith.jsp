<%@page contentType="text/html;charset=UTF-8"  language="java" import="java.sql.*" errorPage=""%>
<%
   Integer sign=Integer.valueOf(request.getParameter("sign"));
   if(sign==0){
       session.setAttribute("form",request.getAttribute("form"));
	   session.setAttribute("instructor",request.getAttribute("instructor"));
	    out.println("<script language=javascript>window.location.href='instructor_viewOwner.jsp';</script>");
   }
   if(sign==1){
       session.setAttribute("form",request.getAttribute("form"));
	   session.setAttribute("grade",request.getAttribute("grade"));
	    session.setAttribute("clas",request.getAttribute("clas"));
	    session.setAttribute("subject",request.getAttribute("subject"));
	    out.println("<script language=javascript>window.location.href='instructor_select.jsp';</script>");
   }
   if(sign==2){
       session.setAttribute("form",request.getAttribute("form"));
	   session.setAttribute("SubAttComForm",request.getAttribute("SubAttComForm"));
       out.println("<script language=javascript>window.location.href='All_Attendance1.jsp';</script>");
   }
  
%>
