<%@ page language="java" import="java.util.*,com.gdpi.attendance.form.SubAttendanceComForm,com.gdpi.attendance.dao.TeacherDao" pageEncoding="UTF-8"%>
<html>
  <head>
   <title>老师—查看班级考勤</title>
   <%
			TeacherDao teacherDao = new TeacherDao();
			List<SubAttendanceComForm> subAttendance = new ArrayList();
			subAttendance = (List<SubAttendanceComForm>) session
					.getAttribute("subAttendance");
		%>
    </head>
  <body>
  <table cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1" border="0">
  		<tbody>
  			<tr><td colspan="7"><div align="center">班级考勤</div></td></tr>
   <tr bgcolor="#adceef"><td colspan="7"><div><strong>未确认的考勤表</strong></div></td></tr>
  			<tr>
  				<td>
  					<table id="backAttendance" cellspacing="1" cellpadding="0" width="100%" border="0">
  						<tbody>
  							<tr bgcolor="#eef3f9">
  								<td>考勤表</td>
  								<td>年级</td>
  								<td>课时</td>
  								<td>班级</td>
  								<td>课程</td>
  								<td>任课老师</td>
  								<td>日期</td>
  								<td>情况</td>
  								<td>操作</td>
  							</tr>
  							<%
  								for(int i = 0; i < subAttendance.size(); ++i) {
  									SubAttendanceComForm subAC = new SubAttendanceComForm();
  									subAC = subAttendance.get(i);
  									String check = subAC.getCheck();
  									if(check.equals("未确认")) {
  							%>
  								<tr bgcolor="ffffff">
  									<td><font color="black">【</font><font color="red"><%=subAC.getCheck() %></font><font color="black">】</font></td>
  									<td><%=subAC.getGradename() %></td>
  									<td><%=subAC.getFormname() %></td>
  									<td><%=subAC.getClassname() %></td>
  									<td><%=subAC.getSubjectname() %></td>
  									<td><%=subAC.getTeachername() %></td>
  									<td><%=subAC.getThedate() %></td>
  									<td>请假：<%=subAC.getLeave() %>&nbsp;&nbsp;旷课：<%=subAC.getTruancy() %>&nbsp;&nbsp;迟到：<%=subAC.getLate() %>&nbsp;&nbsp;早退：<%=subAC.getLeaveEarly() %></td>
  								<td>&nbsp;<a  style="text-decoration:none" href="TeacherServlet?method=3&sign=3&SubId=<%=subAC.getId() %>"><img src="lib/ligerUI/skins/icons/ok.gif"></img></a>&nbsp;&nbsp;&nbsp;<a  style="text-decoration:none" href="TeacherServlet?method=4&sign=4&SubId=<%=subAC.getId() %>"><img src="lib/ligerUI/skins/icons/back.gif"></img></a></td>
  								</tr>
  							<%
  									}
  								}
  							%>
  						</tbody>
  					</table>
  				</td>
  			</tr>
  			<tr bgcolor="#adceef"><td colspan="7"><div><strong>退回的考勤表</strong></div></td></tr>
  			<tr>
  				<td>
  					<table id="backAttendance" cellspacing="1" cellpadding="0" width="100%" border="0">
  						<tbody>
  							<tr bgcolor="#eef3f9">
  								<td>考勤表</td>
  								<td>年级</td>
  								<td>课时</td>
  								<td>班级</td>
  								<td>课程</td>
  								<td>任课老师</td>
  								<td>日期</td>
  								<td>情况</td>
  							</tr>
  							<%
  								for(int i = 0; i < subAttendance.size(); ++i) {
  									SubAttendanceComForm subAC = new SubAttendanceComForm();
  									subAC = subAttendance.get(i);
  									String check = subAC.getCheck();
  									if(check.equals("退回")) {
  							%>
  								<tr bgcolor="ffffff">
  									<td><font color="black">【</font><font color="red"><%=subAC.getCheck() %></font><font color="black">】</font></td>
  									<td><%=subAC.getGradename() %></td>
  									<td><%=subAC.getFormname() %></td>
  									<td><%=subAC.getClassname() %></td>
  									<td><%=subAC.getSubjectname() %></td>
  									<td><%=subAC.getTeachername() %></td>
  									<td><%=subAC.getThedate() %></td>
  									<td>请假：<%=subAC.getLeave() %>&nbsp;&nbsp;旷课：<%=subAC.getTruancy() %>&nbsp;&nbsp;迟到：<%=subAC.getLate() %>&nbsp;&nbsp;早退：<%=subAC.getLeaveEarly() %></td>
  								</tr>
  							<%
  									}
  								}
  							%>
  						</tbody>
  					</table>
  				</td>
  			</tr>
  			</tbody>
  			</table>
  </body>
</html>
