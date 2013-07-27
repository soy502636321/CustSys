<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>
	<s:form namespace="/system" method="post">
		<s:hidden name="baseTypeVO.id"></s:hidden>
		<br>
		<table align="center" class="tableBorder"
			style="margin: auto; width: 400px;">
			<tr class="forumRowHighlight"
				style="background-color: #3c7fb5; color: #ffffff;">
				<td colspan="4">客户类型增加 <s:actionerror cssStyle="color:red;" />
					<s:actionmessage cssStyle="color:#ffffff;" /></td>
			</tr>
			<tr>
				<td>客户类型名称:</td>
				<td colspan="3"><s:textfield name="baseTypeVO.typeName"
						cssStyle="width: 100%" data="客户类型名字"></s:textfield></td>
			</tr>

			<tr>
				<td>备注:</td>
				<td colspan="3"><s:textarea name="baseTypeVO.remark"
						cssStyle="width: 100%" rows="6"></s:textarea></td>
			</tr>

			<tr>
				<td class="tdCenter" colspan="4">
					<s:if test="edit">
						<s:submit value="修  改" action="baseTypeAction!update"
							onclick="return submitCheck(this);"></s:submit>
					</s:if> <s:else>
						<s:submit value="增  加" action="baseTypeAction!save"
							onclick="return submitCheck(this);"></s:submit>
					</s:else> &nbsp;&nbsp; 
					<s:reset value="重  置"></s:reset> 
						&nbsp;&nbsp; 
					<s:submit value="返  回" action="baseTypeAction!back"></s:submit>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>