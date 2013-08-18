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
		<s:form action="privateprivateSysCustAction" namespace="/sysCust" method="post">
			<s:hidden name="sysCustVO.id" />
			<s:hidden name="sysCustVO.custType" />
			<br>
			<table align="center" class="tableBorder"
				style="margin: auto; width: 600px;">
				<tr class="forumRowHighlight"
					style="background-color: #3c7fb5; color: #ffffff;">
					<td colspan="4">
						<s:if test="edit">
							客户修改:客户编号(<s:property value="sysCustVO.id" />)
						</s:if>
						<s:else>
							客户增加
						</s:else>
						<s:actionerror cssStyle="color:red;" />
						<s:actionmessage cssStyle="color:#ffffff;" />
					</td>
				</tr>
				<tr>
					<td>
						客户名称:<span>*</span>
					</td>
					<td>
						<s:if test="edit">
							<s:textfield name="sysCustVO.name" readonly="true"></s:textfield>
						</s:if>
						<s:else>
							<s:textfield name="sysCustVO.name" data="客户名称"></s:textfield>
						</s:else>
					</td>
					<td>
						邮编:
					</td>
					<td>
						<s:textfield name="sysCustVO.postalCode" />
					</td>
				</tr>

				<tr>
					<td>
						所属行业:*
					</td>
					<td>
						<s:select data="所属行业" list="baseIndustryVOs" listKey="id" listValue="industryName" name="sysCustVO.baseIndustryId" />
					</td>
					<td>
						客户类型:
					</td>
					<td>
						<s:select list="baseTypeVOs" listKey="id" listValue="typeName" name="sysCustVO.baseTypeId" />
					</td>
				</tr>
				<tr>
					<td>
						客户来源:*
					</td>
					<td>
						<s:select data="客户来源" list="baseSourceVOs" listKey="id" listValue="sourceName" name="sysCustVO.baseSourceId" />
					</td>
					<td>
						客户状态:*
					</td>
					<td>
						<s:select data="客户状态" list="baseStateVOs" listKey="id" listValue="stateName" name="sysCustVO.baseStateId" />
					</td>
				</tr>
				<tr>
					<td>
						公司主页:
					</td>
					<td colspan="3">
						<s:textarea rows="6" name="sysCustVO.website"></s:textarea>
					</td>
				</tr>
				<tr>
					<td>
						详细地址:
					</td>
					<td colspan="3">
						<s:textarea rows="6" name="sysCustVO.address"></s:textarea>
					</td>
				</tr>
				<tr>
					<td>
						备注:
					</td>
					<td colspan="3">
						<s:textarea rows="6" name="sysCustVO.remark"></s:textarea>
					</td>
				</tr>

				<tr>
					<td class="tdCenter" colspan="4">
						<table width="100%">
							<tr>
								<td>
									<div align="center">
										<s:if test="edit">
											<s:submit value="修  改" action="privateSysCustAction!update"
												onclick="return submitCheck(this);"></s:submit>
										</s:if>
										<s:else>
											<s:submit value="增  加" action="privateSysCustAction!save"
												onclick="return submitCheck(this);"></s:submit>
										</s:else>
										&nbsp;&nbsp;
										<s:reset value="重  置"></s:reset>
										&nbsp;&nbsp;
										<s:submit value="关  闭" onclick="return closeWindow(this);"></s:submit>
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