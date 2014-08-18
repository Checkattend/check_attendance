<%@page contentType="text/html;charset=UTF-8"  language="java" import="java.sql.*" errorPage=""%>
<%
   Integer sign=Integer.valueOf(request.getParameter("sign"));
   String userType=request.getParameter("userType");
   //out.println(userType);
   if(sign==0){
	   if(request.getAttribute("information")!=null){
	      String information=(String)request.getAttribute("information");
	      out.println("<script language=javascript>alert('"+information+"');history.go(-1);</script>");
	   }else{
	      session.setAttribute("form",request.getAttribute("form"));
	      if(userType.equals("0"))
	      {
	      	 out.println("<script language=javascript>alert('Login Success!!');window.location.href='Teacher_main.jsp';</script>");
	      }
	      if(userType.equals("2"))
	      {
	      out.println("<script language=javascript>alert('Login Success!!');window.location.href='Teacher_main.jsp';</script>");
	      }
	     if(userType.equals("4"))
	      {
	          out.println("<script language=javascript>alert('Login Success!!');window.location.href='admin.jsp';</script>");
	      }
	      
	   }
   }
  /* if(sign==1){
      String result=(String)request.getAttribute("result");
      if(result.equals("success")){
         session.setAttribute("form",request.getAttribute("form"));
         out.println("<script language=javascript>alert('用户注册成功！');window.location.href='head_main.jsp';</script>");
      }
      if(result.equals("fail")){
         out.println("<script language=javascript>alert('用户注册失败！')；history.go(-1);</script>");
      }  } 
      if (sign == 2) {
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
*/
      

   
%>