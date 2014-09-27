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
		<title>修改教师所教班级</title>
	</head>
	<%	
	      
	      //
	      SpecifyClassTeacherDao specifyClassTeacherDao = new SpecifyClassTeacherDao();
	      List<TeacherForm> SpecifyTeacherlist= new ArrayList();
	      SpecifyTeacherlist =  specifyClassTeacherDao.getTeacher();	
	      
	      //获取班级列表
	      GreadMajorClassDao greadMajorClassDao = new GreadMajorClassDao();
		  List<GreadMajorClassForm> clasFormList = new ArrayList();
		  clasFormList = greadMajorClassDao.getClasForm();
		  
		  //获取专业课列表
	        ClassSubjectTeacherDao classSubjectTeacherDao = new ClassSubjectTeacherDao();
	        List<Class_subject_teacherForm>  SubjectSpecifyTeacherList = new ArrayList();
	        SubjectSpecifyTeacherList = classSubjectTeacherDao.getAllSubjectSpecifyTeacher();
	      //获取班级对应专业课任课老师
	      Class_subject_teacherForm class_subject_teacherForm = (Class_subject_teacherForm)session.getAttribute("class_subject_teacherForm");
	       
	 %>

	<body>
	<h3>修改班级所学专业</h3>
    <table>
    <thead>
    </thead>
    <tbody>
          <form action="AdminServlet?method=19&sign=26&modify=2&clasid=<%=class_subject_teacherForm.getClasId()%>&subjectid=<%=class_subject_teacherForm.getSubjectid() %>" method="post">
          <tr>  
		  	   <tr>
             <td>
         班级<SELECT NAME="clas">    
         <option value="<%=class_subject_teacherForm.getClasId()%>"><%=class_subject_teacherForm.getClasname()%>(<%=class_subject_teacherForm.getGradename()%>,<%=class_subject_teacherForm.getMajorname() %>)</option>
         
		</SELECT>
		
           专业课<SELECT NAME="subject"> 
        <option value="<%=class_subject_teacherForm.getSubjectid()%>"><%=class_subject_teacherForm.getSubjectname()%>(<%=class_subject_teacherForm.getTeachername()%>,<%=class_subject_teacherForm.getAccount() %>)</option>    
		<%
			for (int i = 0; i < SubjectSpecifyTeacherList.size(); ++i) {
			Class_subject_teacherForm class_subject_teacherForm1 = new Class_subject_teacherForm();
			class_subject_teacherForm1 = SubjectSpecifyTeacherList.get(i);
			//System.out.println(gradelist.size());
		%>
		<option value="<%=class_subject_teacherForm1.getSubjectid() %>"><%=class_subject_teacherForm1.getSubjectname()%>(<%=class_subject_teacherForm1.getTeachername() %>,<%=class_subject_teacherForm1.getAccount() %>)</option>
		<%
			}
		%>
		</SELECT>
             </td>
             <td>
                   <input name="button" type="submit" value="确定"> 
                   <a href="AdminServlet?method=18&sign=24&clas=<%=class_subject_teacherForm.getClasId()%>">返回</a>
             </td>
             </tr>
          </tr>
          </tr>
         </form> 
    </tbody>
    <tfoot>
         
    </tfoot>
    </table>
	</body>
</html>
