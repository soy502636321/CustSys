<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

<body>

	<s:form action="sysCustAction" namespace="/sysCust" class="form">
		<table>
			<tr>
				<td>供应商编号</td>
				<td><s:textfield name="sysSupplierVO.id" /></td>
				<td>姓名</td>
				<td><s:textfield name="sysSupplierVO.name" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><s:select list="genders" listKey="key" listValue="value"
						name="sysSupplierVO.genderId" /></td>
				</td>
				<td>联系电话</td>
				<td><s:textfield name="sysSupplierVO.phoneTh1" /></td>
			</tr>
			<tr>
				<td>QQ</td>
				<td><s:textfield name="sysSupplierVO.qq" /></td>
				<td>邮箱</td>
				<td><s:textfield name="sysSupplierVO.email" /></td>
			</tr>
			<tr>
				<td>主营一</td>
				<td><s:select list="baseMains" listKey="id"
						listValue="mainName" name="sysSupplierVO.mainTh1Id" /></td>
				<td>主营二</td>
				<td><s:select list="baseMains" listKey="id"
						listValue="mainName" name="sysSupplierVO.mainTh2Id" /></td>
			</tr>
			<tr>
				<td>主营三</td>
				<td><s:select list="baseMains" listKey="id"
						listValue="mainName" name="sysSupplierVO.mainTh3Id" /></td>
				<td>成交价格</td>
				<td><s:textfield name="sysSupplierVO.priceString" /></td>
			</tr>
			<tr>
				<td>订单品质</td>
				<td colspan="3"><s:select multiple="true" list="baseSupplyVOs"
						listKey="id" listValue="supplyName"
						name="sysSupplierVO.supplierQualityId" cssClass="chosen"
						cssStyle="width: 100%"
						value="%{sysSupplierVO.supplierQualities.{id}}" /></td>
			</tr>
			<tr>
				<td>订单种类</td>
				<td colspan="3"><s:select multiple="true" list="baseClassVOs"
						listKey="id" listValue="className"
						name="sysSupplierVO.supplierClassId" cssClass="chosen"
						cssStyle="width: 100%"
						value="%{sysSupplierVO.supplierClasses.{id}}" /></td>
			</tr>
			<tr>
				<td>其他</td>
				<td colspan="3"><s:textarea name="sysSupplierVO.other" /></td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="3"><s:textarea name="sysSupplierVO.remark" /></td>
			</tr>
			<tr>
				<td colspan="4" class="tdCenter"><s:submit value="确  定"
						onclick="return searchSubmit(this);" /> <s:submit value="关  闭"
						onclick="return closeThisWindow(this);" /></td>
			</tr>
		</table>
	</s:form>
</body>
	<script type="text/javascript">
	$(function() {
		$(".chosen").chosen();
	})
	</script>
</html>
