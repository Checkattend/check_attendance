<%@page contentType="text/html;charset=UTF-8"  language="java" import="java.sql.*" errorPage=""%>
<%
   Integer sign=Integer.valueOf(request.getParameter("sign"));
   if(sign==0){
       session.setAttribute("form",request.getAttribute("form"));
	   session.setAttribute("gmcTeacherlist",request.getAttribute("gmcTeacherlist"));
	    out.println("<script language=javascript>window.location.href='Teacher_ViewClass.jsp';</script>");
   }
     if(sign==1){
       session.setAttribute("form",request.getAttribute("form"));
	   session.setAttribute("TFormgmc",request.getAttribute("TFormgmc"));
	    out.println("<script language=javascript>window.location.href='Teacher_view.jsp';</script>");
   }
   if(sign==2){
       session.setAttribute("form",request.getAttribute("form"));
	   session.setAttribute("subAttendance",request.getAttribute("subAttendance"));
	    out.println("<script language=javascript>window.location.href='Teacher_viewAttendance.jsp';</script>");
   }
   if(sign==3)
   {
   session.setAttribute("form",request.getAttribute("form"));
   out.println("<script language=javascript>window.location.href='TeacherServlet?method=2&sign=2';</script>");
   }
   if(sign==4)
   {
   session.setAttribute("form",request.getAttribute("form"));
   out.println("<script language=javascript>window.location.href='TeacherServlet?method=2&sign=2';</script>");
   }
    if(sign==5)
   {
   session.setAttribute("form",request.getAttribute("form"));
    session.setAttribute("gradelist",request.getAttribute("gradelist"));
    session.setAttribute("gmcTeacherlist",request.getAttribute("gmcTeacherlist"));
    session.setAttribute("subjectlist",request.getAttribute("subjectlist"));
   out.println("<script language=javascript>window.location.href='Teacher_viewAll.jsp';</script>");
   }
   if(sign==6)
   {
    session.setAttribute("list",request.getAttribute("list"));
   out.println("<script language=javascript>window.location.href='Teacher_viewAllattendance.jsp';</script>");
   }
%>
