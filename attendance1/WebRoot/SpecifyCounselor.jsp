<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.*"
	import="com.gdpi.attendance.form.*"
	import="com.gdpi.attendance.form.SubjectForm" import="java.util.List"
	import="java.util.ArrayList" pageEncoding="utf-8"%>

<html>
	<head>
		<title>添加新增教师</title>
	</head>
	<%
	        GreadMajorClassDao greadMajorClassDao = new GreadMajorClassDao();
			List<GreadMajorClassForm> greadMajorClassList = new ArrayList();
			greadMajorClassList=greadMajorClassDao.QueryNumberOfLTLL();
	
	
	        TeacherDao teacherDao = new TeacherDao();
	        List<GradeForm> gradelist= new ArrayList();
	        gradelist = teacherDao.getGrade();
	        
	        SpecifyCounselorDao specifyCounselorDao = new SpecifyCounselorDao();
	        List<TeacherForm> SpecifyCounselorlist= new ArrayList();
	        SpecifyCounselorlist =  specifyCounselorDao.getCounselor();
	        
	         List<Instructor_gradeForm> instructor_gradeFormlist= new ArrayList();
	        instructor_gradeFormlist =  specifyCounselorDao.getAllCounselor();
	
	 %>

	<body>
	<h3>指定辅导员</h3>
    <table>
    <thead>
    </thead>
    <tbody>
          <form action="AdminServlet?method=12&sign=16" method="post">
          <tr>
		   <tr>
             <td>
                  年级<SELECT NAME="Grade">   
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
		</SELECT>
             </td>
             <td>
             <td>
                  辅导员<SELECT NAME="Counselor">   
		<%
			for (int i = 0; i < SpecifyCounselorlist.size(); ++i) {
			TeacherForm teacherForm = new TeacherForm();
			teacherForm= SpecifyCounselorlist.get(i);
			//System.out.println(gradelist.size());
		%>
		<option value="<%=teacherForm.getTeachername()%>"><%=teacherForm.getTeachername()%></option>
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
          <h3>已安排辅导员</h3>
          
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
										辅导员
									</td>
									<td>教师号</td>
									<td>年级</td>
									<td>
										操作
									</td>
									
								</tr>
								<%
									int z = 0;
									String color = "";
									for (int i = 0; i < instructor_gradeFormlist.size(); ++i) {
										Instructor_gradeForm instructor_gradeForm = new Instructor_gradeForm();
										instructor_gradeForm = instructor_gradeFormlist.get(i);
										z = i % 2;
										if (z != 0) {
											color = "#00E5EE";
										} else {
											color = "#FFFFFF";
										}
								%>
								<tr bgcolor="<%=color%>">
									<td><%=instructor_gradeForm.getTeachername()%></td>
									<td><%=instructor_gradeForm.getAccount()%></td>
									<td><%=instructor_gradeForm.getGradename()%></td>
									<td><a href="AdminServlet?method=13&sign=17&modify=1&gradeId=<%=instructor_gradeForm.getGradeId()%>&teacherId=<%=instructor_gradeForm.getId() %>">修改</a>
									||<a href="AdminServlet?method=14&sign=19&gradeId=<%=instructor_gradeForm.getGradeId()%>&teacherId=<%=instructor_gradeForm.getId() %>">删除</a></td>
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
