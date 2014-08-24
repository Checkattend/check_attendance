<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.form.StudentCheckForm"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改考勤表</title>
	<%
		List<StudentCheckForm> attendancelist = new ArrayList();
		attendancelist = (List<StudentCheckForm>) session.getAttribute("attendancelist");
	%>
  </head>
  
  
  <body>
  <form name="AddF" id="AddF" method="post" action="CommissionServlet?method=1&sign=4">
  	<table cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1" border="0">
  		<tbody>
  			<tr><td colspan="7"><div align="center">班级考勤表修改</div></td></tr>
  			<tr>
  				<td>
  					<table id="students" cellspacing="1" cellpadding="0" width="100%" border="0">
  						<tbody>
  							<tr bgcolor="#adceef" align="center">
  								<td>学号</td>
  								<td>姓名</td>
  								<td>考勤情况</td>
  							</tr>
  							<%
  								for(int i = 0; i < attendancelist.size(); ++i) {
  									StudentCheckForm studentCheckForm = new StudentCheckForm();
  									studentCheckForm = attendancelist.get(i);
  									Integer leave = studentCheckForm.getLeave();
  									Integer truancy = studentCheckForm.getTruancy();
  									Integer late = studentCheckForm.getLate();
  									Integer leaveEarly = studentCheckForm.getLeaveEarly();
  							%>
  							<tr align="center" bgcolor="#eef3f9">
  								<td><%=studentCheckForm.getAccount() %></td>
  								<td><%=studentCheckForm.getStudentName() %></td>
  								<td>
  									<input type="hidden" name="id<%=i %>" value="<%=studentCheckForm.getId() %>" />
  									<input type="radio" name="R<%=i %>" value="study" <%if(leave == 0 && truancy == 0 && late == 0 && leaveEarly == 0) { %>checked="checked"<%} %> />出勤
  									<input type="radio" name="R<%=i %>" value="leave" <%if(leave == 1) { %>checked="checked"<%} %> />请假
  									<input type="radio" name="R<%=i %>" value="truancy" <%if(truancy == 1) { %>checked="checked"<%} %> />旷课
  									<input type="radio" name="R<%=i %>" value="late" <%if(late == 1) { %>checked="checked"<%} %> />迟到
  									<input type="radio" name="R<%=i %>" value="leaveEarly" <%if(leaveEarly == 1) { %>checked="checked"<%} %> />早退
  								</td>
  							</tr>
  							<%} %>
  						</tbody>
  					</table>
  				</td>
  			</tr>
  		</tbody>
  		<tr>
  			<td>
  				<font color="red">注：提交考勤表后，不能再修改（任课老师退回除外），请谨慎填写</font>
  				<input type="submit" name="submitall" id="submitall" value="提交" />
  			</td>
  		</tr>
  	</table>
  	</form>
  </body>
</html>
