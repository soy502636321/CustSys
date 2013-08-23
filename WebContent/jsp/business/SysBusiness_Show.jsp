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
		<s:form namespace="/sysBusiness" method="post">
			<s:hidden name="sysBusinessVO.id"></s:hidden>
			<br>
			<table align="center" class="tableBorder"
				style="margin: auto; width: 600px;">
				<tr class="forumRowHighlight"
					style="background-color: #3c7fb5; color: #ffffff;">
					<td colspan="4">
						订单修改:订单编号(
						<s:property value="sysBusinessVO.businessNo" />
						)
						<s:actionerror cssStyle="color:red;" />
						<s:actionmessage cssStyle="color:#ffffff;" />
					</td>
				</tr>
				<tr>
					<td>
						客户名称:
					</td>
					<td>
						<s:textfield 
								name="sysBusinessVO.sysCustName" disabled="true" />
					</td>
					<td>
						合同编号:
					</td>
					<td>
						<s:textfield name="sysBusinessVO.contractNo" disabled="true" />
					</td>
				</tr>
				<tr>
					<td>
						订单编号:
					</td>
					<td>
						<s:textfield name="sysBusinessVO.businessNo" disabled="true" />
					</td>
					<td>
						订单主题:
					</td>
					<td>
						<s:textfield name="sysBusinessVO.theme" disabled="true" />
					</td>
				</tr>
				<tr>
					<td>
						订单时间:
					</td>
					<td>
						<s:textfield cssClass="calendar" name="sysBusinessVO.businessTime" disabled="true"
							data="订单时间">
							<s:param name="value">
								<s:date name="sysBusinessVO.businessTime"
									format="yyyy-MM-dd HH:mm" />
							</s:param>
						</s:textfield>
					</td>
					<td>
						交付时间:
					</td>
					<td>
						<s:textfield cssClass="calendar" name="sysBusinessVO.deliveryTime" disabled="true"
							data="交付时间" />
					</td>
				</tr>
				<tr>
					<td>
						订单品质:
					</td>
					<td colspan="3">
						<s:select multiple="true" list="baseQualityVOs" listKey="id"
							listValue="qualityName" name="sysBusinessVO.businessQualityId"
							cssClass="chosen" data="订单品质"
							value="%{sysBusinessVO.baseQualityVOs.{id}}" disabled="true"/>
					</td>
				</tr>
				<tr>
					<td>
						订单种类:*
					</td>
					<td colspan="3">
						<s:select multiple="true" list="baseClassVOs" listKey="id"
							listValue="className" name="sysBusinessVO.businessClassId"
							cssClass="chosen" data="订单种类"
							value="%{sysBusinessVO.baseClassVOs.{id}}"  disabled="true"/>
					</td>
				</tr>
				<tr>
					<td>
						数量:*
					</td>
					<td>
						<s:textfield name="sysBusinessVO.quantity" data="数量" num="数量" disabled="true"/>
					</td>
					<td>
						单价:*
					</td>
					<td>
						<s:textfield name="sysBusinessVO.unitprice" data="单价" num="单价" disabled="true"/>
					</td>
				</tr>
				<tr>
					<td>
						页码:
					</td>
					<td>
						<s:textfield name="sysBusinessVO.correspondsPrice" num="对应单价" disabled="true"/>
					</td>
					<td>
						对应单价:
					</td>
					<td>
						<s:textfield name="sysBusinessVO.pageNumber" num="页码" disabled="true"/>
					</td>
				</tr>
				<tr>
					<td>
						税:
					</td>
					<td>
						<s:textfield name="sysBusinessVO.duty" num="税" disabled="true"/>
					</td>
					<td>
						返现:
					</td>
					<td>
						<s:textfield name="sysBusinessVO.cashBack" num="返现" disabled="true"/>
					</td>
				</tr>
				<tr>
					<td>
						原材料:
					</td>
					<td>
						<s:textfield name="sysBusinessVO.rawMaterials" disabled="true"/>
					</td>
					<td>
						交付类型:
					</td>
					<td>
						<s:textfield name="sysBusinessVO.productType" disabled="true"/>
					</td>
				</tr>
				<tr>
					<td>
						预估金额:*
					</td>
					<td>
						<s:textfield name="sysBusinessVO.estimatedAmount" data="预估金额"
							num="预估金额" disabled="true"/>
					</td>
					<td>
						实际金额:
					</td>
					<td>
						<s:textfield name="sysBusinessVO.actualAmount" disabled="true"/>
					</td>
				</tr>
				<tr>
					<td>
						付款方式:*
					</td>
					<td>
						<s:select list="basePaymentVOs" listKey="id"
							listValue="paymentName" data="付款方式"
							name="sysBusinessVO.basePayment.id" disabled="true"/>
					</td>
					<td>
						交付方式:
					</td>
					<td>
						<s:select list="baseDeliveryVOs" listKey="id"
							listValue="deliveryName" name="sysBusinessVO.baseDelivery.id" disabled="true"/>
					</td>
				</tr>
				<tr>
					<td>
						开票:
					</td>
					<td>
						<s:select list="yesOrNo" listKey="key" listValue="value"
							name="sysBusinessVO.invoiceId" disabled="true"/>
					</td>
					<td>
						客户投诉:
					</td>
					<td>
						<s:select list="yesOrNo" listKey="key" listValue="value"
							name="sysBusinessVO.complaintsId" disabled="true"/>
					</td>
				</tr>
				<tr>
					<td>
						备注:
					</td>
					<td colspan="3">
						<s:textarea rows="6" name="sysBusinessVO.remark" disabled="true"/>
					</td>
				</tr>
				<tr>
					<td class="tdCenter" colspan="4">
						<table width="100%">
							<tr>
								<td>
									<div align="center">
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