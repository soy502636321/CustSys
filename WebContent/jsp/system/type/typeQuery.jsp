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
		<s:form action="baseTypeAction" namespace="/system">
			<br>
			<table>
				<tr>
					<td>
						客户类型编号
					</td>
					<td>
						<s:textfield name="baseTypeVO.id"></s:textfield>
					</td>
					<td>
						客户类型名称
					</td>
					<td>
						<s:textfield name="baseTypeVO.typeName"></s:textfield>
					</td>
					<td>
						备注
					</td>
					<td>
						<s:textarea name="baseTypeVO.remark"></s:textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<s:submit value="查  询" action="baseTypeAction!query"></s:submit>
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
							requestURI="baseTypeAction!query">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxDecorator"
								style="width:3%;"
								title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
							</display:column>
							<display:column property="id" title="客户类型编号"></display:column>
							<display:column property="typeName" title="客户类型名称"></display:column>
							<display:column property="remark" title="备注"></display:column>
						</display:table>
					</td>
				</tr>
			</table>
			<hq:buttons function="21">
				<hq:button name="增  加"></hq:button>
				<hq:button name="修  改" mode="single" location="this"></hq:button>
				<hq:button name="删  除" mode="del"></hq:button>
			</hq:buttons>
		</s:form>
	</body>
</html>