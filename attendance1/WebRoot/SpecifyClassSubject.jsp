<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.*"
	import="com.gdpi.attendance.form.*"
	import="com.gdpi.attendance.form.SubjectForm" import="java.util.List"
	import="java.util.ArrayList" pageEncoding="utf-8"%>

<html>
	<head>
		<title>指定班级-专业课及任课老师</title>
		
	</head>
	<%
	        //获取班级列表
	        GreadMajorClassDao greadMajorClassDao = new GreadMajorClassDao();
			List<GreadMajorClassForm> clasFormList = new ArrayList();
			clasFormList = greadMajorClassDao.getClasForm();
	
	        //获取年级列表
	        TeacherDao teacherDao = new TeacherDao();
	        List<GradeForm> gradelist= new ArrayList();
	        gradelist = teacherDao.getGrade();
	        
	        //获取专业课列表
	        ClassSubjectTeacherDao classSubjectTeacherDao = new ClassSubjectTeacherDao();
	        List<SubjectForm>  subjectFormList = new ArrayList();
	        subjectFormList = classSubjectTeacherDao.getAllSubject();
	        //获取已选好的专业课
	        String classid=null;
	        String submit ="hidden";
	        List<Class_subject_teacherForm>  Class_subject_teacherFormList = new ArrayList();
	        if(session.getAttribute("class_subject_teacherForm")!=null && session.getAttribute("commit").equals("commit"))
	        {
	          classid = (String)session.getAttribute("class"); 
	          submit = (String)session.getAttribute("submit"); 
	          Class_subject_teacherFormList = (ArrayList)session.getAttribute("class_subject_teacherForm");     
	        }
            
	 %>
    <script type="text/javascript">
		      function change()
	    {
		      var o=document.getElementById("add");
		      o.style.display="none"
	    }
		</script>

	<body>
	<h3>&lt;指定班级-专业课及任课老师</h3>
    <table>
    <thead>
    </thead>
    <tbody>
          <form action="AdminServlet?method=18&sign=24" method="post">
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
             </td>
             <td>
                   <input name="button" type="submit" value="查询" onclick="change()" /> 
             </td>
             </tr>
          </tr>
         </form> 
    </tbody>
    <tfoot>
         
    </tfoot>
    </table>
    <table>
           <h3>已指定班级所学专业课及任课老师</h3>
           <form action="AdminServlet?method=21&sign=28&add=1&clasid=<%=classid %>" method="post" name="form">
                  <input id="add" name="button1" type="<%=submit %>" value="添加专业课"/>
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
										班级
									</td>
									<td>所学专业课</td>
									<td>任课老师</td>
									<td>
										操作
									</td>
						       <%
									int z = 0;
									String color = "";
									for (int i = 0; i < Class_subject_teacherFormList.size()&&Class_subject_teacherFormList!=null; ++i) {
										Class_subject_teacherForm class_subject_teacherForm = new Class_subject_teacherForm();
										class_subject_teacherForm = Class_subject_teacherFormList.get(i);
										z = i % 2;
										if (z != 0) {
											color = "#00E5EE";
										} else {
											color = "#FFFFFF";
										}
								%>
								<tr bgcolor="<%=color%>">
									<td><%=class_subject_teacherForm.getClasname()%>(<%=class_subject_teacherForm.getGradename() %>,<%=class_subject_teacherForm.getMajorname() %>)</td>
									<td><%=class_subject_teacherForm.getSubjectname() %></td>
									<td><%=class_subject_teacherForm.getTeachername() %>(<%=class_subject_teacherForm.getAccount() %>)</td>
									<td><a href="AdminServlet?method=19&sign=25&modify=1&clasId=<%=class_subject_teacherForm.getClasId()%>&teacherId=<%=class_subject_teacherForm.getTeacherid() %>&subjectid=<%=class_subject_teacherForm.getSubjectid() %>">修改</a>
									||<a href="AdminServlet?method=20&sign=27&clasId=<%=class_subject_teacherForm.getClasId()%>&subjectid=<%=class_subject_teacherForm.getSubjectid() %>">删除</a></td>
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
    </table>
	</body>
</html>
