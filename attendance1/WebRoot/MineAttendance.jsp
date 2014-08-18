<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>我的考勤</title>
    <%@ include file="/header.jsp" %>
    <script type="text/javascript">
    	var grid;
    	$(function() {
    		grid = $("#grid").ligerGrid({
    			width: '100%',
    			height: '100%',
    			root: "list",
    			columns: [
    				{display:"学生", name:"studentname", type:"text"},
    				{display:"科任老师", name:"teachername", type:"text"},
    				{display:"科目", name:"subjectname", type:"text"},
    				{display:"课时", name:"number", type:"text"},
    				{display:"请假", name:"leave", type:"text"},
    				{display:"旷课", name:"truancy", type:"text"},
    				{display:"迟到", name:"late", type:"text"},
    				{display:"早退", name:"leaveEarly", type:"text"}
    			],
    			url:'<%=request.getContextPath()%>/student/QueryNumberOfLTLL',
    			pageSizeOptions: [10, 30, 50, 70, 90],	//每页显示数量
    			pageSize: 30,	//初始显示数量
    			checkbox: true,	//复选框显示
    			rownumbers: true	//行号
    		});
    	});
    </script>
  </head>
  
  <body>
    <div id="grid"></div>
  </body>
</html>
