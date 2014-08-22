<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gdpi.attendance.dao.*" %>
<%@ page import="com.gdpi.attendance.form.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/pages/commons/header.jsp" %>
<script language="JavaScript" type="text/javascript">   
var city=[   
["网络一班","网络二班"],   
["软件java班","软件.net班"],   
["应用班"],   
["多媒体"], 
["软件测试班"]
];    
function getCity(){   
//获得省份下拉框的对象   
var sltProvince=document.form1.Major;   
//获得城市下拉框的对象   
var sltCity=document.form1.Clas;   
//得到对应省份的城市数组   
var provinceCity=city[sltProvince.selectedIndex - 1];   
//清空城市下拉框，仅留提示选项   
sltCity.length=1;   
//将城市数组中的值填充到城市下拉框中   
for(var i=0;i<provinceCity.length;i++){   
sltCity[i+1]=new Option(provinceCity[i],provinceCity[i]);   
}   
}   
</script>
</head>
<body>
	<tr>
	<FORM method="post" action="" name="form1">  
    <p>
        年级<select name="Grade">
          <option value="2011">2011</option>
          <option value="2012">2012</option>
          <option value="2013">2013</option>
          <option value="2012">2014</option>
          <option value="2015">2015</option>
          <option value="2016">2016</option>
          <option value="2017">2017</option>
          <option value="2018">2018</option>
          <option value="2019">2019</option>
          <option value="2020">2020</option>
        </select>
        &nbsp;&nbsp; 
		<SELECT NAME="Major" onChange="getCity()">   
		<OPTION VALUE="0">请选择专业 </OPTION>   
		<OPTION VALUE="计算机网络技术">计算机网络技术 </OPTION>   
		<OPTION VALUE="计算机软件技术">计算机软件技术 </OPTION>   
		<OPTION VALUE="计算机应用技术">计算机应用技术 </OPTION>   
		<OPTION VALUE="计算机多媒体技术">计算机多媒体技术 </OPTION>   
		<OPTION VALUE="计算机信息技术">计算机信息技术 </OPTION>  
		<OPTION VALUE="计算机测试技术">计算机测试技术 </OPTION>  
		</SELECT>   
		<SELECT NAME="Clas">   
		<OPTION VALUE="0">请选择班级 </OPTION>   
		</SELECT> 
		 &nbsp;&nbsp; <input name="submin" type="submit" value="查看"/> 	
    
	  &nbsp;&nbsp;指定辅导员：列柳旭 <a href="">修改</a>  
	   </p>
    </FORM>
	</tr>
	<tr>
	<table width="750" border="1" align="center" cellpadding="0" cellspacing="0">
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
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <td height="39" align="center" valign="middle">2</td>
  </tr>
  <tr>
    <td height="40" align="center" valign="middle">3</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <td height="37" align="center" valign="middle">4</td>
  </tr>
  <tr>
    <td colspan="8" align="center" valign="middle">午休</td>
    </tr>
  <tr>
    <td height="41" align="center" valign="middle">5</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <td height="41" align="center" valign="middle">6</td>
  </tr>
  <tr>
    <td height="36" align="center" valign="middle">7</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <td height="43" align="center" valign="middle">8</td>
  </tr>
  <tr>
    <td colspan="8" align="center" valign="middle">晚修</td>
    </tr>
  <tr>
    <td height="35" align="center" valign="middle">9</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
    <td rowspan="2" align="center" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <td height="38" align="center" valign="middle">10</td>
  </tr>
</table>

	</tr>
	</form>
</body>
</html>