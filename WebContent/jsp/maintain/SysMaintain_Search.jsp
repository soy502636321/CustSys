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
				<td>维护编号:</td>
				<td><s:textfield name="sysMaintainVO.id"></s:textfield></td>
				<td>客户编号:</td>
				<td><s:textfield name="sysMaintainVO.sysCustId"></s:textfield>
				</td>
			</tr>
			<tr>
				<td>开始维护时间:</td>
				<td><s:textfield cssClass="calendar"
						name="sysMaintainVO.maintainTimeStart" /></td>
				<td>结束维护时间:</td>
				<td><s:textfield cssClass="calendar"
						name="sysMaintainVO.maintainTimeEnd" /></td>
			</tr>
			<tr>
				<td>联系人名称:</td>
				<td><s:textfield name="sysMaintainVO.name"></s:textfield></td>
				<td>维护类型:</td>
				<td><s:select list="baseMaintaintypeVOs" listKey="id"
						listValue="maintaintypeName"
						name="sysMaintainVO.baseMaintaintypeId">
					</s:select></td>
			</tr>
			<tr>
				<td>活动描述:</td>
				<td colspan="3"><s:textarea name="sysMaintainVO.activeDesc"></s:textarea>
				</td>
			</tr>
			<tr>
				<td>维护结果:</td>
				<td colspan="3"><s:textarea name="sysMaintainVO.result"></s:textarea>
				</td>
			</tr>
			<tr>
				<td>备注:</td>
				<td colspan="3"><s:textarea name="sysMaintainVO.remark"></s:textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4" class="tdCenter"><s:submit value="确  定"
						onclick="return searchSubmit(this);" /> <s:submit value="关  闭"
						onclick="return closeThisWindow(this);" />
				</td>
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
