<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-
transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>主页</title>
     <%@ include file="/pages/commons/header.jsp" %>
        <script type="text/javascript"> 
        	var data = [
            		{ID:1, TEXT:"我的信息", PID:0},
            		{ID:11, TEXT:"个人信息", PID:1, URL:"/pages/carmgr/user.jsp"},
            		{ID:12, TEXT:"查看考勤", PID:1, URL:"/StudentServlet?method=0&sign=0"}
            	];
            $(function ()
            { 
                $("#layout1").ligerLayout({leftWidth:220}); 
                $("#tree1").ligerTree({
                	checkbox: false,
                	data:data,
                	//url:"<!--<%=request.getContextPath()%>-->///user/findMenu",
                	nodeWidth:120,
                	idFieldName :'ID',
                    parentIDFieldName :'PID',
                    textFieldName:"TEXT",
                    onSelect:function(node) {
                    	if (node.data.URL) {
                    		var url = node.data.URL
                    		if (url.indexOf("?") > 0) {
                    			url += "&_t=" + new Date();
                    		} else {
                    			url += "?_t" + new Date();
                    		}
                    		$("#centerFrame").attr("src", "<%=request.getContextPath()%>" + node.data.URL);
                    	}
                    }
                });
            });
            
     </script> 
    <style type="text/css">
        #layout1{  width:100%;  height:400px;
                   margin:0; padding:0;} 
		body,html{height:100%;}
    body{ padding:0px; margin:0;   overflow:hidden;}  
    .l-link{ display:block; height:26px; line-height:26px; padding-left:10px; text-decoration:underline; color:#333;}
    .l-link2{text-decoration:underline; color:white; margin-left:2px;margin-right:2px;}
    .l-layout-top{background:#102A49; color:White;}
    .l-layout-bottom{ background:#E5EDEF; text-align:center;}
    #pageloading{position:absolute; left:0px; top:0px; background:white url('<%=request.getContextPath()%>/lib/images/loading.gif') no-repeat center; width:100%; height:100%;z-index:99999;}
    .l-link{ display:block; line-height:22px; height:22px; padding-left:16px;border:1px solid white; margin:4px;}
    .l-link-over{ background:#FFEEAC; border:1px solid #DB9F00;} 
    .l-winbar{ background:#2B5A76; height:30px; position:absolute; left:0px; bottom:0px; width:100%; z-index:99999;}
    .space{ color:#E7E7E7;}
    /* 顶部 */ 
    .l-topmenu{ margin:0; padding:0; height:31px; line-height:31px; background:url('<%=request.getContextPath()%>/lib/images/top.jpg') repeat-x bottom;  position:relative; border-top:1px solid #1D438B;  }
    .l-topmenu-logo{ color:#E7E7E7; padding-left:35px; line-height:26px;background:url('<%=request.getContextPath()%>/lib/images/topicon.gif') no-repeat 10px 5px;}
    .l-topmenu-welcome{  position:absolute; height:24px; line-height:24px;  right:30px; top:2px;color:#070A0C;}
    .l-topmenu-welcome a{ color:#E7E7E7; text-decoration:underline} 
     .body-gray2014 #framecenter{
        margin-top:3px;
    }
      .viewsourcelink {
         background:#B3D9F7;  display:block; position:absolute; right:10px; top:3px; padding:6px 4px; color:#333; text-decoration:underline;
    }
    .viewsourcelink-over {
        background:#81C0F2;
    }
    .l-topmenu-welcome label {color:white;
    }
    #skinSelect {
        margin-right: 6px;
    }         
    </style>
    
    </head>
    <body style="padding:5px">
<div id="topmenu" class="l-topmenu">
    <div class="l-topmenu-logo">欢迎使用计算机系学生考勤管理系统</div>
    <div class="l-topmenu-welcome">
        <a href="#" class="l-link2">广东理工职业学院</a>
        <span class="space">|</span>
        <a href="#" class="l-link2" target="_blank">修改密码</a> 
        <span class="space">|</span>
         <a href="#index.jsp" class="l-link2" target="_blank">注销</a>
    </div> 
</div>
        <div id="layout1">
             <div  position="left">
             	<ul id="tree1" style="margin-top:3px;">
             </div>
            <div position="center" title="标题">
            	<iframe src="" name="centerFrame" id="centerFrame" frameborder="0" height="100%" width="100%"></iframe>
            </div>
            <!-- <div position="top"></div> -->
            <!-- <div position="bottom"></div> -->
        </div> 
           
     <div style="display:none;">
     
</div>
</body>
    </html>