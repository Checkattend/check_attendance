<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.InstructorDao"
	import="com.gdpi.attendance.form.GradeForm"
	import="com.gdpi.attendance.form.ClasForm" import="java.util.List"
	import="java.util.ArrayList"  pageEncoding="utf-8"%>
<html>
	<head>
		<title>辅导员按条件查询</title>
		<%
		List<GradeForm>grade=new ArrayList();
			List<ClasForm> clas= new ArrayList();
			grade=(List<GradeForm>)session.getAttribute("grade");
			clas = (List<ClasForm>) session
					.getAttribute("clas");
					 
		%>
	</head>

	<body>
		<table cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1"
			border="0">
			<tbody>
				<tr>
					<td>
						<form name="Form1" id="Form1" method="post"
							action="TeacherServlet?method=&sign=">
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
													for (int i = 0; i < grade.size(); ++i) {
														GradeForm gradeForm = new GradeForm();
														gradeForm= grade.get(i);
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
													for (int i = 0; i < clas.size(); ++i) {
														ClasForm clasForm = new ClasForm();
														clasForm= clas.get(i);
												%>
												<option value="<%=clasForm.getClasname()%>"><%=clasForm.getClasname()%></option>
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