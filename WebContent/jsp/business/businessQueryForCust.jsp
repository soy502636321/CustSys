<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>客户编号(<s:property value="sysCustVO.id" />)的业务记录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body>
		<s:form namespace="/sysBusiness" method="post"
			action="sysBusinessForCustAction">
			<s:hidden name="sysCustVO.id" />
			<br>
			<table align="center" class="tableBorder"
				style="margin: auto; min-width: 1100px;">
				<tr class="forumRowHighlight"
					style="background-color: #3c7fb5; color: #ffffff;">
					<td colspan="4">
						客户编号(
						<s:property value="sysCustVO.id" />
						)的业务记录
						<s:actionerror cssStyle="color:red;" />
						<s:actionmessage cssStyle="color:#ffffff;" />
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td>
									订单编号
								</td>
								<td>
									<s:textfield name="sysBusinessVO.businessNo" />
								</td>
								<td>
									合同编号
								</td>
								<td>
									<s:textfield name="sysBusinessVO.contractNo" />
								</td>
								<td>
									订单主题
								</td>
								<td>
									<s:textfield name="sysBusinessVO.theme" />
								</td>
							</tr>
							<tr>
								<td>
									开始订单时间
								</td>
								<td>
									<s:textfield cssClass="calendar"
										name="sysBusinessVO.businessTimeStart" />
								</td>
								<td>
									结束订单时间
								</td>
								<td>
									<s:textfield cssClass="calendar"
										name="sysBusinessVO.businessTimeEnd" />
								</td>
								<td>
									开始交付时间
								</td>
								<td>
									<s:textfield cssClass="calendar"
										name="sysBusinessVO.deliveryTimeStart" />
								</td>
								<td>
									结束交付时间
								</td>
								<td>
									<s:textfield cssClass="calendar"
										name="sysBusinessVO.deliveryTimeEnd" />
								</td>
							</tr>
							<tr>
								<td>
									订单品质
								</td>
								<td colspan="3">
									<s:select multiple="true" list="baseQualityVOs" listKey="id"
							listValue="qualityName" name="sysBusinessVO.businessQualityId"
							cssClass="chosen" cssStyle="width: 100%" />
								</td>
								<td>
									订单种类
								</td>
								<td colspan="3">
									<s:select multiple="true" list="baseClassVOs" listKey="id"
							listValue="className" name="sysBusinessVO.businessClassId"
							cssClass="chosen" cssStyle="width: 100%" />
								</td>
							</tr>
							<tr>
								<td>
									数量
								</td>
								<td>
									<s:textfield name="sysBusinessVO.quantityString" />
								</td>
								<td>
									单价
								</td>
								<td>
									<s:textfield name="sysBusinessVO.unitpriceString" />
								</td>
								<td>
									预估金额
								</td>
								<td>
									<s:textfield name="sysBusinessVO.estimatedAmountString" />
								</td>
								<td>
									实际金额
								</td>
								<td>
									<s:textfield name="sysBusinessVO.actualAmountString" />
								</td>
								<td>
									付款方式
								</td>
								<td>
									<s:select list="basePaymentVOs" listKey="id" listValue="paymentName" name="sysBusinessVO.basePaymentId" />
								</td>
							</tr>
							<tr>
								<td>
									开票
								</td>
								<td>
									<s:select list="yesOrNo" listKey="key" listValue="value" name="sysBusinessVO.invoiceId" />
								</td>
								<td>
									交付方式
								</td>
								<td>
									<s:select list="baseDeliveryVOs" listKey="id" listValue="deliveryName" name="sysBusinessVO.baseDeliveryId" />
								</td>
								<td>
									客户投诉
								</td>
								<td>
									<s:select list="yesOrNo" listKey="key" listValue="value" name="sysBusinessVO.complaintsId" />
								</td>
								<td>
									备注
								</td>
								<td colspan="3">
									<s:textarea name="sysBusinessVO.remark" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="tdCenter">
						<div align="center">
							<hq:buttons function="63">
								<hq:button name="添加订单" mode="all"></hq:button>
								<hq:button name="修改订单" mode="single"></hq:button>
								<hq:button name="查  询"></hq:button>
								<hq:button type="reset"></hq:button>
								<hq:button mode="close"></hq:button>
							</hq:buttons>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<display:table name="list" class="simple"
							requestURI="sysBusinessForCustAction!query">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxDecorator"
								style="width:3%;"
								title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
								</display:column>
							<display:column property="businessNo" title="订单编号"></display:column>
							<display:column property="contractNo" title="合同编号"></display:column>
							<display:column property="theme" title="订单主题"></display:column>
							<display:column property="businessTime" title="订单时间"
								format="{0,date,yyyy-MM-dd HH:mm}"></display:column>
							<display:column property="deliveryTime" title="交付时间"
								format="{0,date,yyyy-MM-dd HH:mm}"></display:column>
							<display:column property="id" title="订单品质"></display:column>
							<display:column property="id" title="订单种类"></display:column>
							<display:column property="quantity" title="数量"></display:column>
							<display:column property="unitprice" title="单价"></display:column>
							<display:column property="correspondsPrice" title="对应单价"></display:column>
							<display:column property="pageNumber" title="页码"></display:column>
							<display:column property="duty" title="税"></display:column>
							<display:column property="cashBack" title="返现"></display:column>
							<display:column property="rawMaterials" title="原材料"></display:column>
							<display:column property="productType" title="产品类型"></display:column>
							<display:column property="estimatedAmount" title="预估金额"></display:column>
							<display:column property="actualAmount" title="实际金额"></display:column>
							<display:column property="basePayment.paymentName" title="付款方式"></display:column>
							<display:column property="invoice" title="开票"></display:column>
							<display:column property="baseDelivery.deliveryName" title="交付方式"></display:column>
							<display:column property="complaints" title="客户投诉"></display:column>
							<display:column property="remark" title="备注"></display:column>
						</display:table>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
	<script type="text/javascript">
	$(function() {
		$(".chosen").chosen();
		$('.calendar').each(
				function() {
					$(this).attr("id", ++$.datepicker.uuid).removeClass(
							"hasDatepicker").datetimepicker({
						numberOfMonths : 1,
						showButtonPanel : false,
						changeYear : true,
						changeMonth : true,
						dateFormat : 'yy-mm-dd'
					});
				});
	});
</script>
</html>