<%@ page language="java" import="java.util.*,com.gdpi.attendance.form.SubAttendanceComForm,com.gdpi.attendance.dao.TeacherDao" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@pagecontentType="application/vnd.ms-word;charset=utf-8"%>
<%
	response.setHeader("Content-disposition",
			"attachment; filename=TimeAttendance.doc");
%>
<html>
  <head>
   <title>辅导员—查看按单科查询的考勤</title>
  <script type="text/javascript">
	function AllAreaWord() {

		var PrintA = document.getElementById('PrintA');
		var oWD = new ActiveXObject("Word.Application");
		var oDC = oWD.Documents.Add("", 0, 1);
		var oRange = oDC.Range(0, 1);
		var sel = document.body.createTextRange();
		sel.moveToElementText(PrintA);
		sel.select();
		sel.execCommand("Copy");
		oRange.Paste();
		oWD.Application.Visible = true;
	}
</script>
   <%
			Integer leaveTimes = 0;
			Integer truancyTimes = 0;
			Integer lateTimes = 0;
			Integer leaveETimes = 0;
			List<SubAttendanceComForm> subAttendance = new ArrayList();
			subAttendance = (List<SubAttendanceComForm>) session
					.getAttribute("SubAttComForm");
		%>
    </head>
  <body>
  <table id="PrintA" cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1" border="0">
  		<tbody>
  			<tr><td colspan="7"><div align="center">班级时间段考勤表</div></td></tr>
   <tr bgcolor="#adceef"><td colspan="7"><div><strong>全部考勤表</strong></div></td></tr>
  			<tr>
  				<td>
  					<table id="attendance" cellspacing="1" cellpadding="0" width="100%" border="0">
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
  									//String check = subAC.getCheck();
  								//if(check.equals("已确认")) {
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
  									leaveTimes += Integer.valueOf(subAC.getLeave());
										truancyTimes += Integer.valueOf(subAC.getTruancy());
										lateTimes += Integer.valueOf(subAC.getLate());
										leaveETimes += Integer.valueOf(subAC.getLeaveEarly());
  								}
  							%>
  							<tr>
  							<td>
  						出勤统计：请假&nbsp;<%=leaveTimes %>&nbsp;&nbsp;旷课&nbsp;<%=truancyTimes %>&nbsp;&nbsp;迟到&nbsp;<%=lateTimes %>&nbsp;&nbsp;早退&nbsp;<%=leaveETimes %>	
  							</td>
  							</tr>
  						</tbody>
  					</table>
  				</td>
  			</tr>
  			<tr>
  			<td>
  			<center>
  			<input type="button" value="保存" onclick="AllAreaWord()" />
  			</center>
  			</td>
  			</tr>
  			</tbody>
  			</table>
  </body>
</html>
