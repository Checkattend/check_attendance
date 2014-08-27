<%@ page language="java" import="java.util.*,com.gdpi.attendance.form.TeacherForm" pageEncoding="utf-8"%>
<html>
	<head>
		<title>显示辅导员信息</title>
	</head>
	<%
	
		com.gdpi.attendance.form.TeacherForm teacherForm = (com.gdpi.attendance.form.TeacherForm) session
				.getAttribute("form");
				
		TeacherForm instructor = (TeacherForm)session.getAttribute("instructor");		
	%>
	<body>
		
		<table cellspacing="0" cellpadding="3" rules="rows" bordercolor="#ADCEEF" border="1" id="DataGrid1" width="100%">
		<tbody>
		<tr bgcolor="C1D8F0" >
		<td>姓名</td>
		<td>账号</td>
		<td>密码</td>
		</tr>
		</tbody>
		<tr bgcolor="#00E5EE">
		<td><%=instructor.getTeachername()%></td>
		<td><%=instructor.getAccount()%></td>
		<td><%=instructor.getPassword()%></td>
		</tr>
		</table>
	</body>
</html>


