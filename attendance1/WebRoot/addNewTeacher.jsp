<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.*"
	import="com.gdpi.attendance.form.*"
	import="com.gdpi.attendance.form.SubjectForm" import="java.util.List"
	import="java.util.ArrayList" pageEncoding="utf-8"%>

<html>
	<head>
		<title>添加新增教师</title>
	</head>

	<body>
	<h3>添加新增教师</h3>
    <table>
    <thead>
    </thead>
    <tbody>
          <form action="AdminServlet?method=9&sign=11" method="post">
          <tr>
                      角色：<SELECT NAME="rolename">   
		        <OPTION VALUE="teacher">教师</OPTION>
		        <OPTION VALUE="instructor">辅导员</OPTION>
		        <OPTION VALUE="administrator">管理员</OPTION>
		</SELECT>
		   <tr>
             <td>
                                               姓名：<input name="teachername" type="text">
             </td>
             <td>
                                              教师号：<input name="teacheraccount" type="text">
             </td>
             <td>
                                              密码：<input name="teacherpassword" type="text">
             </td>
             <td>
                   <input name="添加" type="submit" value="添加"> 
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
