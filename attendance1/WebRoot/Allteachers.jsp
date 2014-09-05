<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.*"
	import="com.gdpi.attendance.form.*"
	import="com.gdpi.attendance.form.SubjectForm" import="java.util.List"
	import="java.util.ArrayList" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理所有教师</title>

		<%
			List<TeacherForm> teacherFormList = new ArrayList();
			teacherFormList=(ArrayList)session.getAttribute("teacherForm");
			
		%>
	</head>

	<body>
	<h3>管理所有教师添加，修改，删除</h3>
	<p>
	     <a href="addNewTeacher.jsp">新增教师</a>
	</p>
		<table cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1"
			border="0">
			<tbody>
				<tr>
					<td>
						<table cellspacing="0" cellpadding="3" rules="rows"
							bordercolor="#ADCEEF" border="1" id="AttendanceQuery"
							width="100%">
							<tbody>
								<tr bgcolor="#C1D8F0">
									<td>
										姓名
									</td>
									<td>
										教师号
									</td>
									<td>
									         教师密码
									</td>
									<td>
										角色
									</td>
									<td>
										操作
									</td>
									
								</tr>
								<%
									int z = 0;
									String color = "";
									for (int i = 0; i < teacherFormList.size(); ++i) {
										TeacherForm teacherForm = new TeacherForm();
										teacherForm = teacherFormList.get(i);
										z = i % 2;
										if (z != 0) {
											color = "#00E5EE";
										} else {
											color = "#FFFFFF";
										}
								%>
								<tr bgcolor="<%=color%>">
									<td><%=teacherForm.getTeachername()%></td>
									<td><%=teacherForm.getAccount()%></td>
									<td><%=teacherForm.getPassword()%></td>
									<td><%=teacherForm.getRoledes()%>(<%=teacherForm.getRolename()%>)</td>
									<td><a href="AdminServlet?method=10&sign=12&modify=1&teacherAccount=<%=teacherForm.getAccount()%>">修改</a>
									||<a href="AdminServlet?method=11&sign=14&teacherId=<%=teacherForm.getId()%>">删除</a></td>
				                 <%
				                 }
				                 %>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>
