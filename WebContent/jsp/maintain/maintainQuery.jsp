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
		<s:form action="sysMaintainAction" namespace="/sysMaintain">
			<br>
			<table>
				<tr>
					<td>
						维护编号:
					</td>
					<td>
						<s:textfield name="sysMaintainVO.id"></s:textfield>
					</td>
					<td>
						客户编号:
					</td>
					<td>
						<s:textfield name="sysMaintainVO.sysCustId"></s:textfield>
					</td>
					<td>
						开始维护时间:
					</td>
					<td>
						<s:textfield cssClass="calendar" name="sysMaintainVO.maintainTimeStart" />
					</td>
					<td>
						结束维护时间:
					</td>
					<td>
						<s:textfield cssClass="calendar" name="sysMaintainVO.maintainTimeEnd" />
					</td>
					<td>
						联系人名称:
					</td>
					<td>
						<s:textfield name="sysMaintainVO.name"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						维护类型:
					</td>
					<td>
						<s:select list="baseMaintaintypeVOs" listKey="id"
							listValue="maintaintypeName"
							name="sysMaintainVO.baseMaintaintypeId">
						</s:select>
					</td>
					<td>
						活动描述:
					</td>
					<td>
						<s:textarea name="sysMaintainVO.activeDesc"></s:textarea>
					</td>
					<td>
						维护结果:
					</td>
					<td>
						<s:textarea name="sysMaintainVO.result"></s:textarea>
					</td>
					<td>
						备注:
					</td>
					<td colspan="3">
						<s:textarea name="sysMaintainVO.remark"></s:textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<s:submit value="查  询" action="sysMaintainAction!query"></s:submit>
						&nbsp;&nbsp;&nbsp;
						<s:reset value="重  置"></s:reset>
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
					<td></td>
				</tr>
				<tr>
					<td>
						<display:table name="list" class="simple"
							requestURI="sysMaintainAction!query">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxDecorator"
								style="width:3%;"
								title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
							</display:column>
							<display:column property="id" title="维护编号"></display:column>
							<display:column property="sysCustId" title="客户编号"></display:column>
							<display:column property="maintainTime" title="维护时间"
								format="{0,date,yyyy-MM-dd HH:mm}" sortable="true"></display:column>
							<display:column property="name" title="联系人名称"></display:column>
							<display:column property="baseMaintaintype.maintaintypeName"
								title="维护类型"></display:column>
							<display:column property="activeDesc" title="活动描述"></display:column>
							<display:column property="result" title="维护结果"></display:column>
							<display:column property="remark" title="备注"></display:column>
						</display:table>
					</td>
				</tr>
			</table>
			<hq:buttons function="18">
				<hq:button name="添加维护" mode="all"></hq:button>
				<hq:button name="修改维护" mode="single"></hq:button>
			</hq:buttons>
		</s:form>
	</body>
	<script type="text/javascript">
	$(function() {
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