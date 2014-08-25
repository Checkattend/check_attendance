<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.StudentDao"
	import="com.gdpi.attendance.form.GradeForm"
	import="com.gdpi.attendance.form.GraMajClaTeacForm" import="java.util.List"
	import="java.util.ArrayList" pageEncoding="utf-8"%>
<html>
	<head>
		<title>全学期学生考勤</title>
		<%
			Integer leaveTimes = 0;
			Integer truancyTimes = 0;
			Integer lateTimes = 0;
			Integer leaveETimes = 0;
			List<GradeForm> gradelist= new ArrayList();
			List<GraMajClaTeacForm> gmcTeacherlist = new ArrayList();
			gradelist = (List<GradeForm>) session
					.getAttribute("gradelist");
			gmcTeacherlist = (List<GraMajClaTeacForm>) session
					.getAttribute("gmcTeacherlist");
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
								border="0">
								<tbody>
									<tr>
										<td>
											查询条件
										</td>
									</tr>
									<tr>
										<td>
											年级:
											<select name="subject" id="subject">
												<%
													for (int i = 0; i < gradelist.size(); ++i) {
														GradeForm gradeForm = new GradeForm();
														gradeForm= gradelist.get(i);
														//System.out.println(gradelist.size());
												%>
												<option value="<%=gradeForm.getGradename()%>"><%=gradeForm.getGradename()%></option>
												<%
													}
												%>
											</select>
											</td>
											<td>
											班级
											<select name="subject" id="subject">
												<%
													for (int i = 0; i < gmcTeacherlist.size(); ++i) {
														GraMajClaTeacForm gmcTeacgerForm = new GraMajClaTeacForm();
														 gmcTeacgerForm= gmcTeacherlist.get(i);
												%>
												<option value="<%=gmcTeacgerForm.getClassname()%>"><%= gmcTeacgerForm.getClassname()%></option>
												<%
													}
												%>
											</select>
											</td>
											<td>
											<input type="submit" name="QueryB" id="QueryB"
												value="查询">
										</td>
									</tr>
								</tbody>
							</table>
						</form>
		</td></tr></tbody></table>
	</body>
</html>