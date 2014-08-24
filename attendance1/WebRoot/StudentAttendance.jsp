<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.StudentDao"
	import="com.gdpi.attendance.form.StudentCheckForm"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>考勤查询</title>
		<%
			Integer leaveTimes = 0;
			Integer truancyTimes = 0;
			Integer lateTimes = 0;
			Integer leaveETimes = 0;
			List<StudentCheckForm> studentChecklist = new ArrayList();
			studentChecklist = (List<StudentCheckForm>) session
					.getAttribute("studentChecklist");
		%>
	</head>

	<body>
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
										任课老师
									</td>
									<td>
										课程名称
									</td>
									<td>
										课时
									</td>
									<td>
										请假
									</td>
									<td>
										旷课
									</td>
									<td>
										迟到
									</td>
									<td>
										早退
									</td>
								</tr>
								<%
									int z = 0;
									String color = "";
									for (int i = 0; i < studentChecklist.size(); ++i) {
										StudentCheckForm studentCheckForm = new StudentCheckForm();
										studentCheckForm = studentChecklist.get(i);
										z = i % 2;
										if (z != 0) {
											color = "#eef3f9";
										} else {
											color = "#ffffff";
										}
								%>
								<tr bgcolor="<%=color%>">
									<td><%=studentCheckForm.getStudentName()%></td>
									<td><%=studentCheckForm.getTeacherName()%></td>
									<td><%=studentCheckForm.getSubjectName()%></td>
									<td>第<%=studentCheckForm.getClassHour()%>课时</td>
									<td><%=studentCheckForm.getLeave()%></td>
									<td><%=studentCheckForm.getTruancy()%></td>
									<td><%=studentCheckForm.getLate()%></td>
									<td><%=studentCheckForm.getLeaveEarly()%></td>
								</tr>
								<%
										leaveTimes += Integer.valueOf(studentCheckForm.getLeave());
										truancyTimes += Integer.valueOf(studentCheckForm.getTruancy());
										lateTimes += Integer.valueOf(studentCheckForm.getLate());
										leaveETimes += Integer.valueOf(studentCheckForm.getLeaveEarly());
									}
								%>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table id="statistics" cellspacing="1" cellpadding="0"
								width="100%" border="0" bgcolor="#ADCEEF">
							<tbody>
								<tr>
									<td>
										出勤统计：请假&nbsp;<%=leaveTimes %>&nbsp;&nbsp;旷课&nbsp;<%=truancyTimes %>&nbsp;&nbsp;迟到&nbsp;<%=lateTimes %>&nbsp;&nbsp;早退&nbsp;<%=leaveETimes %>
										<input type="button" value="返回" onclick="javascript:window.location.href='CommissionServlet?method=0&sign=0'" />
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>
