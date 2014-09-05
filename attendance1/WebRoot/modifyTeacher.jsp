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
		<title>修改教师信息</title>
	</head>
	<%	
	     TeacherForm teacherForm=new TeacherForm();	
		 teacherForm=(TeacherForm)session.getAttribute("teacherForm");	
	 %>

	<body>
	<h3>修改教师信息</h3>
    <table>
    <thead>
    </thead>
    <tbody>
          <form action="AdminServlet?method=10&sign=13&modify=2" method="post">
          <tr>
                      角色：<SELECT NAME="rolename"> 
                <OPTION VALUE="<%=teacherForm.getRolename() %>"><%=teacherForm.getRoledes() %></OPTION>  
		        <OPTION VALUE="teacher">教师</OPTION>
		        <OPTION VALUE="instructor">辅导员</OPTION>
		        <OPTION VALUE="administrator">管理员</OPTION>
		</SELECT>
		    <input name="teacherId" type="hidden" value="<%=teacherForm.getId() %>">
		   <tr>
             <td>
                                               姓名：<input name="teachername" type="text" value="<%=teacherForm.getTeachername() %>">
             </td>
             <td>
                                              教师号：<input name="teacheraccount" type="text" value="<%=teacherForm.getAccount() %>">
             </td>
             <td>
                                              密码：<input name="teacherpassword" type="text" value="<%=teacherForm.getPassword() %>">
             </td>
             <td>
                   <input name="修改" type="submit" value="修改"> 
             </td>
             </tr>
          </tr>
         </form> 
    </tbody>
    <tfoot>
         
    </tfoot>
    </table>
	</body>
</html>
