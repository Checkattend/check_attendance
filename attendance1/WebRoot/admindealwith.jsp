<%@page contentType="text/html;charset=UTF-8"  language="java" import="java.sql.*" errorPage=""%>
<%
   Integer sign=Integer.valueOf(request.getParameter("sign"));
   if(sign==0){//登陆进管理员主页面，跳转到Gread-Major-class.jsp
	   session.setAttribute("greadMajorClassForm",request.getAttribute("greadMajorClassForm"));
	   out.println("<script language=javascript>window.location.href='Gread-Major-class.jsp';</script>");
   }else if(sign==1)//添加新增年级-班级-班级信息，跳转到Gread-Major-class.jsp
   {
      if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Add Success!!');window.location.href='AdminServlet?method=0&sign=0';</script>");
	   }
   }else if(sign==2)//返回一个greadMajorClassForm对象到modifyGradeMajorClas.jsp
   {
       session.setAttribute("greadMajorClassForm",request.getAttribute("greadMajorClassForm"));
	   out.println("<script language=javascript>window.location.href='modifyGradeMajorClas.jsp';</script>");  
   }else if(sign==3)//修改完年级-班级-班级信息，跳转到Gread-Major-class.jsp
   {
      if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('modify Success!!');window.location.href='AdminServlet?method=0&sign=0';</script>");
	   }
   }else if(sign==4)//删除年级-班级-班级信息，跳转到Gread-Major-class.jsp
   {
      if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('delete Success!!');window.location.href='AdminServlet?method=0&sign=0';</script>");
	   }
   }else if(sign==5)//查询班级学生信息,跳转到Allstudents.jsp
   {
      session.setAttribute("allStudentForm",request.getAttribute("allStudentForm"));
	   out.println("<script language=javascript>window.location.href='Allstudents.jsp';</script>");
   }else if(sign==6)//添加学生信息，跳转到ManageAllStudents.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Add New Student Success!!');window.location.href='ManageAllStudents.jsp';</script>");
	   }
   }else if(sign==7)//返回一个allStudentForm对象到modifyStudent.jsp
   {
       session.setAttribute("allStudentForm",request.getAttribute("allStudentForm"));
	   out.println("<script language=javascript>window.location.href='modifyStudent.jsp';</script>"); 
   }else if(sign==8)//修改完学生信息,跳转到ManageAllStudents.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Modify Student Success!!');window.location.href='ManageAllStudents.jsp';</script>");
	   }
   }else if(sign==9)//删除学生信息,跳转到ManageAllStudents.jsp
   {
      if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Delete Student Success!!');window.location.href='ManageAllStudents.jsp';</script>");
	   }
   }else if(sign==10)//返回全部教师信息,跳转到Allteachers.jsp
   {
       session.setAttribute("teacherForm",request.getAttribute("teacherForm"));
	   out.println("<script language=javascript>window.location.href='Allteachers.jsp';</script>"); 
   }else if(sign==11)//新增教师，成功就跳转到Allteachers.jsp，否则停留在原页面
   {
       if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('add new teacher Success!!');window.location.href='AdminServlet?method=8&sign=10';</script>");
	   }
   }else if(sign==12)//返回一个teacherForm对象到modifyStudent.jsp
   {
       session.setAttribute("teacherForm",request.getAttribute("teacherForm"));
	   out.println("<script language=javascript>window.location.href='modifyTeacher.jsp';</script>"); 
   }else if(sign==13)//修改教师信息，成功返回到Allteachers.jsp
   {
      if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Modify Teacher Success!!');window.location.href='AdminServlet?method=8&sign=10';</script>");
	   }
   }else if(sign==14)//删除教师信息，成功返回到Allteachers.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Delete Teacher Success!!');window.location.href='AdminServlet?method=8&sign=10';</script>");
	   }
   }else if(sign==15)//从CurriculumServlet传过来curriculumForm对象，显示课程表，返回到adminCurriculum.jsp页面
   {
        session.setAttribute("curriculumForm",request.getAttribute("curriculumForm"));
        out.println("<script language=javascript>window.location.href='adminCurriculum.jsp';</script>"); 
   }else if(sign==16)//指定辅导员，指定成功返回到SpecifyCounselor.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Success!!');window.location.href='SpecifyCounselor.jsp';</script>");
	   }
   }else if(sign==17)//返回一个instructor_gradeForm对象
   {
        session.setAttribute("instructor_gradeForm",request.getAttribute("instructor_gradeForm"));
	    out.println("<script language=javascript>window.location.href='modifySpecifyCounselor.jsp';</script>"); 
   }else if(sign==18)//修改指定辅导员，成功返回到SpecifyCounselor.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Success!!');window.location.href='SpecifyCounselor.jsp';</script>");
	   }
   }else if(sign==19)//删除指定辅导员，成功返回到SpecifyCounselor.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Delete SpecifyCounselor Success!!');window.location.href='SpecifyCounselor.jsp';</script>");
	   }
   }else if(sign==20)//指定教师，指定成功返回到SpecifyClassTeacher.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Success!!');window.location.href='SpecifyClassTeacher.jsp';</script>");
	   }
   }else if(sign==21)//返回一个class_teacherForm对象,跳转到modifySpecifyClassTeacher.jsp
   {
        session.setAttribute("class_teacherForm",request.getAttribute("class_teacherForm"));
	    out.println("<script language=javascript>window.location.href='modifySpecifyClassTeacher.jsp';</script>"); 
   }else if(sign==22)//修改指定教师所教班级，成功返回到SpecifyClassTeacher.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Success!!');window.location.href='SpecifyClassTeacher.jsp';</script>");
	   }
   }else if(sign==23)//删除指定教师所教班级，成功返回到SpecifyClassTeacher.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Delete SpecifyClassTeacher Success!!');window.location.href='SpecifyClassTeacher.jsp';</script>");
	   }
   }else if(sign==24)//返回一个class_teacherForm对象,跳转到modifySpecifyClassTeacher.jsp
   {
        session.setAttribute("commit","commit");
        session.setAttribute("submit","submit");
        session.setAttribute("class",request.getAttribute("class"));
        session.setAttribute("class_subject_teacherForm",request.getAttribute("class_subject_teacherForm"));
	    out.println("<script language=javascript>window.location.href='SpecifyClassSubject.jsp';</script>"); 
   }else if(sign==25)//返回一个class_subject_teacherForm对象,跳转到modifySpecifyClassSubject.jsp
   {
        session.setAttribute("class_subject_teacherForm",request.getAttribute("class_subject_teacherForm"));
	    out.println("<script language=javascript>window.location.href='modifySpecifyClassSubject.jsp';</script>"); 
   }else if(sign==26)//修改指定班级所学专业课及任课老师，成功返回到SpecifyClassSubject.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Success!!');window.location.href='AdminServlet?method=18&sign=24&clas="+request.getAttribute("clasOld")+"';</script>");
	   }
   }else if(sign==27)//删除指定班级所学专业课及任课老师，成功返回到SpecifyClassSubject.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Delete SpecifyClassTeacher Success!!');window.location.href='AdminServlet?method=18&sign=24&clas="+request.getAttribute("classid")+"';</script>");
	   }
   }else if(sign==28)//返回一个class_subject_teacherForm对象,跳转到addSpecifyClassSubject.jsp
   {
        session.setAttribute("class_subject_teacherForm",request.getAttribute("class_subject_teacherForm"));
        session.setAttribute("clas",request.getAttribute("clas"));
	    out.println("<script language=javascript>window.location.href='addSpecifyClassSubject.jsp';</script>"); 
   }else if(sign==29)//删除指定班级所学专业课及任课老师，成功返回到SpecifyClassSubject.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Success!!');window.location.href='AdminServlet?method=18&sign=24&clas="+request.getAttribute("classid")+"';</script>");
	   }
   }else if(sign==30)//添加专业课，指定成功返回到ManageSubject.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Success!!');window.location.href='ManageSubject.jsp';</script>");
	   }
   }else if(sign==31)//返回一个subjectForm对象,跳转到modifySubject.jsp
   {
        session.setAttribute("subjectForm",request.getAttribute("subjectForm"));
	    out.println("<script language=javascript>window.location.href='modifySubject.jsp';</script>"); 
   }else if(sign==32)//修改专业课，指定成功返回到ManageSubject.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Success!!');window.location.href='ManageSubject.jsp';</script>");
	   }
   }else if(sign==33)//删除专业课，删除成功返回到ManageSubject.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Success!!');window.location.href='ManageSubject.jsp';</script>");
	   }
   }else if(sign==34)//指定教师所教专业课，成功返回到SpecifyTeacherSubject.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Success!!');window.location.href='SpecifyTeacherSubject.jsp';</script>");
	   }
   }else if(sign==35)//返回一个class_subject_teacherForm对象,跳转到modifySpecifyTeacherSubject.jsp
   {
        session.setAttribute("class_subject_teacherForm",request.getAttribute("class_subject_teacherForm"));
	    out.println("<script language=javascript>window.location.href='modifySpecifyTeacherSubject.jsp';</script>"); 
   }else if(sign==36)//修改指定教师所教专业课，成功返回到SpecifyTeacherSubject.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Success!!');window.location.href='SpecifyTeacherSubject.jsp';</script>");
	   }
   }else if(sign==37)//删除指定教师所教专业课，成功返回到SpecifyTeacherSubject.jsp
   {
        if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      out.println("<script language=javascript>alert('Delete SpecifyClassTeacher Success!!');window.location.href='SpecifyTeacherSubject.jsp';</script>");
	   }
   }
%>
