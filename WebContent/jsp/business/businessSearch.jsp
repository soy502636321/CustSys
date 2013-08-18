<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body>
		<s:form class="form">
			<table>
				<tr>
					<td>
						客户编号
					</td>
					<td>
						<s:textfield name="sysBusinessVO.sysCustId" />
					</td>
					<td>
						订单编号
					</td>
					<td>
						<s:textfield name="sysBusinessVO.businessNo" />
					</td>
				</tr>
				<tr>
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
				</tr>
				<tr>
					<td>
						开发人
					</td>
					<td>
						<s:textfield name="sysBusinessVO.privateUserUsername" />
					</td>
				</tr>
				<tr>
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
							cssClass="chosen" cssStyle="width: 100%"
							value="%{sysBusinessVO.baseQualityVOs.{id}}" />
					</td>
				</tr>
				<tr>
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
				</tr>
				<tr>
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
				</tr>
				<tr>
					<td>
						付款方式
					</td>
					<td>
						<s:select list="basePaymentVOs" listKey="id"
							listValue="paymentName" name="sysBusinessVO.basePaymentId" />
					</td>
					<td>
						交付方式
					</td>
					<td>
						<s:select list="baseDeliveryVOs" listKey="id"
							listValue="deliveryName" name="sysBusinessVO.baseDeliveryId" />
					</td>
				</tr>
				<tr>
					<td>
						客户投诉
					</td>
					<td>
						<s:select list="yesOrNo" listKey="key" listValue="value"
							name="sysBusinessVO.complaintsId" />
					</td>
					<td>
						开票
					</td>
					<td>
						<s:select list="yesOrNo" listKey="key" listValue="value"
							name="sysBusinessVO.invoiceId" />
					</td>
				</tr>
				<tr>

					<td>
						备注
					</td>
					<td colspan="3">
						<s:textarea rows="4" name="sysBusinessVO.remark" />
					</td>
				</tr>
				<tr>
					<td colspan="4" class="tdCenter">
						<input type="button" value="确  定" onclick="return searchSubmit(this);" />
						<s:submit value="关  闭" onclick="return closeThisWindow(this);" />
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
