<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.*"
	import="com.gdpi.attendance.form.*"
	import="java.util.List"
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
		<title>管理年级、专业、班级的添加</title>
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
	</head>

	<body>
	   <font color="red"> <h2>管理年级、专业、班级的添加</h2></font>
		<table cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1"
			border="0"  align="center">
			<tbody>
				<tr>
				 <FORM method="post" action="AdminServlet?method=1&sign=1&add=1" name="form1"> 
	      <tr>
	     <td> <font color="red"><b>添加已有班级：</b></font></td>
	     </tr>
	      <tr>
	         <td>    年级<SELECT NAME="Grade">   
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
		 <input name="submin" type="submit" value="添加"/> 
		 </td>
	      </tr>
	      
	      </FORM>
				</tr>
		<tr>
		<td>	
		 <form action="AdminServlet?method=1&sign=1&add=2" method="post" >      
		  <tr>
			  <td>
		           <font color="red"><b>新增一个专业：</b></font>
		      </td>
	      </tr> 
	      <tr> 
	      <td>
		           专业    <input type="text" name="Major"/>
			 专业描述<input type="text" name="MajorDes"/>
			        <input type="submit" name="添加" value="添加"/>  
			</td>  
		   </tr> 
	      </form>
	      </td>
	      </tr>
	      
	      <tr>
		<td>	
		 <form action="AdminServlet?method=1&sign=1&add=4" method="post" >      
		  <tr>
			  <td>
		           <font color="red"><b>新增一个年级：</b></font>
		      </td>
	      </tr> 
	      <tr> 
	      <td>
		           年级    <input type="text" name="Grade"/>
			 年级描述<input type="text" name="GradeDes"/>
			        <input type="submit" name="添加" value="添加"/>  
			</td>  
		   </tr> 
	      </form>
	      </td>
	      </tr>
	      
	      
	      <tr>
	      <td>
	      <form action="AdminServlet?method=1&sign=1&add=3" method="post" > 
	       <tr>
	           <td>
	                <font color="red"><b>新增一个新班：</b></font>
	           </td>
	      </tr>     
		  <tr>
		     <td>
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
		   专业 <SELECT NAME="Major">   
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
		
	    班级<input type="text" name="Clas"/>                
	      <input type="submit" name="添加" value="添加"/> 
		     
		     </td>
		  </tr>
		  
	    </form>
		</td>
	   </tr>
			</tbody>
		</table>
	</body>
</html>
