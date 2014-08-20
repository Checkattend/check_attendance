<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
		<title>显示老师信息</title>
	</head>
	<%
	//判断服务器form是否存在
	if(session.getAttribute("form")==null){
	out.print("<script language=javascript>alert('您已经与服务器断开，请重新登录！');window.location.href='index.jsp';</script>");
	}
		//信息
		com.gdpi.attendance.form.TeacherForm teacherForm = (com.gdpi.attendance.form.TeacherForm) session
				.getAttribute("form");
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
		<tr bgcolor="#EEE3F9">
		<td><%=teacherForm.getTeachername()%></td>
		<td><%=teacherForm.getAccount()%></td>
		<td><%=teacherForm.getPassword()%></td>
		</tr>
		</table>
	</body>
</html>


