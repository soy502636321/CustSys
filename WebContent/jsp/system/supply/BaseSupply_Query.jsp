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
		<s:form action="baseSupplyAction" namespace="/system">
			<br>
			<table>
				<tr>
					<td>
						供应质量编号
					</td>
					<td>
						<s:textfield name="baseSupplyVO.id"></s:textfield>
					</td>
					<td>
						供应质量名称
					</td>
					<td>
						<s:textfield name="baseSupplyVO.supplyName"></s:textfield>
					</td>
					<td>
						备注
					</td>
					<td>
						<s:textarea name="baseSupplyVO.remark"></s:textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<s:submit value="查  询" action="baseSupplyAction!query"></s:submit>
						&nbsp;&nbsp;&nbsp;
						<s:reset value="重  置"></s:reset>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						${ actionMessages[0] }${actionErrors[0]}
					</td>
				</tr>
			</table>
			<br>
			<table style="width: 100%">
				<tr>
					<td></td>
				</tr>
				<tr>
					<td>
						<display:table name="list" class="simple"
							requestURI="baseSupplyAction!query">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxDecorator"
								style="width:3%;"
								title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
							</display:column>
							<display:column property="id" title="供应质量编号"></display:column>
							<display:column property="supplyName" title="供应质量名称"></display:column>
							<display:column property="remark" title="备注"></display:column>
						</display:table>
					</td>
				</tr>
			</table>
			<hq:buttons function="9018">
				<hq:button name="增  加"></hq:button>
				<hq:button name="修  改" mode="single" location="this"></hq:button>
				<hq:button name="显  示" mode="single" location="this"></hq:button>
				<hq:button name="删  除" mode="del"></hq:button>
			</hq:buttons>
		</s:form>
	</body>
</html>