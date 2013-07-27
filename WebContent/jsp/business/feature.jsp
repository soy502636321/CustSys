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
	<s:form namespace="/sysCust" method="post">
		<s:hidden name="sysCustVO.id"></s:hidden>
		<br>
		<table align="center" class="tableBorder"
			style="margin: auto; width: 600px;">
			<tr class="forumRowHighlight"
				style="background-color: #3c7fb5; color: #ffffff;">
				<td colspan="4">
					<s:if test="edit">
					客户特点
					</s:if>
					<s:else>
					客户特点修改
					</s:else> 
					<s:actionerror cssStyle="color:red;" />
					<s:actionmessage cssStyle="color:#ffffff;" /></td>
			</tr>
			<tr>
				<td width="100px;">客户特点:</td>
				<td>
					<s:if test="edit">
						<s:textarea name="sysBusinessVO.sysCust.feature" disabled="true" rows="8" />
					</s:if>
					<s:else>
					<s:textarea name="sysCustVO.feature" rows="8" />
					</s:else>
				</td>
			</tr>
			<tr>
				<td class="tdCenter" colspan="4">
					<table width="100%">
						<tr>
							<td>
								<div align="center">

									<s:if test="edit">
										<s:submit value="关  闭" onclick="return closeWindow(this);" />
									</s:if>
									<s:else>
										<s:submit value="修  改" action="sysCustAction!updateFeature"
											onclick="return submitCheck(this);"></s:submit>
										&nbsp;&nbsp;
										<s:reset value="重  置"></s:reset>
										&nbsp;&nbsp;
										<s:submit value="返  回" action="sysCustAction!back"></s:submit>
									</s:else>
								</div></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
</body>
</html>