<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.*"
	import="com.gdpi.attendance.form.*"
	import="com.gdpi.attendance.form.SubjectForm" import="java.util.List"
	import="java.util.ArrayList" pageEncoding="utf-8"%>

<html>
	<head>
		<title>修改专业课</title>
	</head>
     <%
            SubjectForm subjectForm = (SubjectForm)session.getAttribute("subjectForm");
    
     %>
	<body>
	<h3>修改专业课</h3>
    <table>
    <thead>
    </thead>
    <tbody>
          <form action="AdminServlet?method=23&sign=32&modify=2&subjectid=<%=subjectForm.getId()%>" method="post">
          <tr>
		   <tr>
             <td>
                                              专业课：<input name="subjectname" type="text" value=<%=subjectForm.getSubjectname() %>>
             </td>
             <td>
                                             专业课 描述：<input name="subjectdes" type="text" value="<%=subjectForm.getDes() %>">
             </td>
             <td>
                   <input type="submit" name="button" value="修改">
                   <a href="ManageSubject.jsp">返回</a>
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
