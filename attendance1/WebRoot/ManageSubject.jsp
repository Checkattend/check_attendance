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
		<title>管理所有专业课</title>

		<%
             SubjectDao subjectDao = new SubjectDao();
              List<SubjectForm>  subjectFormList = new ArrayList();
              subjectFormList = subjectDao.getSubjectList();
		%>
	</head>

	<body>
	<h4>新添加添加专业课</h4>
	<p>
	     <form action="AdminServlet?method=22&sign=30" method="post">
          <tr>
		   <tr>
             <td>
                                              专业课：<input name="subjectname" type="text">
             </td>
             <td>
                                              描述：<input name="subjectdes" type="text">
             </td>
             <td>
                    <input  type="submit" name="button" value="添加">
             </td>
             </tr>
          </tr>
         </form> 
	</p>
	    <h4>已添加专业课</h4>
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
										专业课
									</td>
									<td>描述</td>
									<td>
										操作
									</td>
						       <%
									int z = 0;
									String color = "";
									for (int i = 0; i < subjectFormList.size(); ++i) {
										SubjectForm subjectForm = new SubjectForm();
										subjectForm = subjectFormList.get(i);
										z = i % 2;
										if (z != 0) {
											color = "#00E5EE";
										} else {
											color = "#FFFFFF";
										}
								%>
								<tr bgcolor="<%=color%>">
									<td><%=subjectForm.getSubjectname() %></td>
									<td><%=subjectForm.getDes() %></td>
									<td><a href="AdminServlet?method=23&sign=31&modify=1&subjectid=<%=subjectForm.getId()%>">修改</a>
									||<a href="AdminServlet?method=24&sign=33&subjectid=<%=subjectForm.getId() %>">删除</a></td>
				                 <% 
				                 }
				                 %>
				                 <%
				                     session.setAttribute("commit","notcommit");
				                  %>
								</tr>
								</tr>
							</tbody>	
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>
