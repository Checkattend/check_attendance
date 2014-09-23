<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.*"
	import="com.gdpi.attendance.form.*"
	import="com.gdpi.attendance.form.SubjectForm" import="java.util.List"
	import="java.util.ArrayList" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/pages/commons/header.jsp" %>
<%
	        GreadMajorClassDao greadMajorClassDao = new GreadMajorClassDao();
			List<MajorForm> majorList = new ArrayList();
			List<GreadMajorClassForm> greadMajorClassList = new ArrayList();
			majorList=greadMajorClassDao.AllMajorForm();
			greadMajorClassList=greadMajorClassDao.QueryNumberOfLTLL();
						
			TeacherDao teacherDao = new TeacherDao();
	        List<GradeForm> gradelist= new ArrayList();
	        gradelist = teacherDao.getGrade();
	        
	        List<CurriculumForm> curriculumFormList = new ArrayList();
	        if(session.getAttribute("curriculumForm")!=null)
	        curriculumFormList = (ArrayList)session.getAttribute("curriculumForm");
	
	 %>
	 
	 <script type="text/javascript">
	       function start()
	       {
	          if(<%=curriculumFormList.size()%>!=0)
	          {
	             <% 
			       for (int i = 0; i < curriculumFormList.size(); ++i) {
				     CurriculumForm curriculumForm = new CurriculumForm();
					 curriculumForm = curriculumFormList.get(i);
	             %> 
	             var day = "<%=curriculumForm.getWeekdayname()%>";
	             var number = "<%=curriculumForm.getNumbername()%>";
		               if(number==1)
		               { 
		                   if(day=="星期一")
		                   {
				                var obj = document.getElementById('M1');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
		                   if(day=="星期二")
		                   {
				                var obj = document.getElementById('T1');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期三")
		                   {
				                var obj = document.getElementById('W1');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期四")
		                   {
				                var obj = document.getElementById('Th1');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期五")
		                   {
				                var obj = document.getElementById('F1');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
					   }
					    if(number==3)
		               { 
		                   if(day=="星期一")
		                   {
				                var obj = document.getElementById('M3');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
		                   if(day=="星期二")
		                   {
				                var obj = document.getElementById('T3');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期三")
		                   {
				                var obj = document.getElementById('W3');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期四")
		                   {
				                var obj = document.getElementById('Th3');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期五")
		                   {
				                var obj = document.getElementById('F3');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
					   }
					    if(number==5)
		               { 
		                   if(day=="星期一")
		                   {
				                var obj = document.getElementById('M5');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font></p><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
		                   if(day=="星期二")
		                   {
				                var obj = document.getElementById('T5');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期三")
		                   {
				                var obj = document.getElementById('W5');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期四")
		                   {
				                var obj = document.getElementById('Th5');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期五")
		                   {
				                var obj = document.getElementById('F5');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
					   }
					    if(number==7)
		               { 
		                   if(day=="星期一")
		                   {
				                var obj = document.getElementById('M7');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
		                   if(day=="星期二")
		                   {
				                var obj = document.getElementById('T7');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期三")
		                   {
				                var obj = document.getElementById('W7');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期四")
		                   {
				                var obj = document.getElementById('Th7');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期五")
		                   {
				                var obj = document.getElementById('F7');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
					   }
					   
					    if(number==9)
		               { 
		                   if(day=="星期一")
		                   {
				                var obj = document.getElementById('M9');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
		                   if(day=="星期二")
		                   {
				                var obj = document.getElementById('T9');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期三")
		                   {
				                var obj = document.getElementById('W9');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期四")
		                   {
				                var obj = document.getElementById('Th9');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
						    if(day=="星期五")
		                   {
				                var obj = document.getElementById('F9');
								obj.innerHTML='<%=curriculumForm.getSubjeckname()%><p> <font color="red"><%=curriculumForm.getTeachername()%></font></p><p> <font color="red"><%=curriculumForm.getPlace()%></font><p> <font color="red"><%=curriculumForm.getWeekname()%></font>';
						   }
					   }
					   
				<%
				   }	
				%>
	          }
	       }
	 
	 </script>
</head>
<body onload="start()">

	      <tr>
     <td>
         <font color="red"><h2>按年级-专业-班级查询课程表</h2></font>
         <form action="CurriculumServlet?method=0&sign=15" method="post" name="form1">
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
	指定辅导员：列柳旭 <a href="">修改</a>
	<tr>
	<table width="750" border="1" align="center" cellpadding="0" cellspacing="0">	
  <tr>
    <td width="86" align="center" valign="middle">节数\星期</td>
    <td width="103" align="center" valign="middle">星期一</td>
    <td width="98" align="center" valign="middle">星期二</td>
    <td width="93" align="center" valign="middle">星期三</td>
    <td width="93" align="center" valign="middle">星期四</td>
    <td width="88" align="center" valign="middle">星期五</td>
    <td width="88" align="center" valign="middle">星期六</td>
    <td width="83" align="center" valign="middle">星期天</td>
  </tr>
  <tr>
    <td height="32" align="center" valign="middle">1</td>
    <td rowspan="2" align="center" valign="middle" id="M1">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="T1">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="W1">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="Th1">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="F1">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="S1">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="Sun1">&nbsp;</td>
  </tr>
  <tr>
    <td height="39" align="center" valign="middle">2</td>
  </tr>
  <tr>
    <td height="40" align="center" valign="middle">3</td>
    <td rowspan="2" align="center" valign="middle" id="M3">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="T3">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="W3">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="Th3">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="F3">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="S3">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="Sun3">&nbsp;</td>
  </tr>
  <tr>
    <td height="37" align="center" valign="middle">4</td>
  </tr>
  <tr>
    <td colspan="8" align="center" valign="middle">午休</td>
    </tr>
  <tr>
    <td height="41" align="center" valign="middle">5</td>
    <td rowspan="2" align="center" valign="middle" id="M5">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="T5">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="W5">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="Th5">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="F5">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="S5">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="Sun5">&nbsp;</td>
  </tr>
  <tr>
    <td height="41" align="center" valign="middle">6</td>
  </tr>
  <tr>
    <td height="36" align="center" valign="middle">7</td>
    <td rowspan="2" align="center" valign="middle" id="M7">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="T7">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="W7">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="Th7">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="F7">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="S7">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="Sun7">&nbsp;</td>
  </tr>
  <tr>
    <td height="43" align="center" valign="middle">8</td>
  </tr>
  <tr>
    <td colspan="8" align="center" valign="middle">晚修</td>
    </tr>
  <tr>
    <td height="35" align="center" valign="middle">9</td>
    <td rowspan="2" align="center" valign="middle" id="M9">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="T9">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="W9">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="Th9">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="F9">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="S9">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle" id="Sun9">&nbsp;</td>
  </tr>
  <tr>
    <td height="38" align="center" valign="middle">10</td>
  </tr>
</table>

	</tr>
	</form>
</body>
</html>