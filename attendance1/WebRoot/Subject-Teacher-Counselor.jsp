<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/pages/commons/header.jsp" %>
<script type="text/javascript">
	var grid;
	$(function(){
		grid = $("#maingrid").ligerGrid({
			columns:[
			        {display:"subject",name:"SUBJECT"}, 
			        {display:"teacher",name:"TEACHER"},
			        {display:"counselor",name:"COUNSELOR"}
			         ],
			         root:"list",height:"100%",
			         url:'<%=request.getContextPath()%>/user/pageJson',
	            	pageSize:30 ,rownumbers:true,
	                toolbar: { items: [
	                { text: '添加', click: toAdd, icon: 'add' },
	                { line: true },
	                { text: '修改', click: toUpdate, icon: 'modify' },
	                { line: true },
	                { text: '删除', click: toDelete, img: '<%=request.getContextPath()%>/lib/ligerUI/skins/icons/delete.gif' },
	                { line: true }
	                ]
	                },
	                checkbox: true	
		});	
		 $("#pageloading").hide();
	});
	
	function clickItem(){
		alert("11");
	}
	
	var addDialog;
	function toAdd(){
		addDialog=$.ligerDialog.open({width:450,height:350,url: 'user-New.jsp',title:"增加"});
	}
	
	function toDelete(){
		var selected = grid.getSelectedRows();
		if(selected.length==1){
			var id = grid.getSelectedRow().ID;
			$.ligerDialog.confirm('确定删除吗？', function (yes) {
				if(yes){
	        		$.ajax({
	        			url:'<%=request.getContextPath()%>/user/doDelete',
	        			type:"POST",
	        			data:{"user.id":id},
	        			dataType:"json",
	        			success:function(data) {
	        				$.ligerDialog.success(data.result);
	        				grid.reload();
	        			}
	        		});
				}
        	});
		}else{
			$.ligerDialog.error("每次只能删除一条");
		}
	}
	
	var updateDialog
	function toUpdate(){
		var selected = grid.getSelectedRows();
		if(selected.length==1){
			var id = grid.getSelectedRow().ID;
			updateDialog=$.ligerDialog.open({width:450,height:350,url: 'user-Update.jsp?id='+id,title:"修改"});
		}else{
			$.ligerDialog.error("每次只能修改一条");
		}
	}
	
	var viewDialog;
	function toView(){
		var selected = grid.getSelectedRows();
		if(selected.length==1){
			var id = grid.getSelectedRow().ID;
			viewDialog=$.ligerDialog.open({url: 'userView.jsp?id='+id,title:"查看"});
		}else{
			$.ligerDialog.error("每次只能查看一条");
		}
	}

</script>

</head>
<body>
	<div class="l-loading" style="display:block" id="pageloading"></div>
 	<div class="l-clear"></div>
	<div id="maingrid"></div>
	<div style="display:none;"></div>
	
</body>
</html>