<!-- 订单品质-/增加/修改/ -->
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
		<s:hidden name="baseQualityVO.id"/>
		<br>
		<table align="center" class="tableBorder"
			style="margin: auto; width: 400px;">
			<tr class="forumRowHighlight"
				style="background-color: #3c7fb5; color: #ffffff;">
				<td colspan="4">
					业务品质增加 
					<s:actionerror cssStyle="color:red;" />
					<s:actionmessage cssStyle="color:#ffffff;" />
				</td>
			</tr>
			<tr>
				<td>业务品质名称:</td>
				<td colspan="3">
					<s:textfield name="baseQualityVO.qualityName"
						cssStyle="width: 100%" data="业务品质名字" />
				</td>
			</tr>

			<tr>
				<td>备注:</td>
				<td colspan="3">
					<s:textarea name="baseQualityVO.remark"
						cssStyle="width: 100%" rows="6"/>
				</td>
			</tr>

			<tr>
				<td class="tdCenter" colspan="4">
					<s:if test="edit">
						<s:submit value="修  改" action="baseQualityAction!update"
							onclick="return submitCheck(this);" />
					</s:if> <s:else>
						<s:submit value="增  加" action="baseQualityAction!save"
							onclick="return submitCheck(this);" />
					</s:else> 
						&nbsp;&nbsp; 
						<s:reset value="重  置" />
						&nbsp;&nbsp; 
						<s:submit
						value="返  回" action="baseQualityAction!back" />
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>