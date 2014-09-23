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
	        
	        CurriculumDao curriculumDao = new CurriculumDao();
	        List<SubjectForm> subjectFormList= new ArrayList();
	        subjectFormList = curriculumDao.getSubjectForm();
	        
	        List<TeacherForm> teacherFormList= new ArrayList();
	        teacherFormList = curriculumDao.getTeacherForm();
	 %>
	 <script type="text/javascript">
	    function change()
	    {
	        var obj = 
			document.getElementById('subject');
			obj.style.display='block';
			var obj = 
			document.getElementById('teacher');
			obj.style.display='block';
	        var obj = 
			document.getElementById('week');
			obj.type='display';
			 var obj = 
			document.getElementById('place');
			obj.type='display';
			 var obj = 
			document.getElementById('hai');
			obj.type='hidden';
	    }
	    
	    function getgrade()
	    {
	         alert("123");
	    }
	 </script>
	<body>
    <table>
    <tbody cellspacing="1" cellpadding="0" width="100%" bgcolor="#5e85b1"
			border="0"  align="left">	
	   <tr>
		<td>
         <font color="red">cg添加课程表</font>
          <form action="AdminServlet?method=5&sign=6" method="post">
              年级<SELECT NAME="Grade" id="grade" onchange="getgrade()">   
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
	    专业<SELECT NAME="Major" id="major">   
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
		班级<SELECT NAME="Clas" id="clas">   
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
        
	    <tr>
		  <table width="750" border="1" align="left" cellpadding="0" cellspacing="0">	
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
			    <td rowspan="2" align="center" valign="middle" id="M1"><input id="hai" name="hai" type="button" value="编辑" onclick="change()"/>
			    
			    <SELECT NAME="subject" style="display:none" id="subject">   
		        <OPTION VALUE="0">请选择专业课</OPTION>
		       <%
					for (int i = 0; i < subjectFormList.size(); ++i) {
					SubjectForm subjectForm = new SubjectForm();
					subjectForm = subjectFormList.get(i);
					//System.out.println(gradelist.size());
				%>
				<option value="<%=subjectForm.getSubjectname()%>"><%=subjectForm.getSubjectname()%></option>
				<%
					}
				%>
		        </SELECT>
		        	        
		        <SELECT NAME="teacher" style="display:none" id="teacher">   
		        <OPTION VALUE="0">选择专业老师</OPTION>
		         <%
					for (int i = 0; i < teacherFormList.size(); ++i) {
					TeacherForm teacherForm = new TeacherForm();
					teacherForm = teacherFormList.get(i);
					//System.out.println(gradelist.size());
				%>
				<option value="<%=teacherForm.getTeachername()%>"><%=teacherForm.getTeachername()%></option>
				<%
					}
				%>
		        </SELECT>
			    <input id="week" name="week" type="hidden" size="8" value="请填写周数">
			    <input id="place" name="place" type="hidden" size="8" value="请填写教室">
			    </td>
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
         </td> 
         </tr>
    </tbody>
    <tfoot>
         
    </tfoot>
    </table>
    
	</body>
</html>
