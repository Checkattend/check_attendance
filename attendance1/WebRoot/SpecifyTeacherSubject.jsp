<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.*"
	import="com.gdpi.attendance.form.*"
	import="com.gdpi.attendance.form.SubjectForm" import="java.util.List"
	import="java.util.ArrayList" pageEncoding="utf-8"%>

<html>
	<head>
		<title>指定教师-专业课</title>
	</head>
	<%
	        //获取专业列表
	        SubjectDao subjectDao = new SubjectDao();
	        List<SubjectForm> subjectFormList = new ArrayList();
	        subjectFormList = subjectDao.getSubjectList();
	       // subjectForm = subjectDao.getSubjectList();
	        //获取教师列表
	        SpecifyClassTeacherDao specifyClassTeacherDao = new SpecifyClassTeacherDao();
	        List<TeacherForm> SpecifyCounselorlist= new ArrayList();
	        SpecifyCounselorlist =  specifyClassTeacherDao.getTeacher();
	        //获取已安排好教师所教专业课
	         SpecifyTeacherSubjectDao  specifyTeacherSubjectDao = new SpecifyTeacherSubjectDao();
	         List<Class_subject_teacherForm> subject_teacherFormlist = new ArrayList();
	         subject_teacherFormlist =  specifyTeacherSubjectDao.getSpecifyTeacherSubject();
	
	 %>

	<body>
	<h3>指定老师所教专业课</h3>
    <table>
    <thead>
    </thead>
    <tbody>
          <form action="AdminServlet?method=25&sign=34" method="post">
          <tr>
		   <tr>
             <td>
             <td>
                     教师<SELECT NAME="teacher">   
		<%
			for (int i = 0; i < SpecifyCounselorlist.size(); ++i) {
			TeacherForm teacherForm = new TeacherForm();
			teacherForm= SpecifyCounselorlist.get(i);
			//System.out.println(gradelist.size());
		%>
		<option value="<%=teacherForm.getId() %>"><%=teacherForm.getTeachername()%>(<%=teacherForm.getAccount() %>)</option>
		<%
			}
		%>
		</SELECT>
		           <td>
                  专业课<SELECT NAME="subject">   
		<%
			for (int i = 0; i < subjectFormList.size(); ++i) {
			SubjectForm subjectForm = new SubjectForm();
			subjectForm = subjectFormList.get(i);
		%>
		<option value="<%=subjectForm.getId() %>"><%=subjectForm.getSubjectname() %></option>
		<%
			}
		%>
		</SELECT>
             </td>

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
          <h3>已选定老师所教专业课</h3>
          
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
									<td>所教专业课</td>
									<td>
										操作
									</td>
									
								</tr>
								<%
									int z = 0;
									String color = "";
									for (int i = 0; i < subject_teacherFormlist.size(); ++i) {
										Class_subject_teacherForm class_subject_teacherForm = new Class_subject_teacherForm();
										class_subject_teacherForm = subject_teacherFormlist.get(i);
										z = i % 2;
										if (z != 0) {
											color = "#00E5EE";
										} else {
											color = "#FFFFFF";
										}
								%>
								<tr bgcolor="<%=color%>">
									<td><%=class_subject_teacherForm.getTeachername()%></td>
									<td><%=class_subject_teacherForm.getAccount()%></td>
									<td><%=class_subject_teacherForm.getSubjectname() %></td>
									<td><a href="AdminServlet?method=26&sign=35&modify=1&subjectid=<%=class_subject_teacherForm.getSubjectid()%>&teacherid=<%=class_subject_teacherForm.getTeacherid()%>">修改</a>
									||<a href="AdminServlet?method=27&sign=37&subjectid=<%=class_subject_teacherForm.getSubjectid()%>&teacherid=<%=class_subject_teacherForm.getTeacherid()%>">删除</a></td>
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
