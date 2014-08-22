<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.GreadMajorClassDao"
	import="com.gdpi.attendance.form.GreadMajorClassForm"
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
		<title>管理年级、专业、班级的添加、删除、修改等。</title>
          

		<%
			GreadMajorClassDao greadMajorClassDao = new GreadMajorClassDao();
			List<GreadMajorClassForm> greadMajorClassList = new ArrayList();
			greadMajorClassList = (List<GreadMajorClassForm>) session
					.getAttribute("greadMajorClassForm");
		%>
	</head>

	<body>
	<h4>管理年级、专业、班级的添加、删除、修改</h4>
	<form action="AdminServlet?method=1&sign=1" method="post" >
	   <tr>
	             年级<input type="text" name="Grade"/>
	             年级描述<input type="text" name="GradeDes"/>        <p>
	             专业<input type="text" name="Major"/>
	             专业描述<input type="text" name="MajorDes"/>
	             </p>
	             班级<input type="text" name="Clas"/>    
	          <input type="submit" name="添加" value="添加"/>
	   </tr>
	</form>
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
										班级
									</td>
									<td>
										操作
									</td>
									
								</tr>
								<%
									int z = 0;
									String color = "";
									for (int i = 0; i < greadMajorClassList.size(); ++i) {
										GreadMajorClassForm greadMajorClassForm = new GreadMajorClassForm();
										greadMajorClassForm = greadMajorClassList.get(i);
										z = i % 2;
										if (z != 0) {
											color = "#00E5EE";
										} else {
											color = "#FFFFFF";
										}
								%>
								<tr bgcolor="<%=color%>">
									<td><%=greadMajorClassForm.getGradename()%></td>
									<td><%=greadMajorClassForm.getMajorname()%></td>
									<td><%=greadMajorClassForm.getClasname()%></td>
									<td><a href="AdminServlet?method=2&sign=2&classname='"+greadMajorClassForm.getClasname()+"'">修改</a>||<a href="#">删除</a></td>
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
