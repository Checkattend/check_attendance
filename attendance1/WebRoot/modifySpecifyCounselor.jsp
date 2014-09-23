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
		<title>修改制定辅导员对应年级</title>
	</head>
	<%	
	        TeacherDao teacherDao = new TeacherDao();
	        List<GradeForm> gradelist= new ArrayList();
	        gradelist = teacherDao.getGrade();
	        
	        SpecifyCounselorDao specifyCounselorDao = new SpecifyCounselorDao();
	        List<TeacherForm> SpecifyCounselorlist= new ArrayList();
	        SpecifyCounselorlist =  specifyCounselorDao.getCounselor();
	        
	        List<Instructor_gradeForm> instructor_gradeFormlist= new ArrayList();
	        instructor_gradeFormlist =  specifyCounselorDao.getAllCounselor();
	
	     Instructor_gradeForm instructor_gradeForm = new Instructor_gradeForm();
		 instructor_gradeForm = (Instructor_gradeForm)session.getAttribute("instructor_gradeForm");	
	 %>

	<body>
	<h3>修改制定辅导员对应年级</h3>
    <table>
    <thead>
    </thead>
    <tbody>
          <form action="AdminServlet?method=13&sign=18&modify=2&gradeid=<%=instructor_gradeForm.getGradeId()%>&teacherid=<%=instructor_gradeForm.getId()%>" method="post">
          <tr>  
		  	   <tr>
             <td>
                  年级<SELECT NAME="Grade"> 
        <option value="<%=instructor_gradeForm.getGradename()%>"><%=instructor_gradeForm.getGradename()%></option>            
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
             </td>
             <td>
             <td>
                  辅导员<SELECT NAME="Counselor"> 
        <option value="<%=instructor_gradeForm.getTeachername()%>"><%=instructor_gradeForm.getTeachername()%></option>  
		<%
			for (int i = 0; i < SpecifyCounselorlist.size(); ++i) {
			TeacherForm teacherForm = new TeacherForm();
			teacherForm= SpecifyCounselorlist.get(i);
			//System.out.println(gradelist.size());
		%>
		<option value="<%=teacherForm.getTeachername()%>"><%=teacherForm.getTeachername()%></option>
		<%
			}
		%>
		</SELECT>

             </td>
             <td>
                   <input name="确定" type="submit" value="确定"> 
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
