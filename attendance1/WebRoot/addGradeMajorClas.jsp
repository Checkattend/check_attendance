<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.GreadMajorClassDao"
	import="com.gdpi.attendance.form.GreadMajorClassForm"
	import="com.gdpi.attendance.form.MajorForm" 
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
	         <td>  年级<select name="Grade">
          <option value="2011">2011</option>
          <option value="2012">2012</option>
          <option value="2013">2013</option>
          <option value="2012">2014</option>
          <option value="2015">2015</option>
          <option value="2016">2016</option>
          <option value="2017">2017</option>
          <option value="2018">2018</option>
          <option value="2019">2019</option>
          <option value="2020">2020</option>
        </select>
        
		专业<SELECT NAME="Major" onChange="getClas()">   
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
	      <form action="AdminServlet?method=1&sign=1&add=3" method="post" > 
	       <tr>
	           <td>
	                <font color="red"><b>新增一个新班：</b></font>
	           </td>
	      </tr>     
		  <tr>
		     <td>
		       年级<select name="Grade">
          <option value="2011">2011</option>
          <option value="2012">2012</option>
          <option value="2013">2013</option>
          <option value="2012">2014</option>
          <option value="2015">2015</option>
          <option value="2016">2016</option>
          <option value="2017">2017</option>
          <option value="2018">2018</option>
          <option value="2019">2019</option>
          <option value="2020">2020</option>
        </select>   
		   专业 <SELECT NAME="Major" onChange="getCity()">   
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
