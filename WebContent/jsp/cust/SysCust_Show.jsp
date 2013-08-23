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
						客户修改:客户编号(<s:property value="sysCustVO.id" />)
						<s:actionerror cssStyle="color:red;" />
						<s:actionmessage cssStyle="color:#ffffff;" />
					</td>
				</tr>
				<tr>
					<td>
						客户名称:
					</td>
					<td>
						<s:textfield name="sysCustVO.name" disabled="true" />
					</td>
					<td>
						邮编:
					</td>
					<td>
						<s:textfield name="sysCustVO.postalCode" disabled="true" />
					</td>
				</tr>

				<tr>
					<td>
						所属行业:
					</td>
					<td>
						<s:select data="所属行业" list="baseIndustryVOs" listKey="id" listValue="industryName" name="sysCustVO.baseIndustryId" disabled="true" />
					</td>
					<td>
						客户类型:
					</td>
					<td>
						<s:select list="baseTypeVOs" listKey="id" listValue="typeName" name="sysCustVO.baseTypeId" disabled="true" />
					</td>
				</tr>
				<tr>
					<td>
						客户来源:
					</td>
					<td>
						<s:select data="客户来源" list="baseSourceVOs" listKey="id" listValue="sourceName" name="sysCustVO.baseSourceId" disabled="true" />
					</td>
					<td>
						客户状态:
					</td>
					<td>
						<s:select data="客户状态" list="baseStateVOs" listKey="id" listValue="stateName" name="sysCustVO.baseStateId" disabled="true" />
					</td>
				</tr>
				<tr>
					<td>
						公司主页:
					</td>
					<td colspan="3">
						<s:textarea rows="6" name="sysCustVO.website" disabled="true" />
					</td>
				</tr>
				<tr>
					<td>
						详细地址:
					</td>
					<td colspan="3">
						<s:textarea rows="6" name="sysCustVO.address" disabled="true" />
					</td>
				</tr>
				<tr>
					<td>
						备注:
					</td>
					<td colspan="3">
						<s:textarea rows="6" name="sysCustVO.remark" disabled="true" />
					</td>
				</tr>

				<tr>
					<td class="tdCenter" colspan="4">
						<table width="100%">
							<tr>
								<td>
									<div align="center">
										<s:submit value="关  闭" onclick="return closeWindow(this);" />
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>