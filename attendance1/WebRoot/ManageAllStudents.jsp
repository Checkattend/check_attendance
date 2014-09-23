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
			
			
			TeacherDao teacherDao = new TeacherDao();
	        List<GradeForm> gradelist= new ArrayList();
	        gradelist = teacherDao.getGrade();
	
	 %>
     <script type="text/javascript">
		  function getClass()
		  {
		     //获取专业下拉框
		     var major=document.form1.Major.value;  
		     //alert(major);
		     //获取班级下拉框
		     <%
		          List<ClasForm> clasFormList = new ArrayList();
		          clasFormList = greadMajorClassDao.getClas("");
		     %>
		     var clas=document.form1.Clas;   
		  }     
		
	</script>
	<body>
	<font color="red"><h2>管理所有学生添加,修改，删除</h2></font>
    <table>
    <tbody cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1"
			border="0"  align="left">
      <tr>
     <td>
         <font color="red">按年级-专业-班级查询学生</font>
         <form action="AdminServlet?method=4&sign=5" method="post" name="form1">
                   年级<SELECT NAME="Grade">   
		<%
			for (int i = 0; i < gradelist.size(); ++i) {
			GradeForm gradeForm = new GradeForm();
			gradeForm= gradelist.get(i);
			//System.out.println(gradelist.size());
		%>
		<option value="<%=gradeForm.getGradename()%>"><%=gradeForm.getGradename()%></option>
		<%
			}
		%>
		</SELECT>
	    专业<SELECT NAME="Major" onChange="getClass()">   
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
		 </td> 
       </tr>	
	   <tr>
		<td>
         <font color="red">添加新生</font>
          <form action="AdminServlet?method=5&sign=6" method="post">
              年级<SELECT NAME="Grade">   
		<%
			for (int i = 0; i < gradelist.size(); ++i) {
			GradeForm gradeForm = new GradeForm();
			gradeForm= gradelist.get(i);
			//System.out.println(gradelist.size());
		%>
		<option value="<%=gradeForm.getGradename()%>"><%=gradeForm.getGradename()%></option>
		<%
			}
		%>
		</SELECT>
	    专业<SELECT NAME="Major">   
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

                                              学号：<input name="studentaccount" type="text">

                                              密码：<input name="studentpassword" type="text">

                   <input name="添加" type="submit" value="添加"> 
           
           </td>
        </tr>                                        
         </form>
         </td> 
         </tr>
    </tbody>
    <tfoot>
         
    </tfoot>
    </table>
	</body>
</html>
