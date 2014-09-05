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
		<title>管理所有学生</title>

		<%
			AllStudentDao allStudentDao = new AllStudentDao();
			List<AllStudentForm> allStudentFormList = new ArrayList();
			allStudentFormList=(ArrayList)session.getAttribute("allStudentForm");
			
		%>
	</head>

	<body>
	<h4>管理所有学生修改，删除</h4>
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
										学号
									</td>
									<td>
										角色
									</td>
									<td>
									          所属班级
									</td>
									<td>
									         所属专业
									</td>
									<td>
									       所属年级
									</td>
								    <td>
								                     密码
								    </td>
									<td>
										操作
									</td>
									
								</tr>
								<%
									int z = 0;
									String color = "";
									for (int i = 0; i < allStudentFormList.size(); ++i) {
										AllStudentForm allStudentForm = new AllStudentForm();
										allStudentForm = allStudentFormList.get(i);
										z = i % 2;
										if (z != 0) {
											color = "#00E5EE";
										} else {
											color = "#FFFFFF";
										}
								%>
								<tr bgcolor="<%=color%>">
									<td><%=allStudentForm.getStudentname()%></td>
									<td><%=allStudentForm.getAccount()%></td>
									<td><%=allStudentForm.getRolename()%></td>
									<td><%=allStudentForm.getClassname()%></td>
									<td><%=allStudentForm.getMajorname()%></td>
									<td><%=allStudentForm.getGradename()%></td>
									<td><%=allStudentForm.getPassword()%></td>
									<td><a href="AdminServlet?method=6&sign=7&studentId=<%= allStudentForm.getId()%>&modify=1">修改</a>
									||<a href="AdminServlet?method=7&sign=9&studentId=<%= allStudentForm.getId()%>">删除</a></td>
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
