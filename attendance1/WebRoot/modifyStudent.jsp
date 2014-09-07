<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.*"
	import="com.gdpi.attendance.form.*"
	import="com.gdpi.attendance.form.MajorForm" 
	import="java.util.List"
	import="java.util.ArrayList" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>修改学生信息</title>
	</head>
    	<%
	        GreadMajorClassDao greadMajorClassDao = new GreadMajorClassDao();
			List<MajorForm> majorList = new ArrayList();
			List<GreadMajorClassForm> greadMajorClassList = new ArrayList();
			majorList=greadMajorClassDao.AllMajorForm();
			greadMajorClassList=greadMajorClassDao.QueryNumberOfLTLL();
			
			AllStudentForm allStudentForm=(AllStudentForm)session.getAttribute("allStudentForm");
	
	 %>

	<body>
	<h3>修改学生信息</h3>
	     <table>
	      <form action="AdminServlet?method=6&sign=8&modify=2" method="post">
          <tr>
              年级<SELECT NAME="Grade">   
		<OPTION VALUE="<%=allStudentForm.getGradename() %>"><%=allStudentForm.getGradename() %> </OPTION>
		<%
           for (int i = 0; i < greadMajorClassList.size(); ++i) {
           GreadMajorClassForm greadMajorClassForm = new GreadMajorClassForm();
           greadMajorClassForm = greadMajorClassList.get(i);
        %>  
         <OPTION VALUE="<%=greadMajorClassForm.getGradename()%>"><%=greadMajorClassForm.getGradename()%> </OPTION>  
        <%
           }
        %>   
		</SELECT>
	    专业<SELECT NAME="Major">   
		<OPTION VALUE="<%=allStudentForm.getMajorname() %>"><%=allStudentForm.getMajorname() %> </OPTION>
		<%
		   for (int i = 0; i < majorList.size(); ++i) {
		       MajorForm majorForm = new MajorForm();
		       majorForm = majorList.get(i);   
		%> 
		   <OPTION VALUE="<%=majorForm.getMajorname() %>"><%=majorForm.getMajorname() %> </OPTION>  
		<%
		}
		 %>  		  
		</SELECT> 
		班级<SELECT NAME="Clas">   
		<OPTION VALUE="<%=allStudentForm.getClassname() %>"><%=allStudentForm.getClassname() %> </OPTION>
		<%
           for (int i = 0; i < greadMajorClassList.size(); ++i) {
           GreadMajorClassForm greadMajorClassForm = new GreadMajorClassForm();
           greadMajorClassForm = greadMajorClassList.get(i);
        %>  
         <OPTION VALUE="<%=greadMajorClassForm.getClasname()%>"><%=greadMajorClassForm.getClasname()%> </OPTION>  
        <%
           }
        %>   
		</SELECT>
                      角色：<SELECT NAME="rolename"> 
                <OPTION VALUE="<%=allStudentForm.getRolename() %>"><%=allStudentForm.getRoleDes() %></OPTION>  
		        <OPTION VALUE="student">普通学生</OPTION>
		        <OPTION VALUE="commissioner">学习委员</OPTION>
		</SELECT>
		<input name="studentid" type="hidden" value="<%=allStudentForm.getId()%>">
		   <tr>
             <td>
                                               姓名：<input name="studentname" type="text" value="<%=allStudentForm.getStudentname() %>">
             </td>
             <td>
                                              学号：<input name="studentaccount" type="text" value="<%=allStudentForm.getAccount() %>">
             </td>
             <td>
                                              密码：<input name="studentpassword" type="text" value="<%=allStudentForm.getPassword() %>">
             </td>
             <td>
                   <input name="修改" type="submit" value="修改"> 
                    <a href="AdminServlet?method=4&sign=5&Grade=<%=allStudentForm.getGradename()%>&Major=<%=allStudentForm.getMajorname() %>&Clas=<%=allStudentForm.getClassname() %>">取消</a>
             </td>
             </tr>
          </tr>
         </form> 
	     
	     </table>
	     
	</body>
</html>
