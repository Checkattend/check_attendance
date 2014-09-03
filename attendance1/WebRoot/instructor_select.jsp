<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.InstructorDao"
	import="com.gdpi.attendance.form.GradeForm"
	import="com.gdpi.attendance.form.ClasForm" import="java.util.List" import="com.gdpi.attendance.form.SubjectForm" 
	import="java.util.ArrayList" pageEncoding="utf-8"%>
<html>
	<head>
		<title>辅导员按条件查询</title>
		<%
			List<GradeForm> grade = new ArrayList();
			List<ClasForm> clas = new ArrayList();
			List<SubjectForm> subject = new ArrayList();
			grade = (List<GradeForm>) session.getAttribute("grade");
			clas = (List<ClasForm>) session.getAttribute("clas");
			subject = (List<SubjectForm>) session.getAttribute("subject");
		%>
	</head>

	<body>
		<table cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1"
			border="0">
			<tbody>
				<tr>
					<td>
						<form name="Form1" id="Form1" method="post"
							action="InstructorServlet?method=2&sign=2">
							<table id="sbycategory" cellspacing="1" cellpadding="0"
								border="0">
								<tbody>
									<tr>
										<td>
										<font color="red"><b>按年份查询</b></font>
										</td>
									</tr>
									<tr>
										<td>
											年级:
											<select name="grade" id="grade">
												<%
													for (int i = 0; i < grade.size(); ++i) {
														GradeForm gradeForm = new GradeForm();
														gradeForm = grade.get(i);
														//System.out.println(gradelist.size());
												%>
												<option value="<%=gradeForm.getGradename()%>"><%=gradeForm.getGradename()%></option>
												<%
													}
												%>
											</select>
										</td>
										&nbsp;
										<td>
											班级:
											<select name="clas" id="clas">
												<%
													for (int i = 0; i < clas.size(); ++i) {
														ClasForm clasForm = new ClasForm();
														clasForm = clas.get(i);
												%>
												<option value="<%=clasForm.getClasname()%>"><%=clasForm.getClasname()%></option>
												<%
													}
												%>
											</select>
										</td>
										<td>
											<input type="submit" name="QueryB" id="QueryB" value="查询">
										</td>
									</tr>
								</tbody>
							</table>
						</form>
					</td>
				</tr>
				<tr>
				<td>
				<form name="Form1" id="Form1" method="post"
							action="InstructorServlet?method=2&sign=2">
							<table id="sbycategory" cellspacing="1" cellpadding="0"
								border="0">
								<tbody>
									<tr>
										<td>
											<font color="red"><b>按单科查询</b></font>
										</td>
									</tr>
									<tr>
										<td>
											年级:
											<select name="grade" id="grade">
												<%
													for (int i = 0; i < grade.size(); ++i) {
														GradeForm gradeForm = new GradeForm();
														gradeForm = grade.get(i);
														//System.out.println(gradelist.size());
												%>
												<option value="<%=gradeForm.getGradename()%>"><%=gradeForm.getGradename()%></option>
												<%
													}
												%>
											</select>
										</td>
										&nbsp;
										<td>
											班级:
											<select name="clas" id="clas">
												<%
													for (int i = 0; i < clas.size(); ++i) {
														ClasForm clasForm = new ClasForm();
														clasForm = clas.get(i);
												%>
												<option value="<%=clasForm.getClasname()%>"><%=clasForm.getClasname()%></option>
												<%
													}
												%>
											</select>
										</td>
										<td>
											科目:
											<select name="clas" id="clas">
												<%
													for (int i = 0; i < subject.size(); ++i) {
														SubjectForm subjectForm = new SubjectForm();
														subjectForm = subject.get(i);
												%>
												<option value="<%=subjectForm.getSubjectname()%>"><%=subjectForm.getSubjectname()%></option>
												<%
													}
												%>
											</select>
										</td>
										<td>
											<input type="submit" name="QueryB" id="QueryB" value="查询">
										</td>
									</tr>
								</tbody>
							</table>
						</form>
				</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>