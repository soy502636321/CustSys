<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body>
		<s:form action="sysSupplierAction" namespace="/sysSupplier" method="post">
			<br>
			<table align="center" class="tableBorder"
				style="margin: auto; width: 600px;">
				<tr class="forumRowHighlight"
					style="background-color: #3c7fb5; color: #ffffff;">
					<td colspan="4">
						<s:if test="edit">
							供应商修改:供应商编号(<s:property value="sysSupplierVO.id" />)
						</s:if>
						<s:else>
							供应商增加
						</s:else>
						<s:actionerror cssStyle="color:red;" />
						<s:actionmessage cssStyle="color:#ffffff;" />
					</td>
				</tr>
				<tr>
					<td>
						供应商编号:
					</td>
					<td>
						<s:if test="edit">
							<s:textfield name="sysSupplierVO.id" readonly="true" />
						</s:if>
						<s:else>
							<s:textfield readonly="true" value="系统生成" />
						</s:else>
					</td>
					<td>
						姓名:
					</td>
					<td>
						<s:textfield data="姓名" notnull="true" name="sysSupplierVO.name" />
					</td>
				</tr>

				<tr>
					<td>
						性别:
					</td>
					<td>
						<s:select list="genders" listKey="key"
							listValue="value" name="sysSupplierVO.genderId" />
					</td>
					<td>
						联系电话:
					</td>
					<td>
						<s:textfield data="联系电话" notnull="true" name="sysSupplierVO.phoneTh1" />
					</td>
				</tr>
				<tr>
					<td>
						QQ:
					</td>
					<td>
						<s:textfield name="sysSupplierVO.qq" />
					</td>
					<td>
						邮箱:
					</td>
					<td>
						<s:textfield name="sysSupplierVO.email" />
					</td>
				</tr>
				<tr>
					<td>
						业务品质:
					</td>
					<td colspan="3">
						<s:select multiple="true" list="baseQualityVOs" listKey="id"
							listValue="qualityName" name="sysSupplierVO.supplierQualityId"
							cssClass="chosen"  value="%{sysSupplierVO.supplierQualities.{id}}" />
					</td>
				</tr>
				<tr>
					<td>
						业务类型:
					</td>
					<td colspan="3">
						<s:select multiple="true" list="baseClassVOs" listKey="id"
							listValue="className" name="sysSupplierVO.supplierClassId"
							cssClass="chosen"  value="%{sysSupplierVO.supplierClasses.{id}}"/>
					</td>
				</tr>
				<tr>
					<td>
						主营一:
					</td>
					<td>
						<s:select list="baseMains" listKey="id" listValue="mainName" name="sysSupplierVO.mainTh1Id" />
					</td>
					<td>
						主营二:
					</td>
					<td>
						<s:select list="baseMains" listKey="id" listValue="mainName" name="sysSupplierVO.mainTh2Id" />
					</td>
				</tr>
				<tr>
					<td>
						主营三:
					</td>
					<td>
						<s:select list="baseMains" listKey="id" listValue="mainName" name="sysSupplierVO.mainTh3Id" />
					</td>
					<td>
						成交价格:
					</td>
					<td>
						<s:textfield num="成交价格" name="sysSupplierVO.price" />
					</td>
				</tr>
				<tr>
					<td>
						其他:
					</td>
					<td colspan="3">
						<s:textarea name="sysSupplierVO.other" rows="6" />
					</td>
				</tr>
				<tr>
					<td>
						备注:
					</td>
					<td colspan="3">
						<s:textarea name="sysSupplierVO.remark" rows="6" />
					</td>
				</tr>

				<tr>
					<td class="tdCenter" colspan="4">
						<table width="100%">
							<tr>
								<td>
									<div align="center">
										<s:if test="edit">
											<s:submit value="修  改" action="sysSupplierAction!update"
												onclick="return submitCheck(this) && isNumber(this);"></s:submit>
										</s:if>
										<s:else>
											<s:submit value="增  加" action="sysSupplierAction!save"
												onclick="return submitCheck(this) && isNumber(this);"></s:submit>
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
	<script type="text/javascript">
	$(function() {
		$(".chosen").chosen();
	});
	</script>
</html>