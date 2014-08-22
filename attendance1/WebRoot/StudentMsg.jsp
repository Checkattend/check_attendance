<%@ page language="java" import="java.util.*"
 import="com.gdpi.attendance.form.StudentMsgForm"
 pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>学生个人信息</title>
	<%
		StudentMsgForm studentMsgForm = new StudentMsgForm();
		studentMsgForm = (StudentMsgForm) session.getAttribute("studentMsgForm");
	%>
  </head>
  
  <body>
  	<table cellspacing="1" cellpadding="3" width="100%" align="center" bgcolor="#adceef" border="0">
  		<tbody>
  			<tr><td colspan="7"><div align="center">学生基本信息查询</div></td></tr>
  			<tr>
  				<td style="WIDTH:69px; HIGHT:21px" width="69" bgcolor="#eef3f9">学号：</td>
  				<td style="WIDTH:162px; HIGHT:21px" width="162" bgcolor="#eef3f9"><%=studentMsgForm.getAccount() %></td>
  				<td style="WIDTH:69px; HIGHT:21px" width="69" bgcolor="#eef3f9">姓名：</td>
  				<td style="WIDTH:181px; HIGHT:21px" width="69" bgcolor="#eef3f9"><%=studentMsgForm.getStudentName() %></td>
  			</tr>
  			<tr>
  				<td style="WIDTH:69px" bgcolor="#ffffff">专业：</td>
  				<td style="WIDTH:162px" bgcolor="#ffffff"><%=studentMsgForm.getMajorName() %></td>
  				<td bgcolor="#ffffff">年级</td>
  				<td style="WIDTH:181px" bgcolor="#ffffff"><%=studentMsgForm.getGradeName() %></td>
  			</tr>
  			<tr>
  				<td style="WIDTH:69px" bgcolor="#eef3f9">班级：</td>
  				<td style="WIDTH:162px" bgcolor="#eef3f9"><%=studentMsgForm.getClassName() %></td>
  				<td bgcolor="#eef3f9">备注：</td>
  				<td style="WIDTH:181px" bgcolor="#eef3f9">&nbsp;</td>
  			</tr>
  		</tbody>
  	</table>
  </body>
</html>
