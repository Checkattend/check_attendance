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
		<title>修改教师所教专业课</title>
	</head>
	<%	
	      //获取要修改的教师所教专业课
	      Class_subject_teacherForm class_subject_teacherForm = (Class_subject_teacherForm)session.getAttribute("class_subject_teacherForm");
	      
	      //获取教师列表
	        SpecifyClassTeacherDao specifyClassTeacherDao = new SpecifyClassTeacherDao();
	        List<TeacherForm> SpecifyCounselorlist= new ArrayList();
	      
	      //获取专业列表
	        SubjectDao subjectDao = new SubjectDao();
	        List<SubjectForm> subjectFormList = new ArrayList();
	        subjectFormList = subjectDao.getSubjectList();
	 %>

	<body>
	<h3>修改教师所教专业课</h3>
    <table>
    <thead>
    </thead>
    <tbody>
          <form action="AdminServlet?method=26&sign=36&modify=2&subjectid=<%=class_subject_teacherForm.getSubjectid()%>&teacherid=<%=class_subject_teacherForm.getTeacherid()%>" method="post">
          <tr>  
		  	   <tr>
             <td>
                     教师<SELECT NAME="teacher">
         <option value="<%=class_subject_teacherForm.getTeacherid() %>"><%=class_subject_teacherForm.getTeachername() %>(<%=class_subject_teacherForm.getAccount() %>)</option>                 
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
      专业课<SELECT NAME="subject"> 
         <option value="<%=class_subject_teacherForm.getSubjectid()%>"><%=class_subject_teacherForm.getSubjectname() %></option>                 
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
             <td>
                   <input name="button" type="submit" value="确定"> 
                   <a href="SpecifyTeacherSubject.jsp">返回</a>
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
