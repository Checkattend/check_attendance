<%@ page language="java" import="java.util.*"
	import="com.gdpi.attendance.dao.*"
	import="com.gdpi.attendance.form.*"
	import="java.util.List"
	import="java.util.ArrayList" pageEncoding="utf-8"%>

<html>
	<head>
		<title>添加班级所学专业课及专业</title>
		<%
		     //获取班级-专业课及对应任课老师
			 List<Class_subject_teacherForm>  Class_subject_teacherFormList = new ArrayList();
			 Class_subject_teacherFormList = (ArrayList)session.getAttribute("class_subject_teacherForm"); 
			 String classid = (String)session.getAttribute("class"); 
			 //获取单个班级
			 GreadMajorClassDao greadMajorClassDao = new GreadMajorClassDao();
			 GreadMajorClassForm  greadMajorClassForm = greadMajorClassDao.getclas(classid);
		%>
		<script type="text/javascript">			
		function checkAll(elementsA,elementsB){
				var len = elementsA;
			if(len.length > 0)
				{
				   for(i=0;i<len.length;i++)
				   {
					elementsA[i].checked = true;
				   }
				   if(elementsB.checked ==false)
				   {
				     for(j=0;j<len.length;j++)
				     {
				       elementsA[j].checked = false;
				     }
			      }
		       }
			 else
			 {
				len.checked = true;
		        if(elementsB.checked == false)
		        {
			      len.checked = false;
				}
			 }
	   }
		   
		</script>
	</head>

	<body>
          <table>
           <h3>为<%=greadMajorClassForm.getClasname()%>(<%=greadMajorClassForm.getGradename()%>,<%=greadMajorClassForm.getMajorname() %>)添加新课程及对应任课老师</h3>
             <form name="myForm" action="AdminServlet?method=21&sign=29&add=2&clasid=<%=classid %>" method="post">
            <%
               for (int i = 0; i < Class_subject_teacherFormList.size()&&Class_subject_teacherFormList!=null; ++i) {
						Class_subject_teacherForm class_subject_teacherForm = new Class_subject_teacherForm();
						class_subject_teacherForm = Class_subject_teacherFormList.get(i);
						
			 %>
			 <input type="checkbox" name="subject" value="<%=class_subject_teacherForm.getSubjectid() %>" ><%=class_subject_teacherForm.getSubjectname() %>(任课老师：<%=class_subject_teacherForm.getTeachername() %>)<br>  
			 <%
			        }
             %>
             <p>
			<input type="checkbox" name="chkall"  onClick="checkAll(this.form.subject,this.form.chkall)">全选<br>
			</p>
			<input name="button" type="submit" "添加">
			<input type="reset" value="重置">
			<a href="AdminServlet?method=18&sign=24&clas=<%=classid%>">返回</a>
		</form>
          
          </table>
	</body>
</html>
