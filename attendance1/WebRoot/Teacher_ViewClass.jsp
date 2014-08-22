<%@ page language="java" import="java.util.*" 
import="com.gdpi.attendance.form.GraMajClaTeacForm" 
import="com.gdpi.attendance.dao.TeacherDao" 
import="java.util.List"
import="java.util.ArrayList" 
pageEncoding="utf-8"%>
<html>
  <head>
    <title>查看授课班级</title>
 <%
			TeacherDao teacherDao = new TeacherDao();
			List<GraMajClaTeacForm> gmcTeacherlist = new ArrayList();
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
						<table cellspacing="0" cellpadding="3" rules="rows"
							bordercolor="#ADCEEF" border="1" id="AttendanceQuery"
							width="100%">
							<tbody>
								<tr bgcolor="#C1D8F0">
									<td>
										年级
									</td>
									<td>
										专业
									</td>
									<td>
										班名
									</td>
									
								</tr>
								<%
									int z = 0;
									String color = "";
									for (int i = 0; i < gmcTeacherlist.size(); ++i) {
										GraMajClaTeacForm gmcTeacherForm = new GraMajClaTeacForm();
										gmcTeacherForm = gmcTeacherlist.get(i);
										z = i % 2;
										if (z != 0) {
											color = "#00E5EE";
										} else {
											color = "#FFFFFF";
										}
								%>
								<tr bgcolor="<%=color%>">
									<td><%=gmcTeacherForm.getGradename()%></td>
									<td><%=gmcTeacherForm.getMajorname()%></td>
									<td><%=gmcTeacherForm.getClassname()%></td>
									
								
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
