<%@ page language="java" pageEncoding="UTF-8"%>
    <script src="<%=request.getContextPath()%>/lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/lib/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css" />
    <script src="<%=request.getContextPath()%>/lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/lib/jquery-validation/jquery.validate.min.js" type="text/javascript"></script> 
    <script src="<%=request.getContextPath()%>/lib/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/lib/jquery-validation/messages_cn.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/lib/json2.js" type="text/javascript"></script>
     <script src="<%=request.getContextPath()%>/js/LG.js" type="text/javascript"></script>
<style type="text/css">
.l-table-edit {}
.l-table-edit-td{ padding:4px;}
.l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}
.l-verify-tip{ left:230px; top:120px;}
</style>
<script type="text/javascript">
function FormToJson(formValues) {
	var result = {};
	for ( var formValue, j = 0; j < formValues.length; j++) {
		formValue = formValues[j];
		var name = formValue.name;
		var value = formValue.value;
		if (name.indexOf('.') < 0) {
			result[name] = value;
			continue;
		} else {
			var simpleNames = name.split('.');
			// 构建命名空间
			var obj = result;
			for ( var i = 0; i < simpleNames.length - 1; i++) {
				var simpleName = simpleNames[i];
				if (simpleName.indexOf('[') < 0) {
					if (obj[simpleName] == null) {
						obj[simpleName] = {};
					}
					obj = obj[simpleName];
				} else { // 数组
					// 分隔
					var arrNames = simpleName.split('[');
					var arrName = arrNames[0];
					var arrIndex = parseInt(arrNames[1]);
					if (obj[arrName] == null) {
						obj[arrName] = []; // new Array();
					}
					obj = obj[arrName];
					multiChooseArray = result[arrName];
					if (obj[arrIndex] == null) {
						obj[arrIndex] = {}; // new Object();
					}
					obj = obj[arrIndex];
				}
			}

			if (obj[simpleNames[simpleNames.length - 1]]) {
				var temp = obj[simpleNames[simpleNames.length - 1]];
				obj[simpleNames[simpleNames.length - 1]] = temp;
			} else {
				obj[simpleNames[simpleNames.length - 1]] = value;
			}

		}
	}
	return result;
}
</script>