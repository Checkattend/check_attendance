<%@page contentType="text/html;charset=UTF-8" language="java"
	import="java.sql.*" errorPage=""%>
<%
	Integer sign = Integer.valueOf(request.getParameter("sign"));
	if (sign == 0) {
		session.setAttribute("form", request.getAttribute("form"));
		session.setAttribute("SubAClist", request.getAttribute("SubAClist"));
		out.println("<script language=javascript>window.location.href='ClassAttendance.jsp';</script>");
	}else if(sign == 1) {
		session.setAttribute("form", request.getAttribute("form"));
		session.setAttribute("SubACId", request.getAttribute("SubACId"));
		session.setAttribute("attendancelist", request.getAttribute("attendancelist"));
		out.println("<script language=javascript>window.location.href='UpdateAttendance.jsp';</script>");
	}else if(sign == 2) {
		session.setAttribute("form", request.getAttribute("form"));
		session.setAttribute("studentChecklist", request.getAttribute("attendancelist"));
		out.println("<script language=javascript>window.location.href='StudentAttendance.jsp';</script>");
	}else if (sign == 3) {
		session.setAttribute("form", request.getAttribute("form"));
		session.setAttribute("subjectlist", request.getAttribute("subjectlist"));
		session.setAttribute("teacherlist", request.getAttribute("teacherlist"));
		session.setAttribute("studentlist", request.getAttribute("studentlist"));
		out.println("<script language=javascript>window.location.href='AddAttendance.jsp';</script>");
	}else if (sign == 4) {
		session.setAttribute("form", request.getAttribute("form"));
		out.println("<script language=javascript>window.location.href='CommissionServlet?method=0&sign=0';</script>");
	}
%>
