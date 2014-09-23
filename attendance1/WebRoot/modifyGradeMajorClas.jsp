<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.*"
	import="com.gdpi.attendance.form.*"
	import="java.util.List"
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
		<title>管理年级、专业、班级的修改</title>
        <%
			GreadMajorClassDao greadMajorClassDao = new GreadMajorClassDao();
			List<MajorForm> majorList = new ArrayList();
			List<GreadMajorClassForm> greadMajorClassList = new ArrayList();
			majorList=greadMajorClassDao.AllMajorForm();
			greadMajorClassList=greadMajorClassDao.QueryNumberOfLTLL();
			
			TeacherDao teacherDao = new TeacherDao();
	        List<GradeForm> gradelist= new ArrayList();
	        gradelist = teacherDao.getGrade();
		%>
        <%
	       GreadMajorClassDao greadMajorClassDao1=new GreadMajorClassDao();
		   GreadMajorClassForm greadMajorClassForm=new GreadMajorClassForm();
	       greadMajorClassForm=greadMajorClassDao1.GreadMajorClassForm((GreadMajorClassForm)session.getAttribute("greadMajorClassForm"));
		%>
	</head>

	<body>
	<h4>管理年级、专业、班级的修改</h4>
		<table cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1"
			border="0">
			<tbody>
				<tr>
					<td>
					<form name="form1" method="post" action="AdminServlet?method=2&sign=3&modify=2&clasId=<%=greadMajorClassForm.getClasId()%>&gradeId=<%=greadMajorClassForm.getGradeId() %>&majorId=<%=greadMajorClassForm.getMajorId() %>">
						<table cellspacing="0" cellpadding="3" rules="rows"
							bordercolor="#ADCEEF" border="1" id="AttendanceQuery"
							width="100%">
							<tbody>

								  <tr bgcolor="#C1D8F0">
									<td>
		年级<SELECT NAME="Grade">  
		 <OPTION VALUE="<%=greadMajorClassForm.getGradeId()%>"><%=greadMajorClassForm.getGradename()%> </OPTION>
		<%
			for (int i = 0; i < gradelist.size(); ++i) {
			GradeForm gradeForm = new GradeForm();
			gradeForm= gradelist.get(i);
			//System.out.println(gradelist.size());
		%>
		<option value="<%=gradeForm.getId()%>"><%=gradeForm.getGradename()%></option>
		<%
			}
		%>
		</SELECT>
									</td>
									<td>
									         年级描述:<input type="text" name="gradeDes" value="<%=greadMajorClassForm.getGradeDes()%>">
									</td>
								   </tr>
								    <tr bgcolor="#C1D8F0">	
									<td>
										专业:<SELECT NAME="Major">   
												 <OPTION VALUE="<%=greadMajorClassForm.getMajorId()%>"><%=greadMajorClassForm.getMajorname()%> </OPTION>   
												<%
												   for (int i = 0; i < majorList.size(); ++i) {
												       MajorForm majorForm = new MajorForm();
												       majorForm = majorList.get(i);   
												%> 
												   <OPTION VALUE="<%=majorForm.getId() %>"><%=majorForm.getMajorname() %> </OPTION>  
												<%
												}
												 %>  		  
												</SELECT>
									</td>
									<td>
									          专业描述:<input type="text" name="majorDes" value="<%=greadMajorClassForm.getMajorDes()%>">
									</td>
									</tr>
									 <tr bgcolor="#C1D8F0">
									<td>
										班级:<SELECT NAME="Clas">  
											<OPTION VALUE="<%=greadMajorClassForm.getClasname()%>"><%=greadMajorClassForm.getClasname()%> </OPTION>
												<%
										           for (int i = 0; i < greadMajorClassList.size(); ++i) {
										           GreadMajorClassForm greadMajorClassForm1 = new GreadMajorClassForm();
										           greadMajorClassForm1 = greadMajorClassList.get(i);
										        %>  
										         <OPTION VALUE="<%=greadMajorClassForm1.getClasname()%>"><%=greadMajorClassForm1.getClasname()%> </OPTION>  
										        <%
										           }
										        %>   
		                                    </SELECT> 
									</td>
									<td><input name="提交" type="submit" value="确定修改"/>&nbsp;&nbsp;<a href="AdminServlet?method=0&sign=0">返回</a></td>
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
