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
		<title>管理所有学生</title>
	</head>
	<%
	        GreadMajorClassDao greadMajorClassDao = new GreadMajorClassDao();
			List<MajorForm> majorList = new ArrayList();
			List<GreadMajorClassForm> greadMajorClassList = new ArrayList();
			majorList=greadMajorClassDao.AllMajorForm();
			greadMajorClassList=greadMajorClassDao.QueryNumberOfLTLL();
	
	 %>

	<body>
	<h3>管理所有学生添加,修改，删除</h3>
    <table>
    <thead>
           <h4>按年级-专业-班级查询学生</h4>
          <tr>
     <form action="AdminServlet?method=4&sign=5" method="post">
       年级<SELECT NAME="Grade">   
		<OPTION VALUE="0">请选择年级 </OPTION>
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
		<OPTION VALUE="0">请选择专业 </OPTION>
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
		<OPTION VALUE="0">请选择班级 </OPTION>
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
		<input name="查询" type="submit" value="查询"> 
		</form>
          
          </tr>
    </thead>
    <tbody>
          <h4>添加新生</h4>
          <form action="AdminServlet?method=5&sign=6" method="post">
          <tr>
              年级<SELECT NAME="Grade">   
		<OPTION VALUE="0">请选择年级 </OPTION>
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
		<OPTION VALUE="0">请选择专业 </OPTION>
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
		<OPTION VALUE="0">请选择班级 </OPTION>
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
		        <OPTION VALUE="student">普通学生</OPTION>
		        <OPTION VALUE="commissioner">学习委员</OPTION>
		</SELECT>
		   <tr>
             <td>
                                               姓名：<input name="studentname" type="text">
             </td>
             <td>
                                              学号：<input name="studentaccount" type="text">
             </td>
             <td>
                                              密码：<input name="studentpassword" type="text">
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
