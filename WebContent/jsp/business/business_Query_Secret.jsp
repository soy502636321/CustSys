<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
	<head>
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body>
		<s:form action="secretSysBusinessAction" namespace="/sysBusiness">
			<br>
			<table>
				<tr>
					<td colspan="4">
						<s:submit value="查  询" onclick="return openSearchDialog(this, 'secretSysBusinessAction!search', 500, 500);" action="secretSysBusinessAction!query"></s:submit>
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
					<td>
						<display:table name="list" class="simple"
							requestURI="secretSysBusinessAction!query">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxDecorator"
								style="width:3%;"
								title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
							</display:column>
							<display:column property="businessNo" title="订单编号"></display:column>
							<display:column property="sysCustId" title="客户编号"></display:column>
							<display:column property="contractNo" title="合同编号"></display:column>
							<display:column property="theme" title="订单主题"></display:column>
							<display:column property="businessTime" title="订单时间"
								format="{0,date,yyyy-MM-dd HH:mm}"></display:column>
							<display:column property="deliveryTime" title="交付时间"
								format="{0,date,yyyy-MM-dd HH:mm}"></display:column>
							<display:column property="id" title="订单品质"></display:column>
							<display:column property="id" title="订单种类"></display:column>
							<display:column property="quantity" title="数量"></display:column>
							<display:column property="correspondsPrice" title="对应单价"></display:column>
							<display:column property="pageNumber" title="页码"></display:column>
							<display:column property="rawMaterials" title="原材料"></display:column>
							<display:column property="productType" title="产品类型"></display:column>
							<display:column property="baseDelivery.deliveryName" title="交付方式"></display:column>
							<display:column property="complaints" title="客户投诉"></display:column>
							<display:column property="privateUserUsername" title="开发人"></display:column>
							<display:column property="remark" title="备注"></display:column>
						</display:table>
					</td>
				</tr>
			</table>
			<hq:buttons function="9014">
				<hq:button name="订单要求" mode="single"></hq:button>
				<hq:button name="客户特点" mode="single"></hq:button>
				<hq:button name="生产记录" mode="single"></hq:button>
			</hq:buttons>
		</s:form>
	</body>
</html>