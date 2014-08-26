<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.StudentDao"
	import="com.gdpi.attendance.form.GradeForm"
	import="com.gdpi.attendance.form.GraMajClaTeacForm" import="java.util.List"
	import="java.util.ArrayList"  import="com.gdpi.attendance.form.SubjectForm"  pageEncoding="utf-8"%>
<html>
	<head>
		<title>全学期学生考勤</title>
		<%
			List<GradeForm> gradelist= new ArrayList();
			List<SubjectForm> subjectlist= new ArrayList();
			List<GraMajClaTeacForm> gmcTeacherlist = new ArrayList();
			gradelist = (List<GradeForm>) session
					.getAttribute("gradelist");
					 subjectlist = (List<SubjectForm>) session.getAttribute("subjectlist");
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
						<form name="Form1" id="Form1" method="post"
							action="TeacherServlet?method=6&sign=6">
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
											<select name="grade" id="grade">
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
											&nbsp;<td>
											班级:
											<select name="clas" id="clas">
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
											&nbsp;<td>
											课程:
											<select name="subject" id="subject">
												<%
													for (int i = 0; i < subjectlist.size(); ++i) {
														SubjectForm subjectForm = new SubjectForm();
														 subjectForm= subjectlist.get(i);
												%>
												<option value="<%=subjectForm.getSubjectname()%>"><%= subjectForm.getSubjectname()%></option>
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