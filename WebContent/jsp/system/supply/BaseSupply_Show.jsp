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
	<s:form action="baseSupplyAction" namespace="/system" method="post">
		<s:hidden name="baseSupplyVO.id" />
		<br>
		<table align="center" class="tableBorder"
			style="margin: auto; width: 400px;">
			<tr class="forumRowHighlight"
				style="background-color: #3c7fb5; color: #ffffff;">
				<td colspan="4">供应质量显示 <s:actionerror cssStyle="color:red;" />
					<s:actionmessage cssStyle="color:#ffffff;" />
				</td>
			</tr>
			<tr>
				<td>供应质量名称:</td>
				<td colspan="3"><s:textfield name="baseSupplyVO.supplyName" disabled="true"
						cssStyle="width: 100%" data="供应质量名字"></s:textfield>
				</td>
			</tr>

			<tr>
				<td>备注:</td>
				<td colspan="3"><s:textarea name="baseSupplyVO.remark" disabled="true"
						cssStyle="width: 100%" rows="6"></s:textarea>
				</td>
			</tr>

			<tr>
				<td class="tdCenter" colspan="4">
					<s:submit
						value="返  回" action="baseSupplyAction!back"></s:submit></td>
			</tr>
		</table>
	</s:form>
</body>
</html>