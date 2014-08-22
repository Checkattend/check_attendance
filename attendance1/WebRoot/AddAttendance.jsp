<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.form.SubjectForm"
	import="com.gdpi.attendance.form.TeacherForm"
	import="com.gdpi.attendance.form.StudentForm"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加考勤表</title>
	<%
		List<SubjectForm> subjectlist = new ArrayList();
		List<TeacherForm> teacherlist = new ArrayList();
		List<StudentForm> studentlist = new ArrayList();
		subjectlist = (List<SubjectForm>) session.getAttribute("subjectlist");
		teacherlist = (List<TeacherForm>) session.getAttribute("teacherlist");
		studentlist = (List<StudentForm>) session.getAttribute("studentlist");
	%>
	<script type="text/javascript">
		function getName() {
			var fname = "";
			fname += "["+document.getElementById("subject").options[document.getElementById("subject").selectedIndex].text+"]第"+document.getElementById("number").value+"课时考勤表";
			document.getElementById("formname").value = fname;
		}
	</script>
  </head>
  
  <body>
  <form name="AddF" id="AddF" method="post" action="CommissionServlet?method=4&sign=4">
  	<table cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1" border="0">
  		<tbody>
  			<tr><td colspan="7"><div align="center">班级考勤表添加</div></td></tr>
  			<tr>
  				<td>
  					<table id="STK" cellspacing="1" cellpadding="0" width="100%" border="0" bgcolor="#adceef">
  						<tbody>
  							<tr>
  								<td>课程：
  									<select name="subject" id="subject">
  										<%
  											for(int i = 0; i < subjectlist.size(); ++i) {
  												SubjectForm subjectForm = new SubjectForm();
  												subjectForm = subjectlist.get(i);
  										%>
  											<option value="<%=subjectForm.getId() %>"><%=subjectForm.getSubjectname() %></option>
  										<%} %>
  									</select>
  								</td>
  								<td>任课老师：
  									<select name="teacher" id="teacher">
  										<%
  											for(int i = 0; i < teacherlist.size(); ++i) {
  												TeacherForm teacherForm = new TeacherForm();
  												teacherForm = teacherlist.get(i);
  										%>
  											<option value="<%=teacherForm.getId() %>"><%=teacherForm.getTeachername() %></option>
  										<%} %>
  									</select>
  								</td>
  								<td>课时：
  									<select name="number" id="number">
  										<%
  											for(int i = 1; i <= 80; ++i) {
  										%>
  											<option value="<%=i %>"><%=i %></option>
  										<%} %>
  									</select>
  								</td>
  								<td>
  									标题：
  									<input type="text" size="50" name="formname" id="formname" onclick="getName()" />
  								</td>
  							</tr>
  						</tbody>
  					</table>
  				</td>
  			</tr>
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
  								for(int i = 0; i < studentlist.size(); ++i) {
  									StudentForm studentForm = new StudentForm();
  									studentForm = studentlist.get(i);
  							%>
  							<tr align="center" bgcolor="#eef3f9">
  								<td><%=studentForm.getAccount() %></td>
  								<td><%=studentForm.getStudentname() %></td>
  								<td>
  									<input type="hidden" name="id<%=i %>" value="<%=studentForm.getId() %>" />
  									<input type="radio" name="R<%=i %>" value="study" checked="checked" />出勤
  									<input type="radio" name="R<%=i %>" value="leave" />请假
  									<input type="radio" name="R<%=i %>" value="truancy" />旷课
  									<input type="radio" name="R<%=i %>" value="late" />迟到
  									<input type="radio" name="R<%=i %>" value="leaveEarly" />早退
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
