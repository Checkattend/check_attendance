<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.form.AllattendanceForm"
      import="java.util.List"
	import="java.util.ArrayList" pageEncoding="utf-8"%>
<html>
	<head>
		<title>整个学期学生考勤</title>
		<%
			Integer leaveTimes = 0;
			Integer truancyTimes = 0;
			Integer lateTimes = 0;
			Integer leaveETimes = 0;
			List<AllattendanceForm> list = new ArrayList();
			list = (List<AllattendanceForm>) session
					.getAttribute("list");
		
		%>
	</head>

	<body>
		<table cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1"
			border="0">
			<tbody>
				<tr>
					<td>
					<center>
					学生出勤统计
					</center>
					</td>
				</tr>
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
										任课老师
									</td>
									<td>
										课程名称
									</td>
									
									<td>
										总请假
									</td>
									<td>
										总旷课
									</td>
									<td>
										总迟到
									</td>
									<td>
										总早退
									</td>
								</tr>
								<%
									int z = 0;
									String color = "";
									for (int i = 0; i <list.size(); ++i) {
										AllattendanceForm allattendanceForm = new AllattendanceForm();
										allattendanceForm = list.get(i);
										z = i % 2;
										if (z != 0) {
											color = "#eef3f9";
										} else {
											color = "#ffffff";
										}
																	
								%>
								<tr bgcolor="<%=color%>">
									<td><%=allattendanceForm.getStudentname()%></td>
									<td><%=allattendanceForm.getTeachername()%></td>
									<td><%=allattendanceForm.getSubjectname()%></td>
									<td><%=allattendanceForm.getLeave()%></td>
									<td><%=allattendanceForm.getTruancy()%></td>
									<td><%=allattendanceForm.getLate()%></td>
									<td><%=allattendanceForm.getLeaveEarly()%></td>
									<%	
									}
								   %>
									
								</tr>
								<tr>            
						</table>
					</td>
				</tr>	
			</tbody>
				</table>
				<center>
				<form name="Form1" id="Form1" method="post"
							action="TeacherServlet?method=5&sign=5">
				<input type="submit" name="QueryB" id="QueryB"
												value="返回继续查询">
				
				</form>
				</center>
	</body>
</html>
