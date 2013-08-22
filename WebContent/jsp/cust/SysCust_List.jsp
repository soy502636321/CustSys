<%@page import="com.opensymphony.xwork2.ognl.OgnlValueStack"%>
<jsp:directive.include file="/include/mainMenu.jsp" />
<!-- 分配重新开发用户 -->
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<base target="_self" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body>
		<br>
		<s:form action="sysCustAction" namespace="/sysCust" target="" >
			<table align="center" class="tableBorder"
				style="margin: auto; width: 600px;">
				<tr>
					<td colspan="4" class="header">
						客户选择
						<s:actionerror cssStyle="color:red;" />
						<s:actionmessage cssStyle="color:blue;" />
					</td>
				</tr>
				<tr>
					<td width="80px">
						客户编号:
					</td>
					<td>
						<s:textfield name="sysCustVO.id" />
					</td>
					<td>
						客户名字:
					</td>
					<td>
						<s:textfield name="sysCustVO.name" />
					</td>
				</tr>
				<tr>
					<td>
						客户类型:
					</td>
					<td>
						<select name="sysCustVO.custType">
							<option></option>
							<option value="Y">正常客户</option>
							<option value="E">开发客户</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tdCenter" colspan="4">
						<s:submit value="查  询" action="sysCustAction!findList" />
						&nbsp;&nbsp;
						<input type="button" onclick="selectSysCust(this)" value="确  定" />
						&nbsp;&nbsp;
						<input type="button" value="关  闭" onclick="closeWindow(this);" />
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<display:table name="list" class="simple" requestURI="sysCustAction!findList" id="row"
							excludedParams="action:custPalaverDialogAction!assignBaseOrgan">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxSingleDecorator"
								style="width:3%;"
								title="单选">
							</display:column>
							<display:column property="id" title="客户编号" />
							<display:column property="name" title="客户名字" />
							<display:column title="客户类型">
								<input type="hidden" value='${ row.json }' />
							</display:column>
						</display:table>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
	<script type="text/javascript">
		function selectSysCust(o) {
			if (jQuerySingleSelect("cbId2")) {
				//获得选中
				var checkbox = $('input:checked[name="cbId2"]')[0];
				//获得选中的行
				var tr = $(checkbox).parents('tr:first');
				//获得选中的洽谈人对象
				var custPalaver = JSON.parse($(tr).find('input:hidden').val());
				//赋值给返回对象
				window.returnValue = custPalaver;
				
				alert(window.returnValue);
				//关闭当前窗口
				closeThisWindow(o);
			}
		}
	</script>
</html>