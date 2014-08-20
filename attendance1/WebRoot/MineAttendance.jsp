<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.StudentDao"
	import="com.gdpi.attendance.form.StudentCheckForm"
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
		<title>考勤查询</title>
		<%
			StudentDao studentDao = new StudentDao();
			List<StudentCheckForm> studentChecklist = new ArrayList();
			List<SubjectForm> studentSubjectlist = new ArrayList();
			studentChecklist = (List<StudentCheckForm>) session
					.getAttribute("studentChecklist");
			studentSubjectlist = (List<SubjectForm>) session
					.getAttribute("studentSubjectlist");
		%>
	</head>

	<body>
		<table cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1"
			border="0">
			<tbody>
				<tr>
					<td>
						<form name="subjectF" id="subject" method="post"
							action="StudentServlet?method=1&sign=0">
							<table id="sbycategory" cellspacing="1" cellpadding="0"
								width="100%" border="0">
								<tbody>
									<tr>
										<td>
											查询条件
										</td>
									</tr>
									<tr>
										<td>
											课程名称:
											<select name="subject" id="subject">
												<%
													for (int i = 0; i < studentSubjectlist.size(); ++i) {
														SubjectForm subjectForm = new SubjectForm();
														subjectForm = studentSubjectlist.get(i);
												%>
												<option value="<%=subjectForm.getId()%>"><%=subjectForm.getSubjectname()%></option>
												<%
													}
												%>
											</select>
											<input type="submit" name="QueryB" id="QueryB"
												value="按课程名称查询">
										</td>
									</tr>
								</tbody>
							</table>
						</form>
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
											color = "#00E5EE";
										} else {
											color = "#FFFFFF";
										}
								%>
								<tr bgcolor="<%=color%>">
									<td><%=studentCheckForm.getStudentName()%></td>
									<td><%=studentCheckForm.getTeacherName()%></td>
									<td><%=studentCheckForm.getSubjectName()%></td>
									<td><%=studentCheckForm.getClassHour()%></td>
									<td><%=studentCheckForm.getLeave()%></td>
									<td><%=studentCheckForm.getTruancy()%></td>
									<td><%=studentCheckForm.getLate()%></td>
									<td><%=studentCheckForm.getLeaveEarly()%></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>
