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
		<title>修改教师所教班级</title>
	</head>
	<%	
	      Class_teacherForm class_teacherForm = (Class_teacherForm)session.getAttribute("class_teacherForm");
	      
	      SpecifyClassTeacherDao specifyClassTeacherDao = new SpecifyClassTeacherDao();
	      List<TeacherForm> SpecifyCounselorlist= new ArrayList();
	      SpecifyCounselorlist =  specifyClassTeacherDao.getTeacher();	
	      
	      GreadMajorClassDao greadMajorClassDao = new GreadMajorClassDao();
		  List<GreadMajorClassForm> clasFormList = new ArrayList();
		  clasFormList = greadMajorClassDao.getClasForm();
	 %>

	<body>
	<h3>修改教师所教班级</h3>
    <table>
    <thead>
    </thead>
    <tbody>
          <form action="AdminServlet?method=16&sign=22&modify=2&clasid=<%=class_teacherForm.getClasId()%>&teacherid=<%=class_teacherForm.getTeacherid()%>" method="post">
          <tr>  
		  	   <tr>
             <td>
                       教师<SELECT NAME="teacher">
        <option value="<%=class_teacherForm.getTeacherid()%>"><%=class_teacherForm.getTeachername()%>(<%=class_teacherForm.getAccount() %>)</option>                 
		<%
			for (int i = 0; i < SpecifyCounselorlist.size(); ++i) {
			TeacherForm teacherForm = new TeacherForm();
			teacherForm= SpecifyCounselorlist.get(i);
			//System.out.println(gradelist.size());
		%>
		<option value="<%=teacherForm.getId()%>"><%=teacherForm.getTeachername()%></option>
		<%
			}
		%>
		</SELECT>
         班级<SELECT NAME="clas">
       <option value="<%=class_teacherForm.getClasId()%>"><%=class_teacherForm.getClasname()%>(<%=class_teacherForm.getGradename()%>,<%=class_teacherForm.getMajorname() %>)</option>     
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
                   <input name="button" type="submit" value="确定"> 
             </td>
             </tr>
          </tr>
          </tr>
         </form> 
    </tbody>
    <tfoot>
         
    </tfoot>
    </table>
	</body>
</html>
