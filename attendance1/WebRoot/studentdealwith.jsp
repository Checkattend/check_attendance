<%@page contentType="text/html;charset=UTF-8"  language="java" import="java.sql.*" errorPage=""%>
<%
   Integer sign=Integer.valueOf(request.getParameter("sign"));
   if(sign == 0){
       session.setAttribute("form",request.getAttribute("form"));
	   session.setAttribute("studentChecklist",request.getAttribute("studentChecklist"));
	   session.setAttribute("studentSubjectlist",request.getAttribute("studentSubjectlist"));
	    out.println("<script language=javascript>window.location.href='MineAttendance.jsp';</script>");
   }else if(sign == 1) {
   	   session.setAttribute("form",request.getAttribute("form"));
   	   session.setAttribute("studentMsgForm",request.getAttribute("studentMsgForm"));
   	   out.println("<script language=javascript>window.location.href='StudentMsg.jsp';</script>");
   }
%>
