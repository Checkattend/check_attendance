<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.*"
	import="com.gdpi.attendance.form.*"
	import="com.gdpi.attendance.form.SubjectForm" import="java.util.List"
	import="java.util.ArrayList" pageEncoding="utf-8"%>

<html>
	<head>
		<title>指定教师-班级</title>
	</head>
	<%
	        GreadMajorClassDao greadMajorClassDao = new GreadMajorClassDao();
			List<GreadMajorClassForm> clasFormList = new ArrayList();
			clasFormList = greadMajorClassDao.getClasForm();
	
	
	        TeacherDao teacherDao = new TeacherDao();
	        List<GradeForm> gradelist= new ArrayList();
	        gradelist = teacherDao.getGrade();
	        
	        SpecifyClassTeacherDao specifyClassTeacherDao = new SpecifyClassTeacherDao();
	        List<TeacherForm> SpecifyCounselorlist= new ArrayList();
	        SpecifyCounselorlist =  specifyClassTeacherDao.getTeacher();
	        
	         List<Class_teacherForm> class_teacherFormlist= new ArrayList();
	         class_teacherFormlist =  specifyClassTeacherDao.getSpecifyClassTeacher();
	
	 %>

	<body>
	<h3>指定老师所教班级</h3>
    <table>
    <thead>
    </thead>
    <tbody>
          <form action="AdminServlet?method=15&sign=20" method="post">
          <tr>
		   <tr>
             <td>
                  班级<SELECT NAME="clas">   
		<%
			for (int i = 0; i < clasFormList.size(); ++i) {
			GreadMajorClassForm clasForm = new GreadMajorClassForm();
			clasForm = clasFormList.get(i);
			//System.out.println(gradelist.size());
		%>
		<option value="<%=clasForm.getClasId()%>"><%=clasForm.getClasname()%>(<%=clasForm.getGradename()%>,<%=clasForm.getMajorname() %>)</option>
		<%
			}
		%>
		</SELECT>
             </td>
             <td>
             <td>
                     教师<SELECT NAME="teacher">   
		<%
			for (int i = 0; i < SpecifyCounselorlist.size(); ++i) {
			TeacherForm teacherForm = new TeacherForm();
			teacherForm= SpecifyCounselorlist.get(i);
			//System.out.println(gradelist.size());
		%>
		<option value="<%=teacherForm.getTeachername()%>"><%=teacherForm.getTeachername()%>(<%=teacherForm.getAccount() %>)</option>
		<%
			}
		%>
		</SELECT>

             </td>
             <td>
                   <input name="确定" type="submit" value="确定"> 
             </td>
             </tr>
          </tr>
         </form> 
    </tbody>
    <tfoot>
         
    </tfoot>
    </table>
    <table>
          <h3>已指定老师所教班级</h3>
          
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
										教师
									</td>
									<td>教师号</td>
									<td>所教班级</td>
									<td>
										操作
									</td>
									
								</tr>
								<%
									int z = 0;
									String color = "";
									for (int i = 0; i < class_teacherFormlist.size(); ++i) {
										Class_teacherForm class_teacherForm = new Class_teacherForm();
										class_teacherForm = class_teacherFormlist.get(i);
										z = i % 2;
										if (z != 0) {
											color = "#00E5EE";
										} else {
											color = "#FFFFFF";
										}
								%>
								<tr bgcolor="<%=color%>">
									<td><%=class_teacherForm.getTeachername()%></td>
									<td><%=class_teacherForm.getAccount()%></td>
									<td><%=class_teacherForm.getClasname()%>(<%=class_teacherForm.getGradename()%>,<%=class_teacherForm.getMajorname() %>)</td>
									<td><a href="AdminServlet?method=16&sign=21&modify=1&clasId=<%=class_teacherForm.getClasId()%>&teacherId=<%=class_teacherForm.getTeacherid() %>">修改</a>
									||<a href="AdminServlet?method=17&sign=23&clasId=<%=class_teacherForm.getClasId()%>&teacherId=<%=class_teacherForm.getTeacherid() %>">删除</a></td>
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
    </table>
	</body>
</html>
