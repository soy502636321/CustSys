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
	<s:form action="sysCustAction" namespace="/sysCust" class="form">
		<table>
			<tr>
				<td style="width: 60px">客户编号</td>
				<td><s:textfield name="sysCustVO.id" />
				</td>
				<td style="width: 60px">客户名称</td>
				<td><s:textfield name="sysCustVO.name" />
				</td>
			</tr>
			<tr>
				<td>邮编</td>
				<td><s:textfield name="sysCustVO.postalCode" />
				</td>
				<td>所属行业</td>
				<td><s:select list="baseIndustryVOs" listKey="id"
						listValue="industryName" name="sysCustVO.baseIndustryId" />
				</td>
			</tr>
			<tr>
				<td>客户类型</td>
				<td><s:select list="baseTypeVOs" listKey="id"
						listValue="typeName" name="sysCustVO.baseTypeId" />
				</td>
				<td>客户来源</td>
				<td><s:select list="baseSourceVOs" listKey="id"
						listValue="sourceName" name="sysCustVO.baseSourceId" />
				</td>
			</tr>
			<tr>
				<td>客户状态</td>
				<td><s:select list="baseStateVOs" listKey="id"
						listValue="stateName" name="sysCustVO.baseStateId" />
				</td>
			</tr>
			<tr>
				<td>公司主页</td>
				<td colspan="3"><s:textarea name="sysCustVO.website" />
				</td>
			</tr>
			<tr>
				<td>详细地址</td>
				<td colspan="3"><s:textarea name="sysCustVO.address" />
				</td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="3"><s:textarea name="sysCustVO.remark" />
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<s:submit value="确  定" onclick="return searchSubmit(this);" />
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
