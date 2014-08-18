<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
  <title>登录页面</title>
  <style type="text/css">
</style>
  <script>
				function valiusername(){
					
					//依据id找到对应的节点
					var obj = 
					document.getElementById('account');
					var obj2 = 
					document.getElementById('username_msg');
					obj2.innerHTML='';
															
					if(obj.value.length == 0){
						//innerHTML:标签之间的html代码		
						obj2.innerHTML='账号必须填写';
						return false;
					}
					return true;
				}
				
				function valipwd(){
					
					//依据id找到对应的节点
					var obj = 
					document.getElementById('password');
					var obj2 = 
					document.getElementById('pwd_msg');
					obj2.innerHTML='';
					if(obj.value.length == 0){
						//innerHTML:标签之间的html代码		
						obj2.innerHTML='密码必须填写';
						return false;
					}
					return true;
				}
				
				function valiform(){
					return valiusername()&& valipwd();
				}
		</script>	
  </head>
  <body background="images/login/body_background.jpg" >
<table width="605" border="0" cellspacing="0" cellpadding="0" height="512" align="center">
  <tr>
    <td width="961" height="72" background="images/login/top.jpg"></td>
  </tr>
  <tr>
    <td><table width="959" height="409" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="297" height="49">&nbsp;</td>
    <td width="662"  background="images/login/kaoqin2.jpg"></td>
  </tr>
  <tr>
    <td height="360">&nbsp;</td>
    <td>
    
    <form id="form1" name="form1" method="post" action="LoginServlet?method=0&sign=0"  onSubmit="return valiform();">
    <table width="519" height="162" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="76">&nbsp;&nbsp;&nbsp;用户： </td>
    <td width="443">&nbsp;&nbsp;&nbsp; <input name="account" type="text" size="20" maxlength="11" id="account" onBlur="valiusername();"/>
     <span class="s1" id="username_msg"></span>
    </td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;密码：</td>
    <td>&nbsp;&nbsp;&nbsp;     <input  name='password' id="password" size="20 " type="password" onBlur="valipwd();"/>
    <span class="s1" id="pwd_msg"></span></p>
    </td>
  </tr>
  <tr>
    <td colspan="2"><input name="userType" type="radio" value="0" checked>
      学生 &nbsp;
      <input name="userType" type="radio" value="1" >
      学委 &nbsp;
      <input name="userType" type="radio" value="2"> 老师&nbsp;<input name="userType" type="radio" value="3"> 辅导员&nbsp;<input name="userType" type="radio" value="4"> 管理员&nbsp;</td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<input name="提交"  type="submit" value="登录" >
			&nbsp;&nbsp;	<input name="重置" type="reset" value="重置"></td>
  </tr>
</table>
</form>
</td>
  </tr>
</table>
</td>
  </tr>
</table>
  </body>
</html>
