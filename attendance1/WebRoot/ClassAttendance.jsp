<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.form.SubAttendanceComForm"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>班级考勤</title>
	<%
		List<SubAttendanceComForm> SubAClist = new ArrayList();
		SubAClist = (List<SubAttendanceComForm>) session.getAttribute("SubAClist");
	%>
  </head>
  
  <body>
  	<table cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1" border="0">
  		<tbody>
  			<tr><td colspan="7"><div align="center">班级考勤查询</div></td></tr>
  			<tr bgcolor="#adceef"><td colspan="7"><div><strong>退回的考勤表</strong></div></td></tr>
  			<tr>
  				<td>
  					<table id="backAttendance" cellspacing="1" cellpadding="0" width="100%" border="0">
  						<tbody>
  							<tr bgcolor="#eef3f9">
  								<td>考勤表</td>
  								<td>年级</td>
  								<td>班级</td>
  								<td>课程</td>
  								<td>任课老师</td>
  								<td>日期</td>
  								<td>情况</td>
  							</tr>
  							<%
  								for(int i = 0; i < SubAClist.size(); ++i) {
  									SubAttendanceComForm subAC = new SubAttendanceComForm();
  									subAC = SubAClist.get(i);
  									String check = subAC.getCheck();
  									if(check.equals("退回")) {
  							%>
  								<tr>
  									<td><a style="text-decoration:none" href="CommissionServlet?method=1&sign=1&SubId=<%=subAC.getId() %>"><font color="black"><%=subAC.getFormname() %>【</font><font color="red"><%=subAC.getCheck() %></font><font color="black">】</font></a></td>
  									<td><%=subAC.getGradename() %></td>
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
  			<tr bgcolor="#adceef"><td colspan="7"><div><strong>未确认的考勤表</strong></div></td></tr>
  			<tr>
  				<td>
  					<table id="backAttendance" cellspacing="1" cellpadding="0" width="100%" border="0">
  						<tbody>
  							<tr bgcolor="#eef3f9">
  								<td>考勤表</td>
  								<td>年级</td>
  								<td>班级</td>
  								<td>课程</td>
  								<td>任课老师</td>
  								<td>日期</td>
  								<td>情况</td>
  							</tr>
  							<%
  								for(int i = 0; i < SubAClist.size(); ++i) {
  									SubAttendanceComForm subAC = new SubAttendanceComForm();
  									subAC = SubAClist.get(i);
  									String check = subAC.getCheck();
  									if(check.equals("未确认")) {
  							%>
  								<tr>
  									<td><a style="text-decoration:none" href="CommissionServlet?method=2&sign=2&SubId=<%=subAC.getId() %>"><font color="black"><%=subAC.getFormname() %>【</font><font color="red"><%=subAC.getCheck() %></font><font color="black">】</font></a></td>
  									<td><%=subAC.getGradename() %></td>
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
  			<tr bgcolor="#adceef"><td colspan="7"><div><strong>已确认的考勤表</strong></div></td></tr>
  			<tr>
  				<td>
  					<table id="backAttendance" cellspacing="1" cellpadding="0" width="100%" border="0">
  						<tbody>
  							<tr bgcolor="#eef3f9">
  								<td>考勤表</td>
  								<td>年级</td>
  								<td>班级</td>
  								<td>课程</td>
  								<td>任课老师</td>
  								<td>日期</td>
  								<td>情况</td>
  							</tr>
  							<%
  								for(int i = 0; i < SubAClist.size(); ++i) {
  									SubAttendanceComForm subAC = new SubAttendanceComForm();
  									subAC = SubAClist.get(i);
  									String check = subAC.getCheck();
  									if(check.equals("已确认")) {
  							%>
  								<tr>
  									<td><a style="text-decoration:none" href="CommissionServlet?method=2&sign=2&SubId=<%=subAC.getId() %>"><font color="black"><%=subAC.getFormname() %>【</font><font color="red"><%=subAC.getCheck() %></font><font color="black">】</font></a></td>
  									<td><%=subAC.getGradename() %></td>
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
